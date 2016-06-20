package com.curriculum.web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.IOUtils;
import org.apache.fop.apps.FopFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    protected HttpMessageConverter<?> jacksonMessageConverter() {
        final MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
        final ObjectMapper objectMapper = httpMessageConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        httpMessageConverter.setObjectMapper(objectMapper);
        return httpMessageConverter;
    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }


    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }

    @Bean
    public FopFactory fopFactory(@Value("${fop.config.path:config}") String fopConfigPath) throws URISyntaxException, IOException, SAXException {
        final FopFactory fopFactory = FopFactory.newInstance();
        final File tempFile = File.createTempFile(UUID.randomUUID().toString(), ".xconf");

        if ("config".equals(fopConfigPath)) {
            fopConfigPath = Thread.currentThread().getContextClassLoader().getResource(fopConfigPath).getPath();
        }

        try (final FileInputStream fileInputStream = new FileInputStream(new File(fopConfigPath, "/fop.xconf"))) {
            final String configTemplate = IOUtils.toString(fileInputStream);
            final String configWithPath = configTemplate.replaceAll("CONFIG_PATH", fopConfigPath);
            IOUtils.write(configWithPath, new FileOutputStream(tempFile));
            fopFactory.setUserConfig(tempFile);
        } finally {
            tempFile.delete();
        }
        return fopFactory;
    }
}

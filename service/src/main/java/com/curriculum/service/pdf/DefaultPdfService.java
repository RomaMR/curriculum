package com.curriculum.service.pdf;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

@Service("defaultPdfService")
public class DefaultPdfService implements PdfService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPdfService.class);

  @Autowired
  @Qualifier("fopFactory")
  private FopFactory fopFactory;

  @Override
  public void convertToPDF(final File file, final String curriculumXML) throws Exception {
    LOGGER.info("DefaultPdfService.convertToPDF()");
    try (final OutputStream out = new java.io.FileOutputStream(file);
         final InputStream template = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/template.xsl");
         final InputStream curriculumXMLStream = IOUtils.toInputStream(curriculumXML, CharEncoding.UTF_8)
    ) {
      final Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(template));
      final FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
      final Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
      transformer.transform(new StreamSource(curriculumXMLStream), new SAXResult(fop.getDefaultHandler()));
    }
    LOGGER.info("DefaultPdfService.convertToPDF() finished");
  }

}

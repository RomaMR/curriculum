package com.curriculum.facade.curriculum;

import com.curriculum.converter.Converter;
import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.dto.curriculum.CurriculumPreviewDTO;
import com.curriculum.dto.pdf.CurriculumPDF;
import com.curriculum.exception.BadRequestException;
import com.curriculum.service.curriculum.CurriculumService;
import com.curriculum.service.pdf.PdfService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

@Component("defaultCurriculumFacade")
public class DefaultCurriculumFacade implements CurriculumFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCurriculumFacade.class);

    @Autowired
    @Qualifier("defaultCurriculumService")
    private CurriculumService curriculumService;

    @Autowired
    @Qualifier("defaultPdfService")
    private PdfService pdfService;

    @Autowired
    private XmlMapper xmlMapper;

    @Autowired
    @Qualifier("defaultCurriculumPreviewSerializer")
    private Converter<Curriculum, CurriculumPreviewDTO> curriculumPreviewSerializer;

    @Autowired
    @Qualifier("defaultCurriculumPDFSerializer")
    private Converter<Curriculum, CurriculumPDF> curriculumPDFSerializer;

    @Override
    public Curriculum find(final String id) {
        LOGGER.info("DefaultCurriculumFacade.find(), id={}", id);
        final Curriculum curriculum = curriculumService.find(id);
        LOGGER.info("DefaultCurriculumFacade.find() finished");
        return curriculum;
    }

    @Override
    public Curriculum save(final Curriculum curriculum) {
        LOGGER.info("DefaultCurriculumFacade.save()");
        final Curriculum persistentCurriculum = curriculumService.save(curriculum);
        LOGGER.info("DefaultCurriculumFacade.save() finished");
        return persistentCurriculum;
    }

    @Override
    public Page<CurriculumPreviewDTO> findAllPreviews(final Pageable pageable, final String search) {
        LOGGER.info("DefaultCurriculumFacade.findAllPreviews(), search={}", search);
        final Page<Curriculum> page = curriculumService.findAll(pageable, search);
        final List<CurriculumPreviewDTO> curriculumPreviewDTOs = curriculumPreviewSerializer.convertAll(page.getContent());
        LOGGER.info("DefaultCurriculumFacade.findAllPreviews() finished");
        return new PageImpl<>(curriculumPreviewDTOs, pageable, page.getTotalPages());
    }

    @Override
    public void update(final String id, final Curriculum curriculum) {
        LOGGER.info("DefaultCurriculumFacade.update(), id", id);

        final Curriculum persistentCurriculum = curriculumService.find(id);
        if (!persistentCurriculum.getCreatedBy().equals(curriculum.getCreatedBy())) {
            final String message = "You can not update curriculums created by another people";
            LOGGER.error("DefaultCurriculumService.update(), id={}, message={}", id, message);
            throw new BadRequestException(message);
        }

        curriculum.setId(id);
        curriculumService.save(curriculum);
        LOGGER.info("DefaultCurriculumFacade.update() finished");
    }

    @Override
    public byte[] getPdf(final String id) throws Exception {
        LOGGER.info("DefaultCurriculumFacade.getPdf(), id={}", id);

        final Curriculum curriculum = curriculumService.find(id);
        final CurriculumPDF curriculumPDF = curriculumPDFSerializer.convert(curriculum);
        final String curriculumXML = xmlMapper.writeValueAsString(curriculumPDF);

        final File tempFile = File.createTempFile(UUID.randomUUID().toString(), ".pdf");
        pdfService.convertToPDF(tempFile, curriculumXML);
        try (final FileInputStream fileInputStream = new FileInputStream(tempFile)) {
            final byte[] pdf = IOUtils.toByteArray(fileInputStream);
            LOGGER.info("DefaultCurriculumFacade.getPdf() finished");
            return pdf;
        } finally {
            tempFile.delete();
        }
    }
}

package com.curriculum.service.pdf;

import java.io.File;

public interface PdfService {
    void convertToPDF(File file, String curriculumXML) throws Exception;
}

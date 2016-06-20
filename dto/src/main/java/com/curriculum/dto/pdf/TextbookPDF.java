package com.curriculum.dto.pdf;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "module")
public class TextbookPDF {

  private Integer code;

  private String description;

  public TextbookPDF() {
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(final Integer code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

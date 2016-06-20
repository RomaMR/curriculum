package com.curriculum.dto.pdf;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "module")
public class ModulePDF {

    private Integer code;

    private String name;

    private String description;

    private Integer lectures;

    private Integer laboratories;

    public ModulePDF() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getLectures() {
        return lectures;
    }

    public void setLectures(final Integer lectures) {
        this.lectures = lectures;
    }

    public Integer getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(final Integer laboratories) {
        this.laboratories = laboratories;
    }
}

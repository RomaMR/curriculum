package com.curriculum.dto.check;

public class CheckDTO {

    private String condition;

    private Boolean value;

    public CheckDTO() {
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(final String condition) {
        this.condition = condition;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(final Boolean value) {
        this.value = value;
    }
}

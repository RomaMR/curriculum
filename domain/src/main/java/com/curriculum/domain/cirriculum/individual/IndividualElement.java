package com.curriculum.domain.cirriculum.individual;

import java.math.BigDecimal;

public class IndividualElement {

    private Integer count;

    private BigDecimal durability;

    private Integer progress;

    public IndividualElement() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public BigDecimal getDurability() {
        return durability;
    }

    public void setDurability(final BigDecimal durability) {
        this.durability = durability;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(final Integer progress) {
        this.progress = progress;
    }
}

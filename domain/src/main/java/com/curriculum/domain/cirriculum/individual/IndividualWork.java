package com.curriculum.domain.cirriculum.individual;

public class IndividualWork {

    private IndividualElement laboratory;

    private IndividualElement colloquium;

    public IndividualWork() {
    }

    public IndividualElement getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(final IndividualElement laboratory) {
        this.laboratory = laboratory;
    }

    public IndividualElement getColloquium() {
        return colloquium;
    }

    public void setColloquium(final IndividualElement colloquium) {
        this.colloquium = colloquium;
    }
}

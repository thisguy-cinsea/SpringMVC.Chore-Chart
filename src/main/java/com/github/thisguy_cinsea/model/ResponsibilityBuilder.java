package com.github.thisguy_cinsea.model;

public class ResponsibilityBuilder {
    private String responsibilityId;
    private String responsibilityName;
    private String groupId;
    private Boolean isDeleted;

    public ResponsibilityBuilder setId(String responsibilityId) {
        this.responsibilityId = responsibilityId;
        return this;
    }

    public ResponsibilityBuilder setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
        return this;
    }

    public ResponsibilityBuilder setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public ResponsibilityBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public ResponsibilityBuilder setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted == 1;
        return this;
    }

    public Responsibility build() {
        return new Responsibility(responsibilityId, responsibilityName, groupId, isDeleted);
    }
}
package com.codegym.model;

public class BoxElectronic {
    private String language;
    private Integer pageSize;
    private boolean filter;
    private String signature;

    public BoxElectronic() {
    }

    public BoxElectronic(String language, int pageSize, boolean filter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

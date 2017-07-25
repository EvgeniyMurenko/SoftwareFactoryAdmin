package com.SoftwareFactoryAdmin.constant;


public enum MainPathEnum {
    mainPath("opt/tomcat/webapps/softwarefactoryadmin"),
    videoThumbnailsFilesPath("opt/tomcat/webapps/softwarefactoryadmin/thumbnails/");

    private String value;

    MainPathEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}


package com.red.configuration;

import io.jsondb.JsonDBTemplate;

public class DataSourceConfiguration {

    private static final String dbFilesLocation = "C:\\\\Git\\\\StudentsCatalog\\\\src\\\\main\\\\resources";
    private static final String baseScanPackage = "com.red.model";
    private static JsonDBTemplate INSTANCE;

    public static JsonDBTemplate jsonDBTemplate() {
        if (INSTANCE == null) {
            return new JsonDBTemplate(dbFilesLocation, baseScanPackage);
        }
        return INSTANCE;
    }

}

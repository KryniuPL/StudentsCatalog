package com.red;

import com.red.configuration.ApplicationConfiguration;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationConfiguration.prepareApplication();
        StudentsCatalogApplication studentsCatalogApplication = new StudentsCatalogApplication();
        studentsCatalogApplication.run();
    }
}

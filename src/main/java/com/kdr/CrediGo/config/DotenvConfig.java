package com.kdr.CrediGo.config;


import io.github.cdimascio.dotenv.Dotenv;

public class DotenvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static void loadEnv() {
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
    }
}

package com.github.thisguy_cinsea.utils;

import java.io.IOException;
import java.nio.file.Paths;

public class FileReader {
    private final String filename;
    public FileReader(String filename) {
        this.filename = filename;
    }
    @Override
    public String toString() {
        try {
            byte[] readAllBytes = java.nio.file.Files.readAllBytes(Paths.get( filename ));
            return new String( readAllBytes );
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
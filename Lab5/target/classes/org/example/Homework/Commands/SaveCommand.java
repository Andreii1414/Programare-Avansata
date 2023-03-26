package org.example.Homework.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Homework.Catalog;
import org.example.Homework.InvalidDataOrCommandException;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command{
    private String fileName;

    public SaveCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Salveaza informatiile catalogului intr-un fisier
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {

        if(catalog.getDocuments().size() == 0)
            throw new InvalidDataOrCommandException("Catalogul nu contine niciun document");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName),catalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

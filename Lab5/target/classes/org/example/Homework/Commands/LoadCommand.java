package org.example.Homework.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Homework.Catalog;
import org.example.Homework.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadCommand extends Command{

    private String fileName;

    public LoadCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Incarca informatiile unui catalog dintr-un fisier extern
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Catalog loadCatalog = objectMapper.readValue(new File(fileName), Catalog.class);
            //sterg toate documentele din catalog
            catalog.getDocuments().removeAll(catalog.getDocuments());
            //adaug toate documentele din catalogul in care am dat load, in catalog
            for(Document doc : loadCatalog.getDocuments())
            {
                catalog.addDocument(doc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

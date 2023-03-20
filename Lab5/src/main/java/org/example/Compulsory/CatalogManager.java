package org.example.Compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class CatalogManager {
    private Catalog catalog;

    /**
     * Constructor
     * @param catalog
     */
    public CatalogManager(Catalog catalog) {
        this.catalog = catalog;
    }

    public CatalogManager() {
        catalog = new Catalog();
    }

    /**
     * Adauga documente in catalog
     * @param document
     */
    public void addDocument(Document document)
    {
        catalog.addDocument(document);
    }

    /**
     * Sterge documente din catalog
     * @param document
     */
    public void removeDocument(Document document)
    {
        catalog.removeDocument(document);
    }

    /**
     * Apeleaza metoda toString din Catalog
     * @return
     */
    public String toString(){
        return catalog.toString();
    }

    /**
     * Salveaza continutul catalogului intr-un fisier folosind Jackson
     * @param fileName
     */
    public void save(String fileName){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), this.catalog);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Incarca catalogul dintr-un fisier extern
     * @param fileName
     */
    public void load(String fileName){
        try{
            ObjectMapper mapper = new ObjectMapper();
            this.catalog = mapper.readValue(new File(fileName), Catalog.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}

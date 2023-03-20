package org.example.Compulsory;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog();
        CatalogManager catalogManager= new CatalogManager(catalog);

        catalogManager.addDocument(
                new Document("C1", "Doc 1", "C:/users/documents",
                        Stream.of(
                                new Tag("Titlu", "A"),
                                new Tag("An", "2002")
                        ).collect(Collectors.toList())));

        catalogManager.addDocument(
                new Document("C2", "Doc 2", "https://profs.info.uaic.ro/~acf/java/labs/lab_05.html",
                        Stream.of(
                                new Tag("Titlu", "Lab 5 Java"),
                                new Tag("An", "2023")
                        ).collect(Collectors.toList())));


        catalogManager.save("catalog.json");


        CatalogManager loadCatalog = new CatalogManager();
        loadCatalog.load("catalog.json");
        System.out.println(loadCatalog);
    }
}
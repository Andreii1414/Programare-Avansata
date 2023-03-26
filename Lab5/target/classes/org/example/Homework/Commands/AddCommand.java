package org.example.Homework.Commands;

import org.example.Homework.Catalog;
import org.example.Homework.Document;
import org.example.Homework.InvalidDataOrCommandException;

public class AddCommand extends Command {

    private Document document;
    public AddCommand(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * Adauga in catalog un document dupa ce verifica daca id-ul, numele si path-ul sunt corecte
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {
        if(document.getId() == null || document.getId().isEmpty())
            throw new InvalidDataOrCommandException("Id-ul documentului este invalid");
        if(document.getName() == null || document.getName().isEmpty())
            throw new InvalidDataOrCommandException("Numele documentului este invalid");
        if(document.getPathUrl() == null || document.getPathUrl().isEmpty())
            throw new InvalidDataOrCommandException("Path-ul/Url-ul documentului este invalid");
        catalog.addDocument(document);
    }
}

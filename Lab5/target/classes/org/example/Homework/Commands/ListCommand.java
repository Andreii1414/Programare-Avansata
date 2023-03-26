package org.example.Homework.Commands;

import org.example.Homework.Catalog;
import org.example.Homework.Document;
import org.example.Homework.InvalidDataOrCommandException;

public class ListCommand extends Command{
    /**
     * Printeaza toate documentele daca exista cel putin un document in catalog
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {

        if(catalog.getDocuments().size() == 0)
            throw new InvalidDataOrCommandException("Catalogul nu contine niciun document");
        for(Document document : catalog.getDocuments()){
            System.out.println(document);
        }
    }
}

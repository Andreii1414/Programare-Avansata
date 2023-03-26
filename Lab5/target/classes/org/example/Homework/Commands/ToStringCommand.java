package org.example.Homework.Commands;

import org.example.Homework.Catalog;
import org.example.Homework.InvalidDataOrCommandException;

public class ToStringCommand extends Command{
    /**
     * Printeaza catalogul
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {

        if(catalog.getDocuments().size() == 0)
            throw new InvalidDataOrCommandException("Catalogul nu contine niciun document");

        System.out.println(catalog);
    }
}

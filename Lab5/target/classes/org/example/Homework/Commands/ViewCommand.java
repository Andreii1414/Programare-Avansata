package org.example.Homework.Commands;

import org.example.Homework.Catalog;
import org.example.Homework.Document;
import org.example.Homework.InvalidDataOrCommandException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand extends Command{
    private String id;

    public ViewCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Deschide documentul verificand daca este un document local sau un document de pe o pagina web
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {

        if(catalog.getDocuments().size() == 0)
            throw new InvalidDataOrCommandException("Catalogul nu contine niciun document");

        Document document = catalog.findById(id);

        if(document != null){
            try {
                if(document.isPath())
                    Desktop.getDesktop().open(new File(document.getPathUrl()));
                else Desktop.getDesktop().browse(new URI(document.getPathUrl()));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

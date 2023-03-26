package org.example.Homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Document> documents = new ArrayList<>();

    /**
     * Constructor
     * @param documents
     */
    public Catalog(List<Document> documents) {
        this.documents = documents;
    }

    public Catalog() {
    }

    /**
     * Getter
     * @return documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Setter pentru documents
     * @param documents
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Adauga un document in lista
     * @param document
     */
    public void addDocument(Document document)
    {
        documents.add(document);
    }

    /**
     * Sterge un document din lista (daca exista)
     * @param document
     */
    public void removeDocument(Document document)
    {
        if(documents.contains(document))
            documents.remove(document);
    }

    public Document findById(String id)
    {
        for(Document doc : documents)
        {
            if (doc.getId().equals(id))
                return doc;
        }

        return null;
    }



    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }
}

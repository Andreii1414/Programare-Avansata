package org.example.Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String id;
    private String name;
    private String pathUrl;
    private List<Tag> tags = new ArrayList<>();

    /**
     * Constructor
     * @param id
     * @param name
     * @param pathUrl
     * @param tags
     */
    public Document(String id, String name, String pathUrl, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.pathUrl = pathUrl;
        this.tags = tags;
    }
    public Document() {
    }

    /**
     * Getter
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter pentru id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return pathUrl
     */
    public String getPathUrl() {
        return pathUrl;
    }

    /**
     * Setter pentru path/url
     * @param pathUrl
     */
    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    /**
     * getter
     * @return tag list
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * Setter pentru tags
     * @param tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Adauga un tag in lista cu tag-uri
     * @param tag
     */
    public void addTag(Tag tag)
    {
        tags.add(tag);
    }

    /**
     * Sterge un tag din lista (daca exista)
     * @param tag
     */
    public void removeTag(Tag tag)
    {
        if(tags.contains(tag))
            tags.remove(tag);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path or Url='" + pathUrl + '\'' +
                ", tags=" + tags +
                '}';
    }
}

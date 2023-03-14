package Homework;

import java.util.Map;

public interface Node extends Comparable<Node> {
    /**
     * Getter
     * @return name
     */
    String getName();

    /**
     * Getter
     * @return relationshipMap
     */
    Map<Node, RelationshipType> getRelationshipMap();

    /**
     * Setter pentru importance
     * @param importance
     */
    void setImportance(int importance);

    /**
     * Getter
     * @return importance
     */
    int getImportance();
}

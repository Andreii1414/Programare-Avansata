package Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    /**
     * Constructor
     * @param nodes
     */
    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Constructor default
     */
    public Network() {
    }

    /**
     * Getter
     * @return lista de noduri
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Setter
     * @param nodes
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Adauga un nod in lista
     * @param node
     */
    public void addNode(Node node)
    {
        nodes.add(node);
    }

    /**
     * Calculeaza importanta pentru un singur nod (size-ul map-ului)
     * @param node
     */
    public void computeImportanceOneNode(Node node)
    {
        node.setImportance(node.getRelationshipMap().size());
    }

    /**
     * Calculeaza importanta pentru toata reteaua
     */
    public void computeImportanceAllNodes()
    {
        for(Node node : nodes)
        {
            computeImportanceOneNode(node);
        }
    }

    /**
     * @return lista nodurilor ordonata dupa importanta
     */
    public List<Node> getByImportance(){
        List<Node> nodeList = new ArrayList<>(nodes);
        nodeList.sort(Comparator.comparingInt(Node::getImportance).reversed());
        return nodeList;
    }
}

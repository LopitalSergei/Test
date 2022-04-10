package laptev.test.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    boolean visited;
    List<Node> neighbours;

    public Node(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Node neighbourNode) {
        this.neighbours.add(neighbourNode);
    }

    public void addNeighbours(ArrayList<Country> countries) {
        for (Country country : countries) {
            this.neighbours.add(new Node(country.getCountryCode()));
        }
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }
}

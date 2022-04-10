package laptev.test.model;

import laptev.test.service.CountryService;

import java.util.*;


public class Graph {
    Queue<Node> queue;
    ArrayList<Node> nodes = new ArrayList<Node>();
    CountryService countryService;

    public Graph(CountryService countryService) {
        queue = new LinkedList<>();
        this.countryService = countryService;
    }
    public Graph() {
        queue = new LinkedList<>();
    }

    public void bfs(Node node, Node end) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            System.out.println(element.name);

            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public ArrayList<String> dfs(Node node, Node end, ArrayList<String> route) {
        List<Node> neighbours = node.getNeighbours();
        route.add(node.name);
        node.visited = true;

        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                String country = n.getName();
                Country countr = countryService.read(country);
                String bordersF = countr.getBorders();
                String[] bordersFrom = bordersF.split(", ");
                ArrayList<Country> borders = new ArrayList<>();
                for (String s : bordersFrom) {
                    borders.add(countryService.read(s));
                }
                n.addNeighbours(borders);
                dfs(n, end, route);
            }
        }
        return route;
    }
}

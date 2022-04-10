package laptev.test.model;

import laptev.test.service.CountryService;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private static Country from;
    private static Country to;

    public Route(Country from, Country to) {
        Route.from = from;
        Route.to = to;
    }

    public List<String> routing(CountryService countryService) {

        String bordersF = from.getBorders();
        String[] bordersFrom = bordersF.split(", ");
        ArrayList<Country> borders = new ArrayList<>();
        for (String s : bordersFrom) {
            borders.add(countryService.read(s));
        }

        String cc3From = from.getCountryCode();
        String cc3To = to.getCountryCode();

        ArrayList<String> route = new ArrayList<>();

        Graph graph = new Graph(countryService);
        Node f = new Node(cc3From);
        f.addNeighbours(borders);
        Node t = new Node(cc3To);
        route = graph.dfs(f, t, route);

        return route;
    }
}

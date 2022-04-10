package laptev.test.tmp;

import laptev.test.model.Graph;
import laptev.test.model.Node;

public class Main {
    public static void main(String[] args) {
        Node BLR = new Node("BLR");
        Node RUS = new Node("RUS");
        Node AZE = new Node("AZE");
        Node POL = new Node("POL");
        Node UKR = new Node("UKR");
        Node DEU = new Node("DEU");
        Node KAZ = new Node("KAZ");

        BLR.addNeighbours(RUS);
        BLR.addNeighbours(POL);
        BLR.addNeighbours(UKR);
        RUS.addNeighbours(AZE);
        RUS.addNeighbours(KAZ);
        RUS.addNeighbours(POL);
        RUS.addNeighbours(UKR);
        RUS.addNeighbours(BLR);
        AZE.addNeighbours(RUS);
        KAZ.addNeighbours(RUS);
        POL.addNeighbours(DEU);
        POL.addNeighbours(BLR);
        POL.addNeighbours(RUS);
        POL.addNeighbours(UKR);
        UKR.addNeighbours(BLR);
        UKR.addNeighbours(RUS);
        UKR.addNeighbours(POL);
        DEU.addNeighbours(POL);

        Graph graph = new Graph();
//        ArrayList<String> route = new ArrayList<>();
        graph.bfs(BLR, KAZ);
//        graph.depthFirstTraversal(BLR);

    }
}

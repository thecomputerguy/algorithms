package bfs.shortestreachproblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestReachProblem {

    public static int[] shortestReach(int startId) {

        Node[] nodes = new Node[5];
        nodes[0] = new Node(0);
        nodes[1] = new Node(1);
        nodes[2] = new Node(2);
        nodes[3] = new Node(3);
        nodes[4] = new Node(4);

        Graph graph = new Graph(nodes);
        graph.addEdge(nodes[0].id, nodes[1].id);
        graph.addEdge(nodes[1].id, nodes[2].id);
        graph.addEdge(nodes[2].id, nodes[3].id);
        graph.addEdge(nodes[3].id, nodes[4].id);
        graph.addEdge(nodes[4].id, nodes[2].id);
        return shortestReach(startId, graph);
    }

    public static int[] shortestReach(int startId, Graph graph) {

        LinkedList<Integer> queue = new LinkedList<>();
        int[] distances = new int[graph.nodes.length];
        Arrays.fill(distances, -1);
        queue.add(startId);
        distances[startId] = 0;

        while (!queue.isEmpty()) {

            int id = queue.poll();
            Node node = graph.nodes[id];

            for (Node neighbour : node.adjacent) {

                if (distances[neighbour.id] == -1) {

                    distances[neighbour.id] = distances[id] + Graph.EDGE_DISTANCE;
                    queue.add(neighbour.id);
                }

            }

        }

        return distances;
    }

    public static void main(String[] args) {

        int[] distances = shortestReach(0);
        System.out.println("Distance to each node from the starting node 1 is: ");
        for (int i : distances) {
            System.out.print(i + " ");
        }
    }
}

class Graph {

    Node[] nodes;
    public static int EDGE_DISTANCE = 5;

    public Graph(Node[] nodes) {

        this.nodes = nodes;
    }

    public Node getNode(int id) {

        if (id < 0 && id >= nodes.length) {

            throw new IllegalArgumentException("Node with given id does not exist.");
        }
        return nodes[id];
    }

    public void addEdge(int from, int to) {

        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        fromNode.adjacent.add(toNode);
    }

}

class Node {

    int id;
    Set<Node> adjacent = new HashSet<>();

    public Node(int id) {
        this.id = id;
    }

}
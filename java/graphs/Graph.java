package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph {

    private Map<Integer, Node> nodeLookup = new HashMap<>();

    public void addEdge(int from, int to) {

        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        fromNode.adjacentNodes.add(toNode);
    }

    private Node getNode(int id) {

        if(!this.nodeLookup.containsKey(id)){

            throw new IllegalArgumentException(String.format("Node with given id %s does not exist", id));
        }

        return this.nodeLookup.get(id);
    }

    public boolean hasPathDFS(int source, int destination) {

        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        return hasPathDFS(sourceNode, destinationNode, new HashSet<>());
    }

    private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {

        //If visited then return false.
        if(visited.contains(source.id)){

            return false;
        }

        //Mark the current node as visited.
        visited.add(source.id);

        //If source == destination then we have found the node that we were looking for, so return true.
        if(source == destination){

            return true;
        }

        for (Node adjacent : source.adjacentNodes) {
            
            hasPathDFS(adjacent, destination, visited);
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination) {

        //Pull the source and destination node from the nodeLookup, so that we don't have to do look up again and again.
        Node sourceNode = getNode(source);
        Node destNode = getNode(destination);

        Set<Integer> visited = new HashSet<>();
        LinkedList<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(sourceNode);
        
        while(!nextToVisit.isEmpty()){

            //Get the first node from the queue.
            Node node = nextToVisit.remove();
            
            //check if it is visited. If it is visited, then skip over the node 
            //and fetch another from queue.
            if(visited.contains(node.id)){
                continue;
            }

            //Node is not visited and we are visiting it for the first time, so mark the node as visited.
            visited.add(node.id);
            
            //check if the source and destination are same. If they are same, return true.
            if(node == destNode){

                return true;
            }

            //If the current node is not the destination node 
            //then put all the adjacent nodes of the current node to nextToVisit queue and keep visiting them
            //until we reach destination or end of path.
            for (Node adjacent : node.adjacentNodes) {
                nextToVisit.add(adjacent);
            }

        }

        return false;

    }

    public static void main(String[] args) {

        System.out.println("Creating a graph:");
        Graph graph = new Graph();
        System.out.println("Add few nodes in the graph:");
        System.out.println("Enter the number of nodes you wish to add to graph");

        try (Scanner scan = new Scanner(System.in)) {

            int num = scan.nextInt();
            int i = 0;
            while (i < num) {

                System.out.println("Enter the node id:");
                int nodeId = scan.nextInt();
                graph.nodeLookup.put(nodeId, new Node(nodeId));
                i++;
            }

            System.out.println("Add edges :");

            System.out.println("Enter the number of edges you want to add: ");
            int numOfEdges = scan.nextInt();

            int k = 0;
            while(k < numOfEdges){

                System.out.println("Add edge from : ");
                int from = scan.nextInt();
                System.out.println("Add edge to : ");
                int to = scan.nextInt();
                graph.addEdge(from, to);
                k++;
            }

            System.out.println("Graph created.");

            System.out.println("Doing Depth first search on graph");
            System.out.println("Enter the source node:");
            int source = scan.nextInt();
            System.out.println("Enter the destination node: ");
            int destination = scan.nextInt();
            System.out.println("has path : " + graph.hasPathBFS(source, destination)); 

            System.out.println("Doing Breadth first search on graph:");
            System.out.println("has path " + graph.hasPathBFS(source, destination));
        }

    }
}

class Node {

    int id;
    LinkedList<Node> adjacentNodes = new LinkedList<>();

    public Node(int id) {

        this.id = id;
    }
}
package com.connected.connectedcity.util;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
public class Graph
{
    private Map<String, LinkedHashSet<String>> map = new HashMap();
 
    public void addEdge(String node1, String node2)
    {
        LinkedHashSet<String> adjacent = map.get(node1);
        if (adjacent == null)
        {
            adjacent = new LinkedHashSet();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }
 
    public void addTwoWayVertex(String node1, String node2)
    {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }
 
    public boolean isConnected(String node1, String node2)
    {
        Set adjacent = map.get(node1);
        if (adjacent == null)
        {
            return false;
        }
        return adjacent.contains(node2);
    }
 
    public LinkedList<String> adjacentNodes(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedList();
        }
        return new LinkedList<String>(adjacent);
    }
 
    public static String  START;
    public static String  END;
    private static boolean flag;
 
    public String breadthFirst(Graph graph,
            LinkedList<String> visited)
    {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
 
        for (String node : nodes)
        {
            if (visited.contains(node))
            {
                continue;
            }
            if (node.equals(END))
            {
                visited.add(node);
                printPath(visited);
                flag = true;
                visited.removeLast();
                //break;
                return "YES";
            }
        }
 
        for (String node : nodes)
        {
            if (visited.contains(node) || node.equals(END))
            {
                continue;
            }
            visited.addLast(node);
            breadthFirst(graph, visited);
            visited.removeLast();
        }
        if (flag == false)
        {
            System.out.println("No path Exists between " + START + " and "
                    + END);
            flag = true;
            return "NO";
        }
        return "NO";
    }
 
    private void printPath(LinkedList<String> visited)
    {
        if (flag == false)
            System.out.println("Yes there exists a path between " + START
                    + " and " + END);
 
        for (String node : visited)
        {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
    }
}
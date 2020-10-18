package com.connected.connectedcity.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CityGraph {

	@Autowired
	ResourceLoader resourceLoader;

	public String isConnected(String src, String dest) throws IOException {

		Map<String, String> inputCities = new HashMap<>();
		Resource resource = resourceLoader.getResource("classpath:data/city.txt");
		InputStream input = resource.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		Graph graph = new Graph();

		while (reader.ready()) {
			String line = reader.readLine();
			String array[] = line.split(",");
			graph.addEdge(array[0], array[1]);
		}

		LinkedList<String> visited = new LinkedList();
		Graph.START = src;
		Graph.END = dest;
		visited.add(Graph.START);
		return new Graph().breadthFirst(graph, visited);

	}

}
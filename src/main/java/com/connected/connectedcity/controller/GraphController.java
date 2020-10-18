package com.connected.connectedcity.controller;

import com.connected.connectedcity.util.CityGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GraphController {

	@Autowired
	CityGraph cityGraph;

	@GetMapping("/connected")
	public String isConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination)
			throws IOException {

		return cityGraph.isConnected(origin,destination);

	}

}

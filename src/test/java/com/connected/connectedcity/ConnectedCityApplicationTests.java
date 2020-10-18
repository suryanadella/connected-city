package com.connected.connectedcity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.connected.connectedcity.util.CityGraph;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConnectedCityApplicationTests {

	@Test
	public void whenCitiesAreConnected() {
			CityGraph cityGraph= new CityGraph();
			
	      String isConnected;
		try {
			
			isConnected = cityGraph.isConnected("Boston","New York");
			Assert.assertEquals("YES", isConnected);
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	   }
	
	@Test
	public void whenCitiesAreNotConnected() {
			CityGraph cityGraph= new CityGraph();
			
	      String isConnected;
		try {
			
			isConnected = cityGraph.isConnected("Boston","LA");
			Assert.assertEquals("NO", isConnected);
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	   }

}

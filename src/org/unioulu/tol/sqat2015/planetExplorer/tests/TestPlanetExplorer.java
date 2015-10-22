package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testPlanetSizeHundredByHundredNoObstacles() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		int[] expected = new int[]{100, 100};
		int[] actual = pe.getPlanetDimensionsXY();
		
		assertArrayEquals(expected, actual);
	}
}

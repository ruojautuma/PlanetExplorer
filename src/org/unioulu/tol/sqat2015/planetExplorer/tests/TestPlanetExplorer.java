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
	
	@Test
	public void testPlanetSizeHundredByHundredTwoObstacles() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "(10,10)(64,32)");
		
		boolean expected = true;
		boolean actual = pe.isObstacleAt(10, 10) & pe.isObstacleAt(64, 32);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExplorerPositionZeroAndZeroOrientationNorth() {
		fail("not implemented");
	}
}

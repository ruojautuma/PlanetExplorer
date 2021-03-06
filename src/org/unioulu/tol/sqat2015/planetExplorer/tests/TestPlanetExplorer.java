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
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		boolean expected = (new int[]{0,0}).equals(new int[]{0,0}) &
							"N".equals("N");
		boolean actual = (new int[]{0,0}).equals(pe.getPositionXY()) &
				pe.getOrientation().equals("N");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMoveRightExplorerOrientationEast() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		pe.executeCommand("r");
		
		String expected = "E";
		String actual = pe.getOrientation();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTheConamiCodeOrientationNorth() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		pe.executeCommand("up up down down left right left right b a - do the conami code");
		
		String expected = "N";
		String actual = pe.getOrientation();
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testPositionOneAndZero() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		pe.executeCommand("rf");
		
		int[] expected = new int[]{1,0};
		int[] actual = pe.getPositionXY();
		
		assertArrayEquals(expected, actual);		
	}
	
	@Test
	public void testPositionZeroAndOne() {
		PlanetExplorer pe = new PlanetExplorer(100, 100, "");
		
		pe.executeCommand("rb");
		
		int[] expected = new int[]{0,1};
		int[] actual = pe.getPositionXY();
		
		assertArrayEquals(expected, actual);		
	}

}

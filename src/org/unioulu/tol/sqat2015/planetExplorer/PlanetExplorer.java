package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	private int[][] planet;
	private static final int OBS = 0x08571C13; //see what i did there? :)
	private int planetX, planetY;
	private int posX = 0, posY = 0;
	private int orientation = 0;
	private String[] oriental = new String[] {"N", "E", "S", "W"};
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.planetX = x;
		this.planetY = y;
		this.planet = new int[x][y];
		this.parseObstacles(obstacles);
	}
	
	public int[] getPlanetDimensionsXY() {
		return new int[]{this.planetX, this.planetY};
	}
	
	/**
	 * Not the prettiest solution, but I don't want to spend all day on regexp
	 */
	private void parseObstacles(String obstacles) {
		if(!(obstacles.startsWith("(") && obstacles.endsWith(")"))) {
			return;
		}
		obstacles = obstacles.trim();
		obstacles = obstacles.replace("(", "");
		String[] obs = obstacles.split("\\)");
		for(String tmp : obs) {
			String[] xy = tmp.split(",");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			this.planet[x][y] = OBS;
		}		
	}
	
	public boolean isObstacleAt(int x, int y) {
		return this.planet[x][y] == OBS;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		for(int i=0;i<command.length();i++) {
			if("l".equals(String.valueOf(command.charAt(i)))) {
				this.orientate(0);
			} else if("r".equals(String.valueOf(command.charAt(i)))) {
				this.orientate(1);
			} else if("f".equals(String.valueOf(command.charAt(i)))) {
				this.forward();
			} else if("b".equals(String.valueOf(command.charAt(i)))) {
				this.backward();
			}
		}
		
		return null;
	}
	
	private void forward() {
		if(this.orientation == 0) {
			this.posY++;
		} else if(this.orientation == 1) {
			this.posX++;
		} if(this.orientation == 2) {
			this.posY--;
		} if(this.orientation == 3) {
			this.posX--;
		}
	}
	
	private void backward() {
		if(this.orientation == 0) {
			this.posY--;
		} else if(this.orientation == 1) {
			this.posX--;
		} if(this.orientation == 2) {
			this.posY++;
		} if(this.orientation == 3) {
			this.posX++;
		}
	}
	
	private void orientate(int ori) {
		if(ori == 0) {
			this.orientation--;
		} else {
			this.orientation++;
		}
		if(this.orientation < 0) {
			this.orientation = 3;
		} else if(this.orientation > 3) {
			this.orientation = 0;
		}
	}
	
	public int[] getPositionXY() {
		return new int[] {this.posX, this.posY};
	}
	
	public String getOrientation() {
		return this.oriental[this.orientation];
	}
}

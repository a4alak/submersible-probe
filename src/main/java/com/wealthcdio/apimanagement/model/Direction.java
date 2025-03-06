package com.wealthcdio.apimanagement.model;

/*
 * values() returns all enum values: [NORTH, EAST, SOUTH, WEST]
            ordinal() gives the index of the current direction
   
   Example:    
  Current Direction	        ordinal()	     (ordinal() + 1) % 4		New Direction
  NORTH (0)	     			0	            	(0 + 1) % 4 = 1				EAST
  EAST (1)	     			1	            	(1 + 1) % 4 = 2				SOUTH
  SOUTH (2)	     			2	            	(2 + 1) % 4 = 3				WEST
  WEST (3)	     			3	            	(3 + 1) % 4 = 0				NORTH

 */
public enum Direction {

	NORTH, EAST, SOUTH, WEST;

	//(ordinal() + 1) % 4 moves to the next direction in a circular way.
	public Direction moveToRightSide() {

		return values()[(ordinal() + 1) % 4];
	}

	//(ordinal() + 3) % 4 moves to the previous direction in a circular way.
	public Direction moveToLeftSide() {

		return values()[(ordinal() + 3) % 4];
	}

}

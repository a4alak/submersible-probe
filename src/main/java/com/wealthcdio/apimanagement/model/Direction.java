package com.wealthcdio.apimanagement.model;

public enum Direction {

	NORTH, EAST, SOUTH, WEST;

	public Direction moveToRightSide() {

		return switch (this) {
		case NORTH -> EAST;
		case EAST -> SOUTH;
		case SOUTH -> WEST;
		case WEST -> NORTH;

		};
	}

	public Direction moveToLeftSide() {

		return switch (this) {
		case NORTH -> WEST;
		case WEST -> SOUTH;
		case SOUTH -> EAST;
		case EAST -> NORTH;
		};
	}

}

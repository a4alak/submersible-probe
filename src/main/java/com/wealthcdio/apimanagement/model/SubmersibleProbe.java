package com.wealthcdio.apimanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubmersibleProbe {
	private int x_axis, y_axis;
	private Direction directionMoveed;
	private final List<Position> visitedLocation = new ArrayList<Position>();

	public SubmersibleProbe(int x, int y, Direction directionMoveed) {
		this.x_axis = x;
		this.y_axis = y;
		this.directionMoveed = directionMoveed;
		visitedLocation.add(new Position(x, y));
	}

	public String getThePosition() {
		return visitedLocation.stream().map(p -> "(" + p.getX_axix() + " , " + p.getY_axix() + ")")
				.collect(Collectors.joining());
	}

	public void trunLeftDirection() {
		directionMoveed = directionMoveed.moveToLeftSide();
	}

	public void trunRightDirection() {
		directionMoveed = directionMoveed.moveToRightSide();
	}

	public void moveProbeForward(Grid grid) {
		int new_x = x_axis, new_y = y_axis;

		switch (directionMoveed) {
		case NORTH -> new_y += 1;
		case EAST -> new_x += 1;
		case SOUTH -> new_y += 1;
		case WEST -> new_x += 1;
		}
		if (grid.isWintinlimit(new_x, new_y) && !grid.isObstacle(new_x, new_y)) {
			x_axis = new_x;
			y_axis = new_y;
			visitedLocation.add(new Position(x_axis, y_axis));
		}
	}

	public void moveProbeBackward(Grid grid) {

		int new_x = x_axis, new_y = y_axis;

		switch (directionMoveed) {
		case NORTH -> new_y -= 1;
		case EAST -> new_x -= 1;
		case SOUTH -> new_y -= 1;
		case WEST -> new_x -= 1;
		}
		if (grid.isWintinlimit(new_x, new_y) && !grid.isObstacle(new_x, new_y)) {
			x_axis = new_x;
			y_axis = new_y;
			visitedLocation.add(new Position(x_axis, y_axis));
		}
	}

}

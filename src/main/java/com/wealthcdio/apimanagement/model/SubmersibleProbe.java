package com.wealthcdio.apimanagement.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class SubmersibleProbe {
	private int x_axis, y_axis;
	private Direction directionMoveed;
	private final Set<String> visitedLocation;

	public SubmersibleProbe(int x, int y, Direction directionMoveed) {
		super();
		this.x_axis = x;
		this.y_axis = y;
		this.directionMoveed = directionMoveed;
		this.visitedLocation = new LinkedHashSet<String>();
		visitedDone();
	}

	private void visitedDone() {
		visitedLocation.add(x_axis + "," + y_axis);
	}

	public String getThePosition() {
		return x_axis + "," + y_axis + " direction facing " + directionMoveed;
	}

	public Set<String> getVisitedLocation() {
		return visitedLocation;
	}

	public void trunLeftDirection() {
		directionMoveed = directionMoveed.moveToLeftSide();
	}

	public void trunRightDirection() {
		directionMoveed = directionMoveed.moveToRightSide();
	}

	public void moveProbe(Grid grid, boolean forward) {

		int new_X = x_axis, new_Y = y_axis;
		
		// here North and South in Y axis and East and West in X axis
		
		switch (directionMoveed) {
			case NORTH -> new_Y += forward ? 1 : -1;
			case SOUTH -> new_Y += forward ? -1 : 1;
			case EAST -> new_X += forward ? 1 : -1;
			case WEST -> new_X += forward ? -1 : 1;
		}

		if (grid.isWintinlimit(new_X, new_Y) && !grid.isObstacle(new_X, new_Y)) {
			this.x_axis = new_X;
			this.y_axis = new_Y;
			visitedDone();
		}
	}

}

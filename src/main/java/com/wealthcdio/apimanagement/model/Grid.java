package com.wealthcdio.apimanagement.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {

	private final int width;
	private final int height;
	private final Set<Position> obstacles = new HashSet<Position>();

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void addObstacle(int x, int y) {
		obstacles.add(new Position(x, y));
	}

	public boolean isWintinlimit(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}

	public boolean isObstacle(int x, int y) {
		return obstacles.contains(new Position(x, y));
	}

}

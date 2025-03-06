package com.wealthcdio.apimanagement.dto;

import java.util.List;

import com.wealthcdio.apimanagement.model.Direction;

public class InstructionCommand {

	private int gridSizeX;
	private int gridSizeY;
	private int startX;
	private int startY;
	private Direction initialDirection;
	private List<int[]> obstacles;
	private List<String> commands;

	public InstructionCommand() {
	}

	public InstructionCommand(int gridSizeX, int gridSizeY, int startX, int startY, Direction initialDirection,
			List<int[]> obstacles, List<String> commands) {
		this.gridSizeX = gridSizeX;
		this.gridSizeY = gridSizeY;
		this.startX = startX;
		this.startY = startY;
		this.initialDirection = initialDirection;
		this.obstacles = obstacles;
		this.commands = commands;
	}

	public List<String> getCommands() {
		return commands;
	}

	public void setCommands(List<String> commands) {
		this.commands = commands;
	}

	public int getGridSizeX() {
		return gridSizeX;
	}

	public void setGridSizeX(int gridSizeX) {
		this.gridSizeX = gridSizeX;
	}

	public int getGridSizeY() {
		return gridSizeY;
	}

	public void setGridSizeY(int gridSizeY) {
		this.gridSizeY = gridSizeY;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public Direction getInitialDirection() {
		return initialDirection;
	}

	public void setInitialDirection(Direction initialDirection) {
		this.initialDirection = initialDirection;
	}

	public List<int[]> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<int[]> obstacles) {
		this.obstacles = obstacles;
	}

}

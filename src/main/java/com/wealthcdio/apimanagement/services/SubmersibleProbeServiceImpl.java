package com.wealthcdio.apimanagement.services;

import org.springframework.stereotype.Service;

import com.wealthcdio.apimanagement.dto.InstructionCommand;
import com.wealthcdio.apimanagement.model.Grid;
import com.wealthcdio.apimanagement.model.SubmersibleProbe;

@Service
public class SubmersibleProbeServiceImpl implements ISubmersibleProbeService {

	private Grid grid;
	private SubmersibleProbe probe;

	public String commandsProvided(InstructionCommand request) {

		initializePosition(request);

		for (String command : request.getCommands()) {
			switch (command.toUpperCase()) {
			case "FORWARD" -> probe.moveProbeForward(grid);
			case "BACKWARD" -> probe.moveProbeBackward(grid);
			case "LEFT" -> probe.trunLeftDirection();
			case "RIGHT" -> probe.trunRightDirection();
			default -> throw new IllegalArgumentException("Invalid command: " + command);
			}
		}
		return probe.getThePosition();
	}

	private void initializePosition(InstructionCommand request) {

		this.grid = new Grid(request.getGridSizeX(), request.getGridSizeY());
		this.probe = new SubmersibleProbe(request.getStartX(), request.getStartY(), request.getInitialDirection());

		for (int[] obstacle : request.getObstacles()) {
			grid.addObstacle(obstacle[0], obstacle[1]);
		}
	}

	public String getVisitedPositions() {
		return probe.getThePosition();
	}

}

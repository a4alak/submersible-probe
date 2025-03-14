package com.wealthcdio.apimanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wealthcdio.apimanagement.dto.InstructionCommand;
import com.wealthcdio.apimanagement.model.Direction;
import com.wealthcdio.apimanagement.services.ISubmersibleProbeService;
import com.wealthcdio.apimanagement.services.SubmersibleProbeServiceImpl;

/*
 * Testing the actual business logic of SubmersibleProbeServiceImpl end-to-end (without external dependencies like databases or web layers)
 * 
 *  run any of the  below command to see the test report 
 * 
 *  mvn clean install 
 *  mvn clean test jacoco:report
 *  mvn clean verify
 *  mvn -Dtest=SubmersibleProbeJunitTest test
 *  mvn -Dtest=SubmersibleProbeIntegrationTests test
 *  
 * test report location : target/site/jacoco/index.html
 * */
public class SubmersibleProbeJunitTest {

	private ISubmersibleProbeService probeService;
	private int gridSizeX;
	private int gridSizeY;
	private List<int[]> obstacles;

	@BeforeEach
	void setUp() {
		probeService = new SubmersibleProbeServiceImpl();
		gridSizeX = 6;
		gridSizeY = 6;
		obstacles = List.of(new int[] { 2, 2 }, new int[] { 3, 3 });
	}

	/**
	 * Test Case: Grid Boundaries - Probe should stop at the edge of the grid.
	 */
	@Test
	void testGridboundaries() {
		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 1, 1, Direction.EAST, obstacles,
				List.of("FORWARD", "FORWARD", "FORWARD", "FORWARD", "FORWARD"));

		String result = probeService.commandsProvided(request);

		String[] visitedCoordinates = result.trim().split("\\)");
		String lastPosition = (visitedCoordinates[visitedCoordinates.length - 1] + ")").trim();
		assertEquals("(5 , 1)", lastPosition);
	}

	/**
	 * Test Case: Obstacle Avoidance - Probe should stop before hitting an obstacle.
	 */
	@Test
	public void testStopBeforehittingAnObstacle() throws Exception {
		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 1, 1, Direction.EAST, obstacles,
				List.of("FORWARD", "RIGHT", "FORWARD", "FORWARD", "LEFT", "BACKWARD"));

		String result = probeService.commandsProvided(request);
		assertEquals("(1 , 1)(2 , 1)(1 , 1)", result);
	}

	/**
	 * Test Case: Invalid Commands - API should return bad request for invalid
	 * commands.
	 */
	@Test
	public void testInvalidCommand() {
		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 1, 1, Direction.EAST, obstacles,
				List.of("X"));

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			probeService.commandsProvided(request);
		});

		assertEquals("Invalid command: X", exception.getMessage());
	}

	/**
	 * Test Case: Repeated Commands & Correct Tracking - Ensure that repeated moves
	 * are tracked correctly.
	 */
	@Test
	public void testRepeatedMoves() throws Exception {
		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 1, 1, Direction.EAST, obstacles,
				List.of("FORWARD", "FORWARD", "FORWARD", "FORWARD", "FORWARD"));

		String result = probeService.commandsProvided(request);

		String[] visitedCoordinates = result.trim().split("\\)");
		String lastPosition = (visitedCoordinates[visitedCoordinates.length - 1] + ")").trim();
		assertEquals("(5 , 1)", lastPosition);

	}

	/**
	 * Test Case: Edge Grid Handling - Probe should handle movement when starting at
	 * grid edges.
	 */
	@Test
	public void testStartingatGridedges() throws Exception {

		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 6, 1, Direction.EAST, List.of(),
				List.of("FORWARD", "FORWARD"));

		String result = probeService.commandsProvided(request);
		assertEquals("(6 , 1)", result);
	}

	/**
	 * Test Case: Full Rotation Ensure 360-degree rotation works correctly.
	 */
	@Test
	public void testFullRotation() throws Exception {
		InstructionCommand request = new InstructionCommand(gridSizeX, gridSizeY, 1, 1, Direction.EAST, obstacles,
				List.of("RIGHT", "RIGHT", "RIGHT", "RIGHT"));

		probeService.commandsProvided(request);
		String visited = probeService.getVisitedPositions();
		assertEquals("(1 , 1)", visited);
	}
}

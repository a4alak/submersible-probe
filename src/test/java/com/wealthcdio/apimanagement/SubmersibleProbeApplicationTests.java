package com.wealthcdio.apimanagement;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wealthcdio.apimanagement.dto.InstructionCommand;
import com.wealthcdio.apimanagement.model.Direction;

@SpringBootTest
@AutoConfigureMockMvc
class SubmersibleProbeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Test Case:Probe should not go beyond the grid boundaries.
	 */
	@Test
	public void testGridboundaries() throws Exception {
		InstructionCommand request = new InstructionCommand(6, 6, 1, 1, Direction.EAST,
				List.of(new int[] { 2, 2 }, new int[] { 3, 3 }),
				List.of("FORWARD", "FORWARD", "FORWARD", "FORWARD", "FORWARD"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(content().string(containsString("(5 , 1)")));
	}

	/**
	 * Test Case: Obstacle Avoidance - Probe should stop before hitting an obstacle.
	 */
	@Test
	public void testStopBeforehittingAnObstacle() throws Exception {

		InstructionCommand request = new InstructionCommand(6, 6, 1, 1, Direction.EAST,
				List.of(new int[] { 2, 2 }, new int[] { 3, 3 }),
				List.of("FORWARD", "RIGHT", "FORWARD", "FORWARD", "LEFT", "BACKWARD"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(content().string(containsString("(1 , 1)(2 , 1)(1 , 1)")));
	}

	/**
	 * Test Case: Invalid Commands - API should return bad request for invalid
	 * commands.
	 */
	@Test
	public void testInvalidCommand() throws Exception {
		InstructionCommand request = new InstructionCommand(6, 6, 1, 1, Direction.NORTH, List.of(),
				List.of("X", "Y", "Z"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isBadRequest());
	}

	/**
	 * Test Case: Repeated Commands & Correct Tracking - Ensure that repeated moves
	 * are tracked correctly.
	 */
	@Test
	public void testRepeatedMoves() throws Exception {
		InstructionCommand request = new InstructionCommand(6, 6, 1, 1, Direction.EAST,
				List.of(new int[] { 2, 2 }, new int[] { 3, 3 }),
				List.of("FORWARD", "FORWARD", "FORWARD", "FORWARD", "FORWARD"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(content().string(containsString("(2 , 1)(3 , 1)(4 , 1)(5 , 1)")));

	}

	/**
	 * Test Case: Edge Grid Handling - Probe should handle movement when starting at
	 * grid edges.
	 */
	@Test
	public void testStartingatGridedges() throws Exception {
		InstructionCommand request = new InstructionCommand(6, 6, 6, 1, Direction.EAST, List.of(),
				List.of("FORWARD", "FORWARD"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(content().string(containsString("(6 , 1")));
	}

	/**
	 * Test Case: Full Rotation Ensure 360-degree rotation works correctly.
	 */
	@Test
	public void testFullRotation() throws Exception {

		InstructionCommand request = new InstructionCommand(6, 6, 1, 1, Direction.EAST,
				List.of(new int[] { 2, 2 }, new int[] { 3, 3 }), List.of("RIGHT", "RIGHT", "RIGHT", "RIGHT"));

		mockMvc.perform(post("/api/v1/movetheprobe").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk())
				.andExpect(content().string(containsString("(1 , 1")));
	}

}

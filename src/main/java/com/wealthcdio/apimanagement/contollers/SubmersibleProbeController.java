package com.wealthcdio.apimanagement.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealthcdio.apimanagement.dto.InstructionCommand;
import com.wealthcdio.apimanagement.services.ISubmersibleProbeService;


@RestController
@RequestMapping("/api/v1")
public class SubmersibleProbeController {

	private final ISubmersibleProbeService probeService;

	public SubmersibleProbeController(ISubmersibleProbeService probeService) {
		this.probeService = probeService;
	}

	@PostMapping("/movetheprobe")
	public String moveProbe(@RequestBody InstructionCommand request) {
		return probeService.commandsProvided(request);
	}

	@GetMapping("/visited")
	public String visitedPositions() {
		return probeService.getVisitedPositions();
	}

}

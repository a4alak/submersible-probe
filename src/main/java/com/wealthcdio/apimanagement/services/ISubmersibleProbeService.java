package com.wealthcdio.apimanagement.services;

import com.wealthcdio.apimanagement.dto.InstructionCommand;

public interface ISubmersibleProbeService {

	public String commandsProvided(InstructionCommand request);
	public String getVisitedPositions();
	
}

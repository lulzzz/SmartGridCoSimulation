package linprogMPC.messages.individualParts.planning;

import akka.basicMessages.AnswerContent;
import linprogMPC.messages.types.NetworkType;

public class CouplerMessage implements AnswerContent {
	
	public String name;
	public String id;
	public NetworkType primaryNetwork;
	public NetworkType secondaryNetwork;
	
	public double installedPower;
	
	public double operationalCostEUR;
	public double operationalCostCO2;
	
	public double efficiencyHeat;
	public double efficiencyElec;
	
}
package linprogMPC;

import java.util.HashSet;

import akka.basicActors.ActorOptions;
import akka.basicActors.LoggingMode;
import linprogMPC.components.Battery;
import linprogMPC.components.Building;
import linprogMPC.components.CHP;
import linprogMPC.components.Consumer;
import linprogMPC.components.GasBoiler;
import linprogMPC.components.HeatPump;
import linprogMPC.components.LinProgBehavior;
import linprogMPC.components.PV;
import linprogMPC.components.SolarThermic;
import linprogMPC.components.ThermalStorage;
import linprogMPC.helper.ConsumptionProfiles;

public abstract class ActorFactory {
	
	public static ActorOptions createLinProgBehavior(){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new LinProgBehavior());
		return result;
	}

	public static ActorOptions createCHP(double qdot_max, double efficiency_el, double efficiency_H, int port){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new CHP(qdot_max, efficiency_el, efficiency_H, port));	
		return result;
	}
	
	public static ActorOptions createGasBoiler(double qdot_max, double efficiency, double costs, int port){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new GasBoiler(qdot_max, efficiency, costs, port));	
		return result;
	}	
	
	public static ActorOptions createHeatPump(double qdot_max, double efficiencyHeat, double efficiencyElec, int port){
		ActorOptions result = new ActorOptions(
				LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new HeatPump(qdot_max, efficiencyHeat, efficiencyElec, port));	
		return result;
	}
	
	public static ActorOptions createBattery( // Parameters
			double capacity,
			double max_charging, double max_discharging, 
			double efficiencyCharge, double efficiencyDischarge, 
			int port
			){ // Factory
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new Battery(capacity, max_charging, max_discharging, efficiencyCharge, efficiencyDischarge, port));	
		return result;
	}
	
	public static ActorOptions createConsumer(ConsumptionProfiles consumptionProfiles, int consumerIndex, int port){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new Consumer(consumptionProfiles, consumerIndex, port));	
		return result;
	}
	
	public static ActorOptions createPV(double installedPower, int port){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new PV(installedPower, port));	
		return result;
	}
	
	public static ActorOptions createSolarThermic(double installedPower, int port){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new SolarThermic(installedPower, port));	
		return result;
	}
	
	public static ActorOptions createThermalStorage( // Parameters
			double capacity,
			double qdot_max_in, double qdot_max_out, 
			double efficiencyCharge, double efficiencyDischarge, 
			int port
			){
		ActorOptions result = 
				new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new ThermalStorage(capacity, qdot_max_in, qdot_max_out, efficiencyCharge, efficiencyDischarge, port));	
		return result;
	}
	
	public static ActorOptions createBuilding(int port, boolean LDHeating, int heatTransportLength){
		ActorOptions result = new ActorOptions(LoggingMode.MINIMAL,							
				new HashSet<String>(),new HashSet<String>(),new HashSet<String>(),
				new Building(port, LDHeating, heatTransportLength));	
		return result;
	}
	

}

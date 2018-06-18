package linprog;

import akka.basicActors.ActorOptions;
import linprog.helper.ConsumptionProfiles;
import topology.ActorTopology;

/**
 *
 * Topology for example with 5 buildings with Linear Programming
 * 
 * @author andreas.thut
 *
 */
public class Topology {	
	
	private static String simulationName = "LinProg";
	public static final int NR_OF_CONSUMERS = 5;
	
	// BHKW
	private static final double EFFICIENCY_CHP_H = .71;
	private static final double EFFICIENCY_CHP_EL = .32;  // angepasst, runterskalieren?
	private static final double QDOT_MAX_CHP = 80.; // eher kleiner
	
	
	private static final double EFFICIENCY_THERMALSTORAGE = 0.9;
	private static final double CAPACITY_THERMALSTORAGE = 100000.; // anpassen in KJ, 1000 L Speicher kann maximal 60kWh W�rme speichern 
	
	private static final double EFFICIENCY_GASBOILER = 1.; // angepasst    --> Gas etwas g�nstiger als �l 5,5 pro kwH, 6,0 kWh
	private static final double EFFICIENCY_OILBOILER = 0.95; // angepasst
	private static final double EFFICIENCY_SOLARTHERMIC = .75; // vier mal pv --> in das Dokument (Latex)
	private static final double EFFICIENCY_HEATPUMP = 2.5;  // Mittelwert wobei Wasser / Wasser besser ist.
	private static final double EFFICIENCY_PV = .2;

	// Capacities
	private static final double QDOT_MAX_THERMALSTORAGE_IN = 60.;  // Beladung eines speichers, 90grad maximal temperatur
	private static final double QDOT_MAX_THERMALSTORAGE_OUT = 60.;
	private static final double QDOT_MAX_GASBOILER = 40.; // eigentlich nur f�r Spitzenlast wichtig
	private static final double QDOT_MAX_OILBOILER = 40.;
	private static final double P_MAX_BATTERY_IN = 5.;
	private static final double P_MAX_BATTERY_OUT = 5.;
	
	private static final double AREA_SOLARTHERMIC = 6.; // ab 8 qm kann zur heizungsunterst�tzungs genommen werden.
	private static final double AREA_PV = 20.; // aber  gr��er auch ok
	private static final double P_MAX_HEATPUMP = 10.;

	private static final double CAPACITY_BATTERY = 40000.;
	private static final int PORT_UNDEFINED = 0;
	
	
	
	public static ActorTopology createTopology(){
		int port = 8081;
		ActorTopology top = new ActorTopology(simulationName);
		top.addActor(simulationName, ActorFactory.createLinProgBehavior());
		ConsumptionProfiles consumptionProfiles = new ConsumptionProfiles(NR_OF_CONSUMERS);
		
		//Aggregated Consumption
//		top.addActorAsChild(simulationName + "/Consumption", ActorFactory.createConsumer("/Consumption", port++));

		String building1Name = "Building1";		
		ActorTopology building1 = new ActorTopology(building1Name);		
		building1.addActor(building1Name, ActorFactory.createBuilding(building1Name, port++));
		building1.addActorAsChild(building1Name + "/OilBoiler", ActorFactory.createOilBoiler("OilBoiler", QDOT_MAX_OILBOILER, EFFICIENCY_OILBOILER, PORT_UNDEFINED));
		building1.addActorAsChild(building1Name + "/Consumption", ActorFactory.createConsumer("Consumption", consumptionProfiles, 0, PORT_UNDEFINED));
			
		String building2Name = "Building2";		
		ActorTopology building2 = new ActorTopology(building2Name);		
		building2.addActor(building2Name, ActorFactory.createBuilding(building2Name, port++));
		building2.addActorAsChild(building2Name + "/Consumption", ActorFactory.createConsumer("Consumption", consumptionProfiles, 1, PORT_UNDEFINED));
		building2.addActorAsChild(building2Name + "/PV", ActorFactory.createPV("PV", AREA_PV, EFFICIENCY_PV, PORT_UNDEFINED));
		building2.addActorAsChild(building2Name + "/HeatPump", ActorFactory.createHeatPump("HeatPump", P_MAX_HEATPUMP, EFFICIENCY_HEATPUMP, PORT_UNDEFINED));
		building2.addActorAsChild(building2Name + "/ThermalStorage", ActorFactory.createThermalStorage("ThermalStorage", QDOT_MAX_THERMALSTORAGE_IN, QDOT_MAX_THERMALSTORAGE_OUT, CAPACITY_THERMALSTORAGE, EFFICIENCY_THERMALSTORAGE, PORT_UNDEFINED));
		
		String building3Name = "Building3";		
		ActorTopology building3 = new ActorTopology(building3Name);
		building3.addActor(building3Name, ActorFactory.createBuilding(building3Name, port++));
		building3.addActorAsChild(building3Name + "/Consumption", ActorFactory.createConsumer("Consumption", consumptionProfiles, 2, PORT_UNDEFINED));
		building3.addActorAsChild(building3Name + "/PV", ActorFactory.createPV("PV", AREA_PV, .2, PORT_UNDEFINED));
		building3.addActorAsChild(building3Name + "/Battery", ActorFactory.createBattery("Battery", P_MAX_BATTERY_IN, P_MAX_BATTERY_OUT, CAPACITY_BATTERY, PORT_UNDEFINED));
		building3.addActorAsChild(building3Name + "/GasBoiler", ActorFactory.createGasBoiler("GasBoiler", QDOT_MAX_GASBOILER, EFFICIENCY_GASBOILER, PORT_UNDEFINED));

		String building4Name = "Building4";		
		ActorTopology building4 = new ActorTopology(building4Name);		
		building4.addActor(building4Name, ActorFactory.createBuilding(building4Name, port++));
		building4.addActorAsChild(building4Name + "/Consumption", ActorFactory.createConsumer("Consumption", consumptionProfiles, 3, port++));
		building4.addActorAsChild(building4Name + "/CHP", ActorFactory.createCHP("CHP", QDOT_MAX_CHP, EFFICIENCY_CHP_EL, EFFICIENCY_CHP_H, port++));
		building4.addActorAsChild(building4Name + "/ThermalStorage", ActorFactory.createThermalStorage("ThermalStorage", QDOT_MAX_THERMALSTORAGE_IN, QDOT_MAX_THERMALSTORAGE_OUT, CAPACITY_THERMALSTORAGE, EFFICIENCY_THERMALSTORAGE, port++));

		String building5Name = "Building5";
		ActorTopology building5 = new ActorTopology(building5Name);		
		building5.addActor(building5Name, ActorFactory.createBuilding(building5Name, port++));
		building5.addActorAsChild(building5Name + "/Consumption", ActorFactory.createConsumer("Consumption", consumptionProfiles, 4, port++));
		building5.addActorAsChild(building5Name + "/CHP", ActorFactory.createCHP("CHP", QDOT_MAX_CHP, EFFICIENCY_CHP_EL, EFFICIENCY_CHP_H, port++));
		building5.addActorAsChild(building5Name + "/SolarThermic", ActorFactory.createSolarThermic("SolarThermic", AREA_SOLARTHERMIC, EFFICIENCY_SOLARTHERMIC, port++));		
		building5.addActorAsChild(building5Name + "/ThermalStorage", ActorFactory.createThermalStorage("ThermalStorage", QDOT_MAX_THERMALSTORAGE_IN, QDOT_MAX_THERMALSTORAGE_OUT, CAPACITY_THERMALSTORAGE, EFFICIENCY_THERMALSTORAGE, port++));		
		building5.addActorAsChild(building5Name + "/OilBoiler", ActorFactory.createOilBoiler("OilBoiler", QDOT_MAX_OILBOILER, EFFICIENCY_OILBOILER, PORT_UNDEFINED));		

		top.addSubTopology(simulationName, building3);
		top.addSubTopology(simulationName, building2);
		top.addSubTopology(simulationName, building1);
		top.addSubTopology(simulationName, building4);
		top.addSubTopology(simulationName, building5);
		
		return top;
	}

}

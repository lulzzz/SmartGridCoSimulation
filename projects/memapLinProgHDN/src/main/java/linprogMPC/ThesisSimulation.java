package linprogMPC;

import akka.actor.ActorSystem;
import simulation.SimulationStarter;
import topology.ActorTopology;

public class ThesisSimulation {

	private ActorTopology topology;
	
	private void run() throws InterruptedException {
		
		// **************MEMAP OFF *******************
		
		//int[] mpcTimeSteps = {1,4,12,24,36,48,60,72};
		
		int[] mpcTimeSteps = {};
		for (int i = 0; i < mpcTimeSteps.length; i++) {
			topology = ThesisTopologySimpleSingle.createTopology(mpcTimeSteps[i], false);
			ActorSystem actorSystem = SimulationStarter.initialiseActorSystem(topology);
	        SimulationStarter.startSimulation(actorSystem, 0, ThesisTopologySimpleSingle.NR_OF_ITERATIONS);
		}
		
		
		// **************MEMAP ON ********************
		//int[] mpcTimeSteps2 = {1,4,12,24,36,48,60,72};
		int[] mpcTimeSteps2 = {};
		for (int i = 0; i < mpcTimeSteps2.length; i++) {
			topology = ThesisTopologySimple.createTopology(mpcTimeSteps2[i], true);
			ActorSystem actorSystem = SimulationStarter.initialiseActorSystem(topology);
	        SimulationStarter.startSimulation(actorSystem, 0, ThesisTopologySimple.NR_OF_ITERATIONS);
		}
						
		
	}
	
	public static void main(String[] args){
		try {
			new ThesisSimulation().run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

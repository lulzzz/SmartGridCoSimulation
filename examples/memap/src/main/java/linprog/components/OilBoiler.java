package linprog.components;

import java.util.concurrent.TimeUnit;

import linprog.LinProgSimulation;
import linprog.helper.EnergyPrices;

public class OilBoiler extends Producer {
	
	public final double efficiency;
	
	public OilBoiler(String name, double qdot_max, double efficiency, int port) {
		super(name, qdot_max, port);
		if(efficiency < 0.0 || efficiency > 1.0) {
			//TODO throw exception
		}
		this.efficiency = efficiency;
	}
	
	@Override
	public void makeDecision() {
		super.makeDecision();
		
//		Calendar currentTime = startTime;
		for (int i = 0; i < n; i++) {
			specificationToSend.cost[i] = 0.00001 + EnergyPrices.getGasPriceInEuro(i);
//			currentTime.add(Calendar.SECOND, stepSize);
			for (int j = 0; j < n; j++) {
				specificationToSend.couplingMatrix_H[i][j] = 0.0;
				specificationToSend.couplingMatrix_el[i][j] = 0.0;
			}
			specificationToSend.couplingMatrix_H[i][i] = -efficiency;
			specificationToSend.lowerBound[i] = 0.0;
			specificationToSend.upperBound[i] = (qdot_max/efficiency)*LinProgSimulation.stepLength(TimeUnit.HOURS);
		}
		
		display.update(gson.toJson(specificationToSend));
	}

}

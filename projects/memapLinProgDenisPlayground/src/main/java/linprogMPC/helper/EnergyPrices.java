package linprogMPC.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import linprogMPC.MPCDenisSimulation;
import simulation.SimulationStarter;

/**
 * Helper class to return the gas price.
 */
public class EnergyPrices {
	
	private static final String STROMPREISE_CSV_FILENAME = "Strompreise_7Tage.csv";
	
	private ArrayList<Double> electricityPrices;

	public EnergyPrices() {
		electricityPrices = readElectricityPrices(STROMPREISE_CSV_FILENAME);
	}
	
	/**
	 * Returns the gas price in Euro per kWh at any given point in time. For now, it constantly returns .0017ct/kJ,
	 * which equals 6.12 ct/kWh, but here CSV-files or web services or other mechanisms could be plugged in.
	 * 
	 * @param time the point in time for which to get the gas price
	 * @return gas price in ct/kWh at specified point in time
	 */
	public static double getGasPriceForTimestepInEuro(Calendar time) {
		return 0.0612d;
	}
	
	/**
	 * Returns the gas price in cents per kWh at any given timestep. For now, it constantly returns .0017ct/kJ,
	 * which equals 6.12 ct/kWh, but here CSV-files or web services or other mechanisms could be plugged in.
	 * 
	 * @param time the timestep for which to get the gas price
	 * @return gas price in ct/kWh at specified timestep
	 */
	public static double getGasPriceInEuro(int timestep) {
		return 0.0612d;
	}
	
	/**
	 * Returns the heat price in Euro per kWh at any given timestep. For now, it constantly returns 
	 * 5,34 ct/kWh (Stadtwerke W�rzburg), but here CSV-files or web services or other mechanisms could be plugged in.
	 * 
	 * @param time the timestep for which to get the gas price
	 * @return gas price in ct/kWh at specified timestep
	 */
	public static double getHeatPriceInEuro(int timestep) {
		double value = 0.0534d;
		value = 0.7;
		return value;
	}
	
	/**
	 * Returns the electricity price in cents per kWh at any given timestep in ct/kJ, read from a CSV-file.
	 * 
	 * Prices vary between 25-50 ct/kWh within 7days
	 * Coverted to EUR/kWh 
	 * The prices are set to be constant throughout one day
	 * 
	 * @param time the timestep for which to get the electricity price
	 * @return electricity price in ct/kWh at specified timestep
	 */
	public double getElectricityPriceInEuro(int timestep) {
		return electricityPrices.get(timestep % electricityPrices.size())/100;
	}
		
	
	
	
	private ArrayList<Double> readElectricityPrices(String filename){
		ArrayList<Double> electricityPrices = new ArrayList<Double>();
		try {
			String source = "res/"+ filename;			
			String location = ReadMemapFiles.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			location = location.replace("%20", " ");
			location = location.substring(0, location.length()-15);
			location = location + source;			
			FileReader fr = new FileReader(location);
			BufferedReader br = new BufferedReader(fr);
		    read(br, electricityPrices);	
		} catch (IOException | ParseException e1) {
				e1.printStackTrace();
				SimulationStarter.stopSimulation();
				return null;
		}
		
		return electricityPrices;
	}
	

	
	private void read(BufferedReader br, ArrayList<Double> electricityPrices) throws IOException, ParseException{
	    
		String zeile;   
	    NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
	    ArrayList<Double> originalValues = new  ArrayList<Double>();
	    
    	while ((zeile = br.readLine()) != null){			
    		originalValues.add(nf.parse(zeile).doubleValue());	
		}

    	double[] x = new double[originalValues.size()];
    	double[] y = new double[originalValues.size()];

		for (int i = 0; i < originalValues.size() ; i++) {
    		x[i]=i;    		// 24h * 7 Days -1 = 167 
    		y[i]=originalValues.get(i);
    	}
		
    	double[] xi = new double[MPCDenisSimulation.N_STEPS];
    	
		for (int j = 0; j < MPCDenisSimulation.N_STEPS ; j++) {
    		xi[j]=j*MPCDenisSimulation.stepLength(TimeUnit.HOURS);    
    	}	   		
		
		double[] yi = Interpolation.interpLinear(x, y, xi);
    			
//		SolutionHandler.exportData(x, "XpriceOrig.csv");
//		SolutionHandler.exportData(y, "YpriceOrig.csv");
//		SolutionHandler.exportData(xi, "XIpriceOrig.csv");
		SolutionHandler.exportData(yi, "YIpriceOrig.csv");
		
    	for (int k = 0; k < yi.length; k++) {
    		electricityPrices.add(yi[k]);
    	}
    	
	    br.close();

	}	
	
	

}

package ca.concordia.ece390.VoltmeterApp;

public class VoltmeterSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up
		View v = new SimpleView();
		View g = new GraphicalView();
		System.out.println("SimpleView");
		MeasurementListener listener = new StoredListener(v);
		MeasurementProvider provider = new MeasurementProvider();
		provider.addListener(listener);
		
		
		
		
		
		for(int i = 0; i < 100; ++i) {
			// Get the next measurement (this calls all the listeners...)
			provider.processNextMeasurement();
			
			// And wait for 100ms ... simulate that the provider "receives" data from outside
			// every 100ms. Yeah, this is hacky! Just a demonstration =P
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) { // because we HAVE to catch a checked exception...
				e.printStackTrace(); // just log it and keep going if this happens
			}
		}
		
		
		System.out.println("Graphical");
		MeasurementListener listener1 = new SimpleListener(g);
		MeasurementProvider provider1 = new MeasurementProvider();
		provider1.addListener(listener1);
	
	
	for(int i = 0; i < 100; ++i) {
		// Get the next measurement (this calls all the listeners...)
		provider1.processNextMeasurement();
		
		// And wait for 100ms ... simulate that the provider "receives" data from outside
		// every 100ms. Yeah, this is hacky! Just a demonstration =P
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) { // because we HAVE to catch a checked exception...
			e.printStackTrace(); // just log it and keep going if this happens
		}
	}

	}
}
package ca.concordia.ece390.VoltmeterApp;

/**
 * A simple implementation of the "View" interface. It displays the time and
 * voltage value of measurements as a text table.
 */
public class SimpleView implements View {

	/**
	 * Simple version of a voltmeter view: show the time and voltage value as a number
	 * in a table.
	 */
	@Override
	public void displayVoltageMeasurement(VoltageMeasurement v) {
		System.out.println(String.format("%8.2f ", v.getTime()) +
											" | " + String.format("%6.2f ", v.getVoltage()));
		
	}
	
}

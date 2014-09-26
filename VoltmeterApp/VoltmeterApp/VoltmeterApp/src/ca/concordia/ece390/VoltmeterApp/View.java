package ca.concordia.ece390.VoltmeterApp;

/**
 * The View interface defines methods that can be used to display data
 * on the screen. Each class implementing View should have its own method
 * of displaying data on the screen: command-line text table, command-line
 * graph, GUI graph with a browsable table, etc.
 */
public interface View {
	/** Shows the voltage on the console in some way. */
	public void displayVoltageMeasurement(VoltageMeasurement v);
	
}

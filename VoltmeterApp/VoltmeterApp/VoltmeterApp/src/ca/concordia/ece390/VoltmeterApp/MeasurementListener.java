package ca.concordia.ece390.VoltmeterApp;

/**
 * Defines a listener that can be registered to a MeasurementProvider, and will be
 * called by the MeasurementProvider whenever a new measurement is received.
 */
public interface MeasurementListener {
	/**
	 * Called whenever the MeasurementProvider receives a new measurement.
	 * @param v The new measurement.
	 */
	public void handleMeasurement(VoltageMeasurement v);
}

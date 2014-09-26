package ca.concordia.ece390.VoltmeterApp;

/**
 * A simple MeasurementListener class. It stores a "View" object provided at
 * construction, and when a measurement is received, that measurement is
 * passed to the View for display on-screen.
 */
public class SimpleListener implements MeasurementListener {
	View mView = null;
	
	SimpleListener(View v) {
		mView = v;
	}

	@Override
	public void handleMeasurement(VoltageMeasurement v) {
		mView.displayVoltageMeasurement(v);
	}

}

package ca.concordia.ece390.VoltmeterApp;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that "receives" measurements. In a real application, this would actually
 * configure the voltmeter hardware (through the operating system API, for example) and then
 * go and read the voltmeter hardware (or use an operating system API to read it or to
 * "subscribe" to measurement updates).
 * 
 * In this case, this MeasurementProvider simply generates a "measurement" of a sine
 * wave (frequency of FREQUENCY) every time processNextMeasurement() is called.
 * It assumes processNextMeasurement() will be called every TIME_STEP seconds.
 * 
 * You can add one or more MeasurementListener objects to this Provider. When a
 * MeasurementListener has been added, whenever a new measurement is "received"
 * (in our simulation, this means processNextMeasurement() is called), the new
 * measurement is passed onto all the MeasurementListener objects, which can then
 * do whatever they want with the new measurement.
 * 
 * If you had more than one MeasurementProvider, this could be an interface or pure
 * abstract class, with processNextMeasurement() left abstract. You could then define
 * different MeasurementProvider implementations that simulate measurements, or
 * actually read some kind of hardware, etc.
 */
public class MeasurementProvider {
	static private final double TIME_STEP = 0.1;
	static private final double FREQUENCY = 0.515935;
	static private final double PHASE_OFFSET = Math.PI/8.0;
	private double mCurrentTime = 0;
	private VoltageMeasurement mLastMeasurement = null;
	
	List<MeasurementListener> mListeners = new ArrayList<MeasurementListener>();
	
	/**
	 * When this method is called, we simulate that MeasurementProvider "reads" the
	 * voltmeter hardware. This method then notifies all the listeners about this new
	 * measurement.
	 */
	public void processNextMeasurement() {
		mLastMeasurement = new VoltageMeasurement(mCurrentTime,
				Math.sin(2*Math.PI*FREQUENCY*mCurrentTime + PHASE_OFFSET));
		mCurrentTime += TIME_STEP;
		notifyListeners();
	}
	
	/**
	 * Add a MeasurementListener. Whenever a new measurement is received in the future,
	 * the listener will be notified via its handleMeasurement() method.
	 * @param l The Listener to add. It will only be added as a listener if it has not
	 * already been added to this particular Provider.
	 */
	public void addListener(MeasurementListener l) {
		if(l != null && !mListeners.contains(l)) {
			mListeners.add(l);
		}
	}
	
	/**
	 * Remove a MeasurementListener. It will no longer get notifications from this
	 * MeasurementProvider when new measurements are received.
	 * @param l The MeasurementListener to remove.
	 */
	public void removeListener(MeasurementListener l) {
		mListeners.remove(l);
	}
	
	/**
	 * Notify all listeners of a new measurement (mLastMeasurement).
	 */
	private void notifyListeners() {
		for(MeasurementListener l : mListeners) {
			l.handleMeasurement(mLastMeasurement);
		}
	}
}

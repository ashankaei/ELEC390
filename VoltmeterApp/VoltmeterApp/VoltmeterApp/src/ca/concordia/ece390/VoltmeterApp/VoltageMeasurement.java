package ca.concordia.ece390.VoltmeterApp;

/**
 * A data type that stores a voltage measurement and the time it was taken at
 * (in seconds elapsed).
 *
 */
public class VoltageMeasurement implements Comparable<VoltageMeasurement> {
	double mTime;
	double mVoltage;
	
	VoltageMeasurement(double time, double voltage) {
		mTime = time;
		mVoltage = voltage;
	}
	
	public double getTime() {
		return mTime;
	}
	
	public double getVoltage() {
		
		return mVoltage;
	}

	/**
	 * Compares this object with the specified object for order. Returns a negative integer, zero,
	 * or a positive integer as this object is less than, equal to, or greater than the specified
	 * object.
	 */
	@Override
    public int compareTo(VoltageMeasurement v2) {
		if(getTime() < v2.getTime()) {
			return -1;
		}
		else if(getTime() > v2.getTime()) {
			return +1;
		}
		else
			return 0;
    }
}

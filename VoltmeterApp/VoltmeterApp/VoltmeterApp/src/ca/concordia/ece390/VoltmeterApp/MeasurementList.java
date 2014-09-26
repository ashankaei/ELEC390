package ca.concordia.ece390.VoltmeterApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores a list of VoltageMeasurement objects. Usually, the Measurements should be added
 * in chronological order of the measurement being taken.
 */
public class MeasurementList {
	// You could define this as an interface and then a class implementing this interface...
	// but in this case we don't expect to have different kinds of implementations, so
	// just this one class will do.
	
	
	// Hint: use this as your backing data structure to "store" the list of measurements
	List<VoltageMeasurement> mMeasures = new ArrayList<VoltageMeasurement>();
	
	/** Add a voltage measurement to the list. */
	public void add(VoltageMeasurement v) {
		// TODO: implement this
	
		mMeasures.add(v);
	}

	/** Clear the list of all measurements. */
	public void clear() {
		// TODO: implement this
		mMeasures.clear();
	}

	/** Get the measurement at the specified index. Index = 0 is the oldest measurement, and
	 * index = size() - 1 is the latest measurement. */
	public VoltageMeasurement get(int index) {
		// TODO: implement this
		return mMeasures.get(index);
		
	}
	
	/** The number of measurements in this list. */
	public int size() {
		return mMeasures.size();
		
	}
	
	/**
	 * Get the average of THREE measurements at or before the given index.
	 * @param index
	 * @return
	 */
	public VoltageMeasurement getAverage(int index) {
		// TODO: implement this
		double sum  = 0;
		VoltageMeasurement average = null;
		if (index <16){
			for (int i = 0; i<index;++i)
			{
				sum = sum + mMeasures.get(i).getVoltage();
				
			}
			average = new VoltageMeasurement(0, sum/index);
			
		}else{
		
		for (int i = index-15; i < index; ++i){
			
			sum = sum + mMeasures.get(i).getVoltage();
		}
		average = new VoltageMeasurement(0, sum/16);
		}
		return average;
	
	}
}

/**
 * 
 */
package com.et.tube.arrival.predictions.util;

/**
 * Utility class to load the values
 * @author Kousalya
 *
 */
public class TubeArrivalPredictionConstants {

	public static final String ARRIVAL_PREDICTION_URI = "https://api.tfl.gov.uk/StopPoint/940GZZLUGPS/Arrivals";

	public static final String EASTBOUND = "Eastbound";

	public static final String WESTBOUND = "Westbound";

	public static final String MODEL_VIEW_NAME = "tubePredictions";

	public static final String EASTBOUND_TITLE = "East Bound Trains";

	public static final String WESTBOUND_TITLE = "West Bound Trains";

	public static final String EMPTY_STATION_NAME = "";

	public static final String HH_mm_ss = "HH:mm:ss";

	public static final String GMT = "GMT";

	// Utility classes should not have public constructors, so defining private one
	private TubeArrivalPredictionConstants() {
	}

}

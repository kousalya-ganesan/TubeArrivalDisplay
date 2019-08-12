/**
 * 
 */
package com.et.tube.arrival.predictions.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.et.tube.arrival.predictions.domain.Prediction;
import com.et.tube.arrival.predictions.util.TubeArrivalPredictionConstants;

/**
 * Helper class for TubeArrivalPredictionController
 * @author Kousalya
 *
 */
public class TubeArrivalPredictionControllerHelper {

	/**
	 * Comparator to sort the Tubes based on the Time To Station field
	 * 
	 * @param westBoundTrains
	 */
	public void sortTrainsBasedOnTime(List<Prediction> trainList) {
		Collections.sort(trainList, new Comparator<Prediction>() {
			@Override
			public int compare(Prediction o1, Prediction o2) {
				return o1.getTimeToStation() - o2.getTimeToStation();
			}
		});
	}

	/**
	 * Method to convert the Time to station from seconds to HH:mm:ss format
	 * 
	 * @param seconds
	 * @return time in HH:mm:ss format
	 */
	public String convertSecsToMins(int seconds) {
		Date date = new Date(seconds * 1000L);
		SimpleDateFormat df = new SimpleDateFormat(TubeArrivalPredictionConstants.HH_mm_ss); // HH for 0-23
		df.setTimeZone(TimeZone.getTimeZone(TubeArrivalPredictionConstants.GMT));
		return df.format(date);
	}

	/**
	 * Method to convert the Expected Arrival Time from GMT to BST
	 * 
	 * @param dateAndTimeInGmt
	 * @return Expected Arrival Time in BST
	 */
	public String convertGmtToBst(String dateAndTimeInGmt) {
		LocalDateTime gmt = LocalDateTime.parse(dateAndTimeInGmt,
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
		ZonedDateTime instant = ZonedDateTime.of(gmt, ZoneId.of("GMT"));
		return instant.withZoneSameInstant(ZoneId.of("Europe/London")).toLocalDateTime().toString();

	}

}

/**
 * 
 */
package com.et.tube.arrival.predictions.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.et.tube.arrival.predictions.domain.Prediction;
import com.et.tube.arrival.predictions.util.TubeArrivalPredictionConstants;

/**
 * @author Kousalya
 *
 */

@Controller
public class TubeArrivalPredictionController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/tube/arrivals")
	public ModelAndView showTubeArrival() {
		String stationName = null;

		ModelAndView mv = new ModelAndView(TubeArrivalPredictionConstants.MODEL_VIEW_NAME);

		ResponseEntity<List<Prediction>> response = restTemplate.exchange(
				TubeArrivalPredictionConstants.ARRIVAL_PREDICTION_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Prediction>>() {
				});
		List<Prediction> predictionList = response.getBody();

		List<Prediction> eastBoundTrains = new ArrayList<>();
		List<Prediction> westBoundTrains = new ArrayList<>();
		for (Prediction pred : predictionList) {
			stationName = pred.getStationName();
			if (pred.getPlatformName().startsWith(TubeArrivalPredictionConstants.EASTBOUND)) {
				pred.setPlatformName(pred.getPlatformName().substring(pred.getPlatformName().lastIndexOf('-') + 1));
				pred.setTimeToStationInHHMM(convertSecsToMins(pred.getTimeToStation()));
				
				eastBoundTrains.add(pred);
			} else {
				pred.setPlatformName(pred.getPlatformName().substring(pred.getPlatformName().lastIndexOf('-') + 1));
				pred.setTimeToStationInHHMM(convertSecsToMins(pred.getTimeToStation()));
				
				westBoundTrains.add(pred);
			}
		}

		sortEastBoundTrains(eastBoundTrains);
		sortWestBoundTrains(westBoundTrains);

		mv.addObject("eastBoundTrains", eastBoundTrains);
		mv.addObject("eastBoundTrainList", TubeArrivalPredictionConstants.EASTBOUND_TITLE);
		mv.addObject("westBoundTrains", westBoundTrains);
		mv.addObject("westBoundTrainList", TubeArrivalPredictionConstants.WESTBOUND_TITLE);
		mv.addObject("stationName",
				null != stationName ? stationName : TubeArrivalPredictionConstants.EMPTY_STATION_NAME);

		return mv;
	}

	private void sortWestBoundTrains(List<Prediction> westBoundTrains) {
		Collections.sort(westBoundTrains, new Comparator<Prediction>() {
			@Override
			public int compare(Prediction o1, Prediction o2) {
				return o1.getTimeToStation() - o2.getTimeToStation();
			}
		});
	}

	private void sortEastBoundTrains(List<Prediction> eastBoundTrains) {
		Collections.sort(eastBoundTrains, new Comparator<Prediction>() {
			@Override
			public int compare(Prediction o1, Prediction o2) {
				return o1.getTimeToStation() - o2.getTimeToStation();
			}
		});
	}

	private String convertSecsToMins(int seconds) {
		Date date = new Date(seconds * 1000L);
		SimpleDateFormat df = new SimpleDateFormat(TubeArrivalPredictionConstants.HH_mm_ss); // HH for 0-23
		df.setTimeZone(TimeZone.getTimeZone(TubeArrivalPredictionConstants.GMT));
		return df.format(date);
	}
}
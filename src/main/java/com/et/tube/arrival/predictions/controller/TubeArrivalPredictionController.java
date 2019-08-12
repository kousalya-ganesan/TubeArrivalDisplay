package com.et.tube.arrival.predictions.controller;

import java.util.ArrayList;
import java.util.List;

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
 * Entry point to get the tube arrival predictions from api.tfl.gov.uk
 * 
 * @author Kousalya
 *
 */

@Controller
public class TubeArrivalPredictionController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TubeArrivalPredictionControllerHelper helper;

	/**
	 * Handler Method to display the Tube arrival predictions and details of Tubes
	 * 
	 */
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
				pred.setTimeToStationInHHMM(helper.convertSecsToMins(pred.getTimeToStation()));
				pred.setExpectedArrival(helper.convertGmtToBst(pred.getExpectedArrival()));
				eastBoundTrains.add(pred);
			} else {
				pred.setPlatformName(pred.getPlatformName().substring(pred.getPlatformName().lastIndexOf('-') + 1));
				pred.setTimeToStationInHHMM(helper.convertSecsToMins(pred.getTimeToStation()));
				pred.setExpectedArrival(helper.convertGmtToBst(pred.getExpectedArrival()));
				westBoundTrains.add(pred);
			}
		}

		helper.sortTrainsBasedOnTime(eastBoundTrains);
		helper.sortTrainsBasedOnTime(westBoundTrains);

		mv.addObject("eastBoundTrains", eastBoundTrains);
		mv.addObject("eastBoundTrainList", TubeArrivalPredictionConstants.EASTBOUND_TITLE);
		mv.addObject("westBoundTrains", westBoundTrains);
		mv.addObject("westBoundTrainList", TubeArrivalPredictionConstants.WESTBOUND_TITLE);
		mv.addObject("stationName",
				null != stationName ? stationName : TubeArrivalPredictionConstants.EMPTY_STATION_NAME);

		return mv;
	}

}
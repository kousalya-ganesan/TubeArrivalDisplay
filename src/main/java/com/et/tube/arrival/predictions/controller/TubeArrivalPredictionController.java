/**
 * 
 */
package com.et.tube.arrival.predictions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Kousalya
 *
 */

@Controller
public class TubeArrivalPredictionController {

	
	@RequestMapping("/tube/arrivals")
	public ModelAndView showTubeArrival() {

		ModelAndView mv = new ModelAndView("tubePredictions");

		return mv;
	}

	
}
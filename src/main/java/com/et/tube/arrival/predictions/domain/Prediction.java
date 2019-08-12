/**
 * 
 */
package com.et.tube.arrival.predictions.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for Tube Prediction
 * @author Kousalya
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {

	private int vehicleId;

	private String stationName;

	private String lineName;

	private String platformName;

	private String direction;

	private String destinationName;

	private String timestamp;

	private int timeToStation;

	private String timeToStationInHHMM;

	private String currentLocation;

	private String towards;

	private String expectedArrival;

	private String modeName;

	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @param lineName the lineName to set
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * @return the platformName
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * @param platformName the platformName to set
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the timeToStation
	 */
	public int getTimeToStation() {
		return timeToStation;
	}

	/**
	 * @param timeToStation the timeToStation to set
	 */
	public void setTimeToStation(int timeToStation) {
		this.timeToStation = timeToStation;
	}

	/**
	 * @return the currentLocation
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * @return the towards
	 */
	public String getTowards() {
		return towards;
	}

	/**
	 * @param towards the towards to set
	 */
	public void setTowards(String towards) {
		this.towards = towards;
	}

	/**
	 * @return the expectedArrival
	 */
	public String getExpectedArrival() {
		return expectedArrival;
	}

	/**
	 * @param expectedArrival the expectedArrival to set
	 */
	public void setExpectedArrival(String expectedArrival) {
		this.expectedArrival = expectedArrival;
	}

	/**
	 * @return the modeName
	 */
	public String getModeName() {
		return modeName;
	}

	/**
	 * @param modeName the modeName to set
	 */
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	/**
	 * @return the timeToStationInHHMM
	 */
	public String getTimeToStationInHHMM() {
		return timeToStationInHHMM;
	}

	/**
	 * @param timeToStationInHHMM the timeToStationInHHMM to set
	 */
	public void setTimeToStationInHHMM(String timeToStationInHHMM) {
		this.timeToStationInHHMM = timeToStationInHHMM;
	}

	@Override
	public String toString() {

		return "VehicleId : " + vehicleId + ", StationName : " + stationName + ", PlatformName : " + platformName
				+ ", Direction : " + direction + ", DestinationName : " + destinationName + ", TimeToStation : "
				+ timeToStation + ", CurrentLocation : " + currentLocation + ", Towards : " + towards
				+ ", ExpectedArrival : " + expectedArrival;
	}
}

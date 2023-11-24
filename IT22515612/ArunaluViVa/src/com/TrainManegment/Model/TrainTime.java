package com.TrainManegment.Model;

public class TrainTime {
	protected int id;
	protected String trainname;
	protected String startstation;
	protected String endstation;
	protected String date;
	protected String starttime;
	protected String endtime;

	public TrainTime() {

	}

	public TrainTime(String trainname, String startstation, String endstation, String date, String starttime,
			String endtime) {
		super();
		this.trainname = trainname;
		this.startstation = startstation;
		this.endstation = endstation;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public TrainTime(int id, String trainname, String startstation, String endstation, String date, String starttime,
			String endtime) {
		super();
		this.id = id;
		this.trainname = trainname;
		this.startstation = startstation;
		this.endstation = endstation;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getStartstation() {
		return startstation;
	}

	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}

	public String getEndstation() {
		return endstation;
	}

	public void setEndstation(String endstation) {
		this.endstation = endstation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}

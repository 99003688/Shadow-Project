package com.ltts.shadow.smartcafeteria.Models;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CurrentOccupancyAverage")
public class CurrentOccupancyAverage {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;

	@Column(name="count")
	private ArrayList<Float> count;
	
	@Column(name="times")
	private LocalTime times;

	public CurrentOccupancyAverage(ArrayList<Float> average, LocalTime time) {
		super();
		this.count = average;
		this.times = time;
	}

	public CurrentOccupancyAverage() {
		super();
	}

	public ArrayList<Float> getCount() {
		return count;
	}

	public void setCount(ArrayList<Float> count) {
		this.count = count;
	}

	public LocalTime getTimes() {
		return times;
	}

	public void setTimes(LocalTime times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "CurrentOccupancyAverage [count=" + count + ", times=" + times + "]";
	}
	
	
	
	
	

}

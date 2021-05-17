package com.ltts.shadow.smartcafeteria.Models;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceOccupancyAverage")
public class ServiceOccupancyAverage2 {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;

	@Column(name="count")
	private Float count;
	
	@Column(name="times")
	private Integer times;

	public ServiceOccupancyAverage2(Float a, Integer b) {
		
		this.times=b;
		this.count=a;
	}

		public Float getCount() {
		return count;
	}

	public void setCount(Float count) {
		this.count = count;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "CurrentOccupancyAverage [count=" + count + ", times=" + times + "]";
	}
	
	
	
	
	

}

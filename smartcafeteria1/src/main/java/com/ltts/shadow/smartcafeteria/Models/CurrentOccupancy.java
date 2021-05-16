package com.ltts.shadow.smartcafeteria.Models;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "currentoccupancy")
public class CurrentOccupancy {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="count")
	private int count;
	
	@Column(name="cdate")
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
     private Date cdate;

	@Column(name="times")
	private LocalTime times = LocalTime.now();

	public CurrentOccupancy(long id, int count, Date cdate, LocalTime times) {
		super();
		this.id = id;
		this.count = count;
		this.cdate = cdate;
		this.times = times;
	}

	public CurrentOccupancy() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public LocalTime getTimes() {
		return times;
	}

	public void setTimes(LocalTime times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "CurrentOccupancy [id=" + id + ", count=" + count + ", cdate=" + cdate + ", times=" + times + "]";
	}
	
	
	

}

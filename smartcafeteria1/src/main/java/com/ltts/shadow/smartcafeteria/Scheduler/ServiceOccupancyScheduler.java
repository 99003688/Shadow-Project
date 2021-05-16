package com.ltts.shadow.smartcafeteria.Scheduler;

import java.util.Date;
import java.util.Random;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ltts.shadow.smartcafeteria.Dao.ServiceOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;

@Service
public class ServiceOccupancyScheduler {
	
	@Autowired
	private ServiceOccupancyDao SODao;
	


	Logger log = LoggerFactory.getLogger(CurrentOccupancyScheduler.class);
	
	//scheduling a job to add count of occupancy in every 5 minutes.
	@Scheduled(fixedRate = 300000)
	public void startLiveOccupancyScheduler()
	{
		ServiceOccupancy serviceOccupancy=new ServiceOccupancy();
		serviceOccupancy.setCount(new Random().nextInt(50));
	
		SODao.save(serviceOccupancy);
	
		System.out.println("add service call in " + new Date().toString());
	}
	
//fetching from database in every 15 minutes
	@Scheduled(cron = "15 * * * * *")
	public void fetchLiveOccupancyScheduler() {
		Iterable<ServiceOccupancy> counts = (Iterable<ServiceOccupancy>) SODao.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " );
		log.info("Occupancy counts : {}", counts);
	}
	
	public Iterable<ServiceOccupancy> getServiceOccupancy()
	{
		return (Iterable<ServiceOccupancy>) SODao.findAll();
		
		
	}
	
	}
	



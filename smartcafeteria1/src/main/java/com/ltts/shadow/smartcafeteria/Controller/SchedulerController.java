package com.ltts.shadow.smartcafeteria.Controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.shadow.smartcafeteria.Dao.CurrentOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancyAverage;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;
import com.ltts.shadow.smartcafeteria.Scheduler.CurrentOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Scheduler.ServiceOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Services.CurrentOccupancyService;
import com.ltts.shadow.smartcafeteria.Services.ServiceOccupancyService;

@CrossOrigin("http://localhost:4200")
@RestController
public class SchedulerController {
	
	

	@Autowired
	private CurrentOccupancyScheduler cos;
	
	@Autowired
	private CurrentOccupancyService currentOccupancyService;
	
	@Autowired
	private ServiceOccupancyScheduler sos;
	
	@Autowired
	private ServiceOccupancyService serviceOccupancyService;
	
	@Autowired
	private CurrentOccupancyDao cod;
	
	
	
	
	
	//for dining occupancy
	@GetMapping("/getCurrentOccupancy")
	public Iterable<CurrentOccupancy> getCurrentOccupancy()
	{
		return cos.getCurrentOccupancy();
	}
	
//	@GetMapping("/getAverage")
//	public List<CurrentOccupancyAverage> getAvg()
//	{
//		return cod.findAverage();
//	}
	
//	@GetMapping("/getMovingAverage")
//	public List<CurrentOccupancyAverage> getMovingAvg()
//	{
//		return cod.findBymovingAverage();
//	}
//	
	

//	@RequestMapping("/page")
//	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "4") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}
//	
//	@RequestMapping("/lastpage")
//	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment1( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "1") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}
	
	
	
	
	
	//for service occupancy
	@GetMapping("/getServiceOccupancy")
	public Iterable<ServiceOccupancy> getServiceOccupancy()
	{
		return sos.getServiceOccupancy();
	}
	
	@RequestMapping("/time")
	public List<CurrentOccupancyAverage> makeList()
	{		List<CurrentOccupancy> ls =cod.findAll();
	float sum=0, count=0,  count2=0;
	LocalTime time=null;
	ArrayList<Float> average = new ArrayList<Float>();
	for(CurrentOccupancy a:ls) {
		
		sum=sum+a.getCount();
		count++;
		count2++;
		if(count2 != 0 && count2 % 12==0) {	
			sum= sum/count;
		    average.add(sum);
		    sum=0;
		    count=0;
		    time=a.getTimes();
			
		}
	}

	List<CurrentOccupancyAverage> lco= new ArrayList<CurrentOccupancyAverage>();

	lco.add(new CurrentOccupancyAverage(average, time));
	
	
	    
		return lco;
	}

	@RequestMapping("/pageservice")
	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "10") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@RequestMapping("/lastpageservice")
	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt1( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "1") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}


	
}

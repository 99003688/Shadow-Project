package com.ltts.shadow.smartcafeteria.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ltts.shadow.smartcafeteria.Dao.CurrentOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;

@Service
public class CurrentOccupancyService {
   @Autowired
   CurrentOccupancyDao currentOccupancyDao;
   
   public List<CurrentOccupancy> getAlldata(Integer pageNo, Integer pageSize, String sortBy)
   {
       Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
      Page<CurrentOccupancy> pagedResult = currentOccupancyDao.findAll(paging);
      
        
       if(pagedResult.hasContent()) {
           return pagedResult.getContent();
       } else {
           return new ArrayList<CurrentOccupancy>();
       }
   }
	

	public ArrayList<Float> makeList()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();
//		List<CurrentOccupancyAverage> lss =coad.findAll();
		
	float sum=0, count=0,  count2=0;
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
			
		}
		
	}
	return average;
	
	}
	public ArrayList<Integer> makeListTime()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();

		
	int sum=0, count=0,  count2=0;
	ArrayList<Integer> averagetime = new ArrayList<Integer>();
	for(CurrentOccupancy a:ls) {
		
		int ak=a.getTimes().getMinute();
		
		sum=sum+ak;
		count++;
		count2++;
		if(count2 != 0 && count2 % 12==0) {	
			sum= sum/count;
			averagetime.add(sum);
		    sum=0;
		    count=0;
			
		}
		
	}
	return averagetime;
	
	}
//	public List<CurrentOccupancy>findAverageByServ(int count)
//	{
//		return currentOccupancyDao.findAverage(count);
//	}
}

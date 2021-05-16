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
	
//	public List<CurrentOccupancy>findAverageByServ(int count)
//	{
//		return currentOccupancyDao.findAverage(count);
//	}
}

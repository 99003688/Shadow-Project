package com.ltts.shadow.smartcafeteria.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.ltts.shadow.smartcafeteria.Dao.ServiceOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;

@Service
public class ServiceOccupancyService {
   @Autowired
   ServiceOccupancyDao serviceOccupancyDao;
   
   public List<ServiceOccupancy> getAlldata(Integer pageNo, Integer pageSize, String sortBy)
   {
       Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

       Page<ServiceOccupancy> pagedResult = serviceOccupancyDao.findAll(paging);
        
       if(pagedResult.hasContent()) {
           return pagedResult.getContent();
       } else {
           return new ArrayList<ServiceOccupancy>();
       }
   }
}
	
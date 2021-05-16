package com.ltts.shadow.smartcafeteria.Dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;

@Repository
public interface ServiceOccupancyDao extends PagingAndSortingRepository<ServiceOccupancy, Long> {

	
}

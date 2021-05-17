package com.ltts.shadow.smartcafeteria.Dao;


import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancyAverage;

@Repository
public interface CurrentOccupancyDao extends JpaRepository<CurrentOccupancy, Long> {

	
	
//    @Query("SELECT new com.ltts.shadow.smartcafeteria.Models.CurrentOccupancyAverage (AVG(c.count), AVG(c.times)) OVER (ORDER BY c.id ROWS BETWEEN 6 PRECEDING AND 6 FOLLOWING) c.ak FROM CurrentOccupancy c")
//	public List<CurrentOccupancyAverage> findAverage();
	

//	@Query("SELECT c.times ,c.count ,AVG(c.count) OVER (ORDER BY c.times ROWS BETWEEN 12 PRECEDING AND 12 FOLLOWING) c.MovingAverage FROM Currentccupancy c")
//	public  List<CurrentOccupancyAverage> findBymovingAverage();
	
}
//@Query("SELECT new com.ltts.shadow.smartcafeteria.Models.CurrentOccupancyAverage(AVG(c.count), AVG(c.times)) FROM CurrentOccupancy c WHERE c.id = ?1")
//@Query("SELECT AVG(c.COUNT) FROM CurrentOccupancy c order by c.id desc limit 12")
//List<CurrentOccupancy> findAll();
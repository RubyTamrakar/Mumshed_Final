package edu.mum.mumsched.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.mumsched.enums.MonthEnum;
import edu.mum.mumsched.model.Block;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {
	@Query("SELECT b FROM Block b")
	public Iterable<Block> fillAllWithSort(Sort sort);
	
	@Query("SELECT CASE WHEN count(b)> 0 THEN true ELSE false END FROM Block b WHERE b.schedule.id = :scheduleId AND b.month=:month AND b.id <> :excludedId")
	public boolean hasExistsBlock(@Param("scheduleId") Long scheduleId, @Param("month") MonthEnum month, @Param("excludedId") Long excludedId);
	
}

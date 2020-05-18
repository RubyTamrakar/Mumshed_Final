package edu.mum.mumsched.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.mumsched.model.Entry;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
	@Query("SELECT e FROM Entry e")
	public List<Entry> fillAllWithSort(Sort sort);
	
	@Query("SELECT CASE WHEN count(e)> 0 THEN true ELSE false END FROM Entry e WHERE e.name = :name AND e.id <> :excludedId")
	public boolean hasExistsEntryName(@Param("name") String name, @Param("excludedId") Long excludedId);
}

package edu.mum.mumsched.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.mumsched.model.Section;


public interface SectionRepository extends CrudRepository<Section, Long> {
	@Query("SELECT s FROM Section s")
	public Iterable<Section> fillAllWithSort(Sort sort);
	
	@Query("SELECT CASE WHEN count(s)> 0 THEN true ELSE false END FROM Section s WHERE s.block.id = :blockId AND s.faculty.id = :facultyId AND s.course.id = :courseId AND s.id <> :excludedId")
	public boolean hasExistsSection(@Param("blockId") long blockId, @Param("facultyId") long facultyId, 
			@Param("courseId") long courseId, @Param("excludedId") long excludedId);

	@Query("SELECT CASE WHEN count(s)> 0 THEN true ELSE false END FROM Section s WHERE s.block.id = :blockId AND s.faculty.id = :facultyId AND s.id <> :excludedId")
	public boolean hasExistsFacultyBlock(@Param("blockId") long blockId, @Param("facultyId") long facultyId, @Param("excludedId") long excludedId);
}

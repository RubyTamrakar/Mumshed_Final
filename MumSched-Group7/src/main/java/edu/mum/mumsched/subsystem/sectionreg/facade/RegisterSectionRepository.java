package edu.mum.mumsched.subsystem.sectionreg.facade;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.mumsched.model.Section;

interface RegisterSectionRepository extends CrudRepository<Section, Long> {
	@Query("SELECT e FROM Section e")
	public Iterable<Section> fillAllWithSort(Sort sort);
}

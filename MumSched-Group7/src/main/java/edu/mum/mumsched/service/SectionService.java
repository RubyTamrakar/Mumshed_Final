package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.model.Section;


public interface SectionService {

	Iterable<Section> getList();

	boolean hasStudentRef(Section section);

	Section save(Section Section);

	void delete(Section Section);

	Section findSectionById(Long id);

	List<Section> saveAll(List<Section> Sections);
	boolean hasExistsSection(long blockId, long facultyId, long courseId, long excludedId);

	boolean hasExistsFacultyBlock(long blockId, long facultyId, long excludedId);
}

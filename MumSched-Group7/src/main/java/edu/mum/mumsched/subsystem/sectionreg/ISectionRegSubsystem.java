package edu.mum.mumsched.subsystem.sectionreg;

import java.util.List;

import edu.mum.mumsched.model.Section;
import edu.mum.mumsched.model.Student;

public interface ISectionRegSubsystem {
	List<Section> getSections(Long entryId);
	Section signInSection(Student student, Long sectionId);
	void signOutSection(Student student, Long sectionId);	
}

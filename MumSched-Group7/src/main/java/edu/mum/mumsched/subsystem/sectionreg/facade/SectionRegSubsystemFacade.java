package edu.mum.mumsched.subsystem.sectionreg.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumsched.model.Section;
import edu.mum.mumsched.model.Student;
import edu.mum.mumsched.subsystem.sectionreg.ISectionRegSubsystem;

@Service("iSectionRegSubsystem")
class SectionRegSubsystemFacade implements ISectionRegSubsystem {

	@Autowired
	private RegisterSectionService registerSectionService;
	
	@Override
	public List<Section> getSections(Long entryId) {
		return registerSectionService.findByEntryId(entryId);
	}

	@Override
	public Section signInSection(Student student, Long sectionId) {

		Section sectionDB = registerSectionService.findSectionById(sectionId);
		
		if (sectionDB.getStudentList() == null)
			sectionDB.setStudentList(new HashSet<Student>());
		
		
		sectionDB.getStudentList().add(student);
		sectionDB = registerSectionService.save(sectionDB);
		
		return sectionDB;		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void signOutSection(Student student, Long sectionId) {
		
		Section sectionDB = registerSectionService.findSectionById(sectionId);
		
		if (sectionDB.getStudentList() != null) {
			List<Student> students = new ArrayList<Student>(sectionDB.getStudentList());
			int len = sectionDB.getStudentList().size();
			for(int i = len-1; i >= 0; i--) {
				if(students.get(i).getId() == student.getId() ) {
					students.remove(i);
				}
			}
			sectionDB.setStudentList(new HashSet(students));
		}		
		registerSectionService.save(sectionDB);	
	}

}

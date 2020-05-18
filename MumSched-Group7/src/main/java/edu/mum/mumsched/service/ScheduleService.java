package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.enums.MonthEnum;
import edu.mum.mumsched.model.Block;
import edu.mum.mumsched.model.Course;
import edu.mum.mumsched.model.Entry;
import edu.mum.mumsched.model.Faculty;
import edu.mum.mumsched.model.Schedule;

public interface ScheduleService {

	Iterable<Schedule> findAll();

	Schedule findOneById(long id);

	Schedule save(Schedule item);

	Block generateBlock(MonthEnum month,int numberOfSection, List<Faculty> faculties, List<Course> courses);
	Block generateSpecificCourseBlock(MonthEnum month,int numberOfSection, List<Faculty> faculties, Course course);
	Schedule generateSchedule(Entry entry) throws Exception;

	Schedule findOneByEntryId(Long entryId);
	List<Schedule> findAllList();
}

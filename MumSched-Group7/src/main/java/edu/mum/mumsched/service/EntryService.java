package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.model.Entry;


public interface EntryService {

	List<Entry> getList();

	Entry save(Entry entry);

	Entry findEntryById(Long id);

	void delete(Entry entry);

	boolean hasExistsEntryName(String name, long excludedId);

	boolean hasStudentRef(Entry entry);

	boolean hasScheduleRef(Entry entry);
}

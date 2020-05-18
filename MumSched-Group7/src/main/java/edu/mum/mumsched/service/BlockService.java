package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.enums.MonthEnum;
import edu.mum.mumsched.model.Block;


public interface BlockService {

	Iterable<Block> getList();

	Block findBlockById(Long id);

	boolean hasExistsBlock(long scheduleId, MonthEnum month, long excludedId);

	Block save(Block Block);

	void delete(Block Block);

	boolean hasSectionRef(Block block);
	
	Block combine2Blocks(Block b1, Block b2);

	List<Block> saveAll(List<Block> Blocks);

	Iterable<Block> findAll();
}

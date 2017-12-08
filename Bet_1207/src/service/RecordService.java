package service;

import java.util.List;

import domain.Record;

public interface RecordService {

	String registRecord(Record record);
	Record findRecord(String userId);
	void modifyRecord(Record record);
	void deleteRecord(String userId);
	
	List<Record> findByWin();
	List<Record> findByLose();
	List<Record> findByTotal();
	List<Record> findByRate();
}

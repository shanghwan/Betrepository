package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Record;
import service.RecordService;
import store.RecordStore;

@Service
public class RecordServiceLogic implements RecordService{

	@Autowired
	private RecordStore recordStore;
	
	
	@Override
	public String registRecord(Record record) {
		return recordStore.create(record);
	}

	@Override
	public Record findRecord(String userId) {
		Record record = recordStore.search(userId);
		return record;
	}

	@Override
	public void modifyRecord(Record record) {
		recordStore.update(record);
	}

	@Override
	public void deleteRecord(String userId) {
		recordStore.delete(userId);
	}

	@Override
	public List<Record> findByWin() {
		List<Record> list = recordStore.winSearch();
		return list;
	}

	@Override
	public List<Record> findByLose() {
		List<Record> list = recordStore.loseSearch();
		return list;
	}

	@Override
	public List<Record> findByTotal() {
		List<Record> list = recordStore.totalSearch();
		return list;
	}

	@Override
	public List<Record> findByRate() {
		List<Record> list = recordStore.rateSearch();
		return list;
	}

}

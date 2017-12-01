package store.mapper;

import java.util.List;

import domain.Record;

public interface RecordMapper {
	void create(Record record);
	Record search(String userId);
	void update(Record record);
	void delete(String userId);
	
	//많이이긴찾기
	List<Record> winSearch();
	//많이 진 찾기
	List<Record> loseSearch();
	//많은 횟수 찾기
	List<Record> totalSearch();
	//높은 승률 찾기
	List<Record> rateSearch();
}

package store.mapper;

import java.util.List;

import domain.Record;

public interface RecordMapper {
	void create(Record record);
	Record search(String userId);
	void update(Record record);
	void delete(String userId);
	
	//내기 많이 이긴 회원찾기
	List<Record> winSearch();
	//내기 많이 진 회원찾기
	List<Record> loseSearch();
	//내기를 많이 한 회원찾기
	List<Record> totalSearch();
	//높은 승률 회원찾기
	List<Record> rateSearch();
}

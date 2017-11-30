package store.mapper;

import java.util.List;
import java.util.Map;

public interface AttendanceMapper {

	void create(String userId);
	void delete(String userId);
	List<String> search (String userId);
	
}

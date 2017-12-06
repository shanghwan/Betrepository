package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Attendance;

public interface AttendanceMapper {

	void create(Attendance attendance);

	void delete(String userId);

	List<Attendance> search(String userId);

}

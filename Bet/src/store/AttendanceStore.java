package store;

public interface AttendanceStore {

	abstract <Attendance> String create(Attendance attendance);
}

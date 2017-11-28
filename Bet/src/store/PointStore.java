package store;

import java.util.List;

import domain.Point;

public interface PointStore {

	String create(Point point);

	List<Point> searchAll(String userId);

	String gift(Point point);

	void delete(String userId);

}

package store;

import java.util.List;

import domain.Point;

public interface PointStore {

	String create(Point point);

	List<Point> searchAll(String userId);
	
	String gift(Point point); //update임

	void delete(String userId);

}

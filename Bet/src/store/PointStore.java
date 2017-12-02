package store;

import java.util.List;

import domain.Point;
import domain.User;

public interface PointStore {

	String create(Point point);

	List<Point> searchAll(String userId);

	String gift(Point point);
	//
	void update(Point point);
	
	//
	Point searchPoint(String userId); 

	void delete(String userId);

}

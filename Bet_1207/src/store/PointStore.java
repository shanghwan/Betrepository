package store;

import java.util.List;

import domain.Point;
import domain.User;

public interface PointStore {

	String create(Point point);

	List<Point> searchAll(String userId);

	//
	void update(Point point);

	//
	Point searchPoint(String userId);

	//
	Point searchReceiver(String receiverId);

	void delete(String userId);

}

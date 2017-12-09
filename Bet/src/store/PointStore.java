package store;

import java.util.List;

import domain.Point;

public interface PointStore {

	String create(Point point);

	List<Point> searchAll(String userId);

	//
	void update(Point point);

	//
	Point searchByUserIdBetId(String userId, String receiverId);

	//
	Point searchReceiver(String receiverId);
	void deleteByPointId(String pointId);
	void delete(String userId);
	void deleteByReceiverId(String receiverId,String userId);

}

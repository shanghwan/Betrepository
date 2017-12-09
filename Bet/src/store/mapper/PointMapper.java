package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Point;

public interface PointMapper {

	void create(Point point);

	List<Point> searchAll(String userId);

	//
	Point searchByUserIdBetId(Map<String, String> map);

	void delete(String userId);

	//
	void update(Point point);

	//
	Point searchReceiver(String receiverId);
	void deleteByReceiverId(Map<String, String> map);
	void deleteByPointId(String pointId);

}

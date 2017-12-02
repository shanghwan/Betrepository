package store.mapper;

import java.util.List;

import domain.Point;

public interface PointMapper {

	void create(Point point);

	List<Point> searchAll(String userId);

	Point searchPoint(String userId);

	void delete(String userId);

	void update(Point point);

}

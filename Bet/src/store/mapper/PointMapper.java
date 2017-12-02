package store.mapper;

import java.util.List;

import domain.Point;

public interface PointMapper {

	void create(Point point);

	List<Point> searchAll(String userId);

	void gift(Point point);

	void delete(String userId);

}

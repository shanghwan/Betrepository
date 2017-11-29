package service;

import java.util.List;

import domain.Point;

public interface PointService {

	void registPoint(Point point);

	List<Point> findAllPoint(String userId);

	void removePoint(String userId);

	String setPoint(Point point);

	String presentPoint(Point point);

}

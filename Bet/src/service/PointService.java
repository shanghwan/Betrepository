package service;

import java.util.List;

import domain.Point;

public interface PointService {

	void registPoint(Point point); // 내역등록

	List<Point> findAllPoint(String userId); //내역조회

	void removePoint(String userId);

	String presentPoint(Point point);

	String attendance(Point point);

	String singUp(Point point);

	String result(Point point); // 내기승패

	// type별로.. if문대신..?

}

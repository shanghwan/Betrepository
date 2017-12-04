package service;

import java.util.List;

import domain.Point;
import domain.User;

public interface PointService {

	String registPoint(Point point); // 내역등록

	String gamePoint(Point point, String teamId);

	List<Point> findAllPoint(String userId); // 내역조회

	void removePoint(String userId); // 탈퇴

	void updatePoint(Point point);

}

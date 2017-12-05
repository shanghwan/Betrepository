package service;

import java.util.List;

import domain.Player;
import domain.Point;
import domain.Team;
import domain.User;

public interface PointService {

	String registPoint(Point point); // 내역등록

	//
	String betAllGamePoint(Point point, Team team);

	// String betOneGamePoint(Point point, String teamId);

	//
	String betTeamGamePoint(Point point, Team team);

	List<Point> findAllPoint(String userId); // 내역조회

	void removePoint(String userId); // 탈퇴

	String betTeamGamePoint(Point point, Team team, Player player);

}

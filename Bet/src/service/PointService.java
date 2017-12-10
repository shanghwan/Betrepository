package service;

import java.util.List;

import domain.Point;

public interface PointService {

   String registPoint(Point point); // 내역등록

   List<Point> findAllPoint(String userId); // 내역조회

   void removePoint(String userId); // 탈퇴

   // jun
   int giftPoint(Point point);

   String checkDayPoint(String userId);

   String betResultPoint(String teamId, int point);

   String registUserPoint(String userId);

   String betJoinPoint(String userId, String betId, int point);

   String betExitPoint(String userId, String betId);
   
   String betOfAllResultPoint(String teamId);


}

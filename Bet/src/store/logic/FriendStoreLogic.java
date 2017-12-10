package store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Friend;
import store.FriendStore;
import store.mapper.FriendMapper;

@Repository
public class FriendStoreLogic implements FriendStore {

   @Override
   public void create(String userId, String friendId) {
      SqlSession session = BetSessionFactory.getinstance().getSession();
      HashMap<String, String> map = new HashMap<>();

      try {
         FriendMapper mapper = session.getMapper(FriendMapper.class);
         map.put("userId", userId);
         map.put("friendId", friendId);
         mapper.create(map);
         session.commit();
      } finally {
         session.close();
      }
   }

   @Override
   public void delete(String userId, String friendId) {
      SqlSession session = BetSessionFactory.getinstance().getSession();
      HashMap<String, String> map = new HashMap<>();
      try {
         FriendMapper mapper = session.getMapper(FriendMapper.class);
         map.put("userId", userId);
         map.put("friendId", friendId);
         mapper.delete(map);
         session.commit();
      } finally {
         session.close();
      }
   }

   @Override
   public void deleteByFriendId(String userId) {
      SqlSession session = BetSessionFactory.getinstance().getSession();
      
      try {
         FriendMapper mapper = session.getMapper(FriendMapper.class);
         mapper.deleteByFriendId(userId);
         session.commit();
      } finally {
         session.close();
      }
   }

   @Override
   public List<Friend> search(String userId) {
      SqlSession session = BetSessionFactory.getinstance().getSession();
      List<Friend> list = null;

      try {
         FriendMapper mapper = session.getMapper(FriendMapper.class);
         list = mapper.search(userId);
      } finally {
         session.close();
      }
      return list;
   }

}
package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Friend;

public interface FriendMapper {

   void create(Map<String, String> map);
   void delete(Map<String, String> map);
   void deleteByFriendId(String userId);
   List<Friend> search(String userId);
}
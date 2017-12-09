package service.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Friend;
import domain.Record;
import domain.User;
import service.PointService;
import service.RecordService;
import service.UserService;
import store.FriendStore;
import store.UserStore;

@Service
public class UserServiceLogic implements UserService {

	@Autowired
	private UserStore userStore;
	@Autowired
	private PointService pointService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private FriendStore friendStore;

	@Override
	public User login(User user) {

		User readerUser = null;

		if (validate(user)) {
			readerUser = userStore.searchByUserId(user.getUserId());
		}
		return readerUser;

	}

	private boolean validate(User user) {
		if (user == null) {
			throw new RuntimeException("사용자 정보가 없습니다.");
		} else if (user.getUserId() == null || user.getUserId().isEmpty()) {
			throw new RuntimeException("ID가 없습니다.");
		} else if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new RuntimeException("비밀번호가 없습니다.");
		}
		return true;
	}

	@Override
	public String regist(User user) {
		String userId = userStore.create(user);
		if (userId != null) {
			pointService.registUserPoint(user.getUserId());
		}
		Record record = new Record();
		record.setUserId(userId);
		recordService.registRecord(record);
		
		
		return userId;
	}

	@Override
	public void modifyUser(User user) {

		userStore.update(user);

	}

	@Override
	public User findByUserId(String userId) {
		return userStore.searchByUserId(userId);
	}

	@Override
	public List<User> findByName(String name) {
		return null;
	}

	@Override
	public List<User> findByPoint() {

		List<User> list = userStore.searchByPoint();
		return list;
	}

	@Override
	public void remove(String userId) {
		userStore.delete(userId);
	}

	@Override
	   public void registFriend(String userId, String friendId) {
	      friendStore.create(userId, friendId);
	   }

	   @Override
	   public void removeFriend(String userId, String friendId) {
	      friendStore.delete(userId, userId);
	   }

	   @Override
	   public void removeByUserId(String userId) {
	      friendStore.deleteByFriendId(userId);
	   }

	   @Override
	   public List<Friend> findFriends(String userId) {
	      List<Friend> list = friendStore.search(userId);
	      
	      List<Friend> friends = new ArrayList<>();
	      
	      
	      for(int i=0 ; i<list.size();i++) {
	         User user = userStore.searchByUserId(list.get(i).getFriendId());
	         Friend fr = new Friend();
	         fr.setFriendId(user.getUserId());
	         fr.setName(user.getName());
	         friends.add(fr);
	      }
	      
	      return friends;
	   }

	

}

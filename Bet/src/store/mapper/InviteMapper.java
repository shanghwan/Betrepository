package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Invite;
import domain.User;

public interface InviteMapper {
	
	void create(Map<String, Object> map);
	void delete(Map<String, Object> map);
	List<String> searchByAllInviteByBetId(String betId);
	List<Invite> searchByAllInviteByUserId(String userId);

}

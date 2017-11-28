package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Point;
import service.PointService;
import store.PointStore;
import store.logic.PointStoreLogic;

@Service
public class PointServiceLogic implements PointService {
	@Autowired
	private PointStore pointStore;

	public PointServiceLogic() {
		pointStore = new PointStoreLogic();
	}
 
	@Override
	public void registPoint(Point point) {
		pointStore.create(point);
	}

	@Override
	public List<Point> findAllPoint(String userId) {
		return pointStore.searchAll(userId);
	}

	@Override
	public void removePoint(String userId) {
		pointStore.delete(userId);
	}

	@Override
	public String setPoint(Point point) {
		return null;
	}

	@Override
	public String presentPoint(Point point) {
		return null;
	}

}

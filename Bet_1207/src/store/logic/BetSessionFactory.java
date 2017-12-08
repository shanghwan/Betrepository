package store.logic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BetSessionFactory {
	private static BetSessionFactory  instance;
	private static SqlSessionFactory sqlSessionFactory;
	private static final String resource = "config.xml";
	
	
	
	private BetSessionFactory() {}
	
	public static BetSessionFactory  getinstance() {
		if(instance == null) {
			instance = new BetSessionFactory();
		}
		return instance;
	}
	
	public SqlSession getSession() {
		if(sqlSessionFactory == null) {
			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		return sqlSessionFactory.openSession();
	}
	

}

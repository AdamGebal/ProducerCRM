import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.agc.database.SessionFactoryProvider;
import com.agc.entity.Producer;

public class TestDbConnection {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryProvider.getInstance();
		Session session = sessionFactory.getCurrentSession();
		
		Producer testProducer = new Producer("Baloise", "ag@basler.de");
		
		session.beginTransaction();
		
		session.save(testProducer);
		
		session.getTransaction().commit();
	}

}

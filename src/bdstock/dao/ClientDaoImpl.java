package bdstock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.util.HibernateUtil;
import persistence.entities.TClient;

public class ClientDaoImpl implements ClientDao 
{

	@Override
	public void add(TClient o) 
	{
		 Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s
	        
		 Transaction tx = s.beginTransaction();// Commencer une transaction
	        
		 s.save(o);
		 tx.commit();// Valider la transaction
		 s.close();// Ferme la session
	}

	@Override
	public void delete(TClient o) {
		Session s = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.delete(o);// supprimer
    	tx.commit();
    	s.close();
	}

	@Override
	public List<TClient> findAll() {
		
		List<TClient> listeClient = new ArrayList<TClient>();
    	
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	listeClient = s.createQuery("from Client").list();
    	
    	return listeClient;
		
	}

	@Override
	public TClient findById(int i) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	TClient c = s.get(TClient.class, i);
    	
    	return c;
	}

}

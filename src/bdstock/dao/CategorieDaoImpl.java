package bdstock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.util.HibernateUtil;
import persistence.entities.TCategorie;

public class CategorieDaoImpl implements CategorieDao {

	@Override
	public void add(TCategorie o) 
	{
		
		 Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s
	        
		 Transaction tx = s.beginTransaction();// Commencer une transaction
	        
		 s.save(o);
		 tx.commit();// Valider la transaction
		 s.close();// Fermer la session
	}

	@Override
	public void delete(TCategorie o) {
		Session s = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.delete(o);// supprimer
    	tx.commit();
    	s.close();
	}

	@Override
	public List<TCategorie> findAll() 
	{
		List<TCategorie> listeClient = new ArrayList<TCategorie>();
    	
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	listeClient = s.createQuery("from Client").list();
    	
    	return listeClient;
		
	}

	@Override
	public TCategorie findById(int o) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	TCategorie c = s.get(TCategorie.class, o);
    	
    	return c;
	}

}

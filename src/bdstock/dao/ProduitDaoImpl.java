package bdstock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.util.HibernateUtil;
import persistence.entities.TProduit;

public class ProduitDaoImpl implements ProduitDao
{

	@Override
	public void add(TProduit o) 
	{
		
		 Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s
	        
		 Transaction tx = s.beginTransaction();// Commencer une transaction
	        
		 s.save(o);
		 tx.commit();// Valider la transaction
		 s.close();// Fermer la session
	}

	@Override
	public void delete(TProduit o) 
	{
		
		Session s = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.delete(o);// supprimer
    	tx.commit();
    	s.close();
	}

	@Override
	public List<TProduit> findAll() 
	{
		
		List<TProduit> listeClient = new ArrayList<TProduit>();
    	
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	listeClient = s.createQuery("from Client").list();
    	
    	return listeClient;
	}

	@Override
	public TProduit findById(int o) 
	{
		
		Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	TProduit c = s.get(TProduit.class, o);
    	
    	return c;
	}

}

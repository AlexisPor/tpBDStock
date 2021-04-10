package bdstock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.util.HibernateUtil;
import persistence.entities.TCommande;

public class CommandeDaoImpl implements CommandeDao
{

	@Override
	public void add(TCommande o) 
	{
		
		  Session s = HibernateUtil.getSessionFactory().openSession(); // Ouvrir une session s
	        
		  Transaction tx = s.beginTransaction();// Commencer une transaction
	        
		  s.save(o);
		  tx.commit();// Valider la transaction
		  s.close();// Fermer la session
	}

	@Override
	public void delete(TCommande o) 
	{
		
		Session s = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.delete(o);// supprimer
    	tx.commit();
    	s.close();
	}

	@Override
	public List<TCommande> findAll() 
	{
		
		List<TCommande> listeClient = new ArrayList<TCommande>();
    	
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	listeClient = s.createQuery("from Client").list();
    	
    	return listeClient;
	}

	@Override
	public TCommande findById(int o) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
    	
    	TCommande c = s.get(TCommande.class, o);
    	
    	return c;
	}

}

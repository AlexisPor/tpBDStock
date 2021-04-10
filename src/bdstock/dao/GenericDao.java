package bdstock.dao;

import java.util.List;

public interface GenericDao<T> 
{
	
 void add(T o);
 
 void delete(T o);
 
 List<T> findAll();

T findById(int o);
 
}

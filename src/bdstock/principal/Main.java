package bdstock.principal;

import java.math.BigDecimal;

import bdstock.dao.ClientDaoImpl;
import bdstock.dao.ProduitDaoImpl;
import persistence.entities.TClient;
import persistence.entities.TProduit;

public class Main 
{
	public static void main(String[] args) 
	{
		/*ClientDaoImpl cImpl = new ClientDaoImpl();
		TClient client = new TClient();
		client.setCPrenomclient("BBBBBBB");
		client.setCNomclient("BBBB");
		client.setCVilleadrclient("ZZZZZZZ");
		client.setCIdclient(new BigDecimal(6));
		
		cImpl.add(client);*/
		
		ProduitDaoImpl pImpl = new ProduitDaoImpl();
		TProduit produit = new TProduit();
		produit.setPMarqueproduit("Adidas");	
		pImpl.add(produit);
		
	}
	
}

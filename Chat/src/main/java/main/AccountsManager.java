package main;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import dao.Account;
import util.HibernateUtil;


public class AccountsManager {
	public AccountsManager(){
		
	}
	//	Créer des comptes
	public void addaccount(Account a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(a);

		session.getTransaction().commit();
	}
	//	Lister le contenu de la table accounts
	public List<Account> listaccounts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Account> result = session.createQuery("FROM Account").list();
		session.getTransaction().commit();
		return result;
	}
	
	public boolean CheckAccount (String username,String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		List<Account> accounts = criteria.list();
		for (Account account : accounts) {
			if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
				return true;
			}
			
		}
		session.close();
		sessionFactory.close();
		return false;
	}
	
	public Account FoundAccount(String username,String password) {
		
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Account.class);
			List<Account> accounts = criteria.list();
			for (Account account : accounts) {
				if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
					return account;
				}
			}
			session.close();
			sessionFactory.close();
			return null;
			
		
	}
	
	public Account AccountById(Long idaccount) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		List<Account> accounts = criteria.list();
		for (Account account : accounts) {
			if(account.getIdAccount()==(idaccount)) {
				return account;
			}
		}
		session.close();
		sessionFactory.close();
		return null;
		
	
	}
	
	public void deleteAccountByUsername(String username) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    try {
	        Criteria criteria = session.createCriteria(Account.class);
	        criteria.add(Restrictions.eq("username", username));
	        
	        List<Account> accounts = criteria.list();
	        
	        if (!accounts.isEmpty()) {
	            for (Account account : accounts) {
	                session.delete(account);
	            }
	            System.out.println("Account(s) deleted successfully!");
	        } else {
	            System.out.println("No account found with the given username!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}


    
    // ...

	
//	public static void main(String[] args) {
		
//		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
//		AccountsManager gestManager = new AccountsManager();
//		Account temp = new Account("Hatim","hatim","hatim@mail.com","123");
//		gestManager.addaccount(temp);
//		temp = new Account("Zahiri","zahiri","zahiri@mail.com","123");
//		gestManager.addaccount(temp);
//		temp = new Account("Hatim","hatim","hatim@mail.com","123");
//		gestManager.addaccount(temp);
//		//Afficher toutes les comptes
//		gestManager.CheckAcount("hatim","111");
////		List listA = gestManager.listaccounts();
////		Iterator lesA = listA.iterator();
////		while (lesA.hasNext()) {
////			Account r = (Account) lesA.next();
////			System.out.println(r.getIdAccount() + "--" + r.getName() + "--" + r.getUsername()+ "--"+ r.getPassword());
////		}
//		
//	}

}


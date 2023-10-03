package main;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.Message;
import util.HibernateUtil;


public class MessageManager {
	public MessageManager(){
		
	}
	//	Créer des messages
	public void addMessage(Message a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(a);

		session.getTransaction().commit();
	}
	//	Lister le contenu de la table Messages
	public List<Message> listMessages() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Message> result = session.createQuery("FROM Message").list();
		session.getTransaction().commit();
		return result;
	}
	
	
	public Message MessageBySession(String username) {
		
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Message.class);
			List<Message> Messages = criteria.list();
			for (Message Message : Messages) {
				if(Message.getusername().equals(username)) {
					return Message;
				}
			}
			session.close();
			sessionFactory.close();
			return null;
			
		
	}
	
	public Message MessageByIdAccount(Long idAccount) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Message.class);
		List<Message> Messages = criteria.list();
		for (Message Message : Messages) {
			if(Message.getIdAccount()==idAccount) {
				return Message;
			}
		}
		session.close();
		sessionFactory.close();
		return null;

}
	
//	public static void main(String[] args) {
//		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
//		MessageManager gestManager = new MessageManager();
//		Message temp = new Message("Hatim","hatim","hatim@mail.com","123");
//		gestManager.addMessage(temp);
//		temp = new Message("Zahiri","zahiri","zahiri@mail.com","123");
//		gestManager.addMessage(temp);
//		temp = new Message("Hatim","hatim","hatim@mail.com","123");
//		gestManager.addMessage(temp);
//		//Afficher toutes les comptes
//		gestManager.CheckAcount("hatim","111");
////		List listA = gestManager.listMessages();
////		Iterator lesA = listA.iterator();
////		while (lesA.hasNext()) {
////			Message r = (Message) lesA.next();
////			System.out.println(r.getIdMessage() + "--" + r.getName() + "--" + r.getUsername()+ "--"+ r.getPassword());
////		}
//		
//	}

}

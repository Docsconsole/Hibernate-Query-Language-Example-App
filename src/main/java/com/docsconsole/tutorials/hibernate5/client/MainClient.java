package com.docsconsole.tutorials.hibernate5.client;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.docsconsole.tutorials.hibernate5.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class MainClient {

	public static void main(String[] args) {

		System.out.println("Main method@MainClient");

		try {

			// Get Session
			Session session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Session is created");

			// start transaction
			Transaction tx = session.beginTransaction();
			Query query=session.createQuery("from Account");//here persistent class name is Emp
			List list=query.list();


			Query query1=session.createQuery("from Account");
			query1.setFirstResult(2);
			query1.setMaxResults(4);
			List list1 = query1.list(); //will return the records from 2 to 4th number
			list1.forEach(System.out::println);


			Query query2 = session.createQuery("update Account set status=:status where id=:i");
			query2.setParameter("status","inactive");
			query2.setParameter("i",200001l);
			int status = query2.executeUpdate();
			System.out.println(status);


			Query query3=session.createQuery("from Account");
			List list3 = query3.list();
			list3.forEach(System.out::println);


			tx.commit();
			session.close();
			System.out.println("Session is closed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
package com.khadri.hibernate.hql.functions;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Registration;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {
		Session session = StandardRegistryUtil
				.createSession(Registration.class);

		Query<Integer> query1 = session.createQuery(
				"select extract(YEAR from r.regTime) from Registration r ",
				Integer.class);
		query1.getResultList().stream().findFirst().ifPresent((year) -> {
			System.out.println("Year ===> " + year);
		});;
		
		
		Query<Integer> query2 = session.createQuery(
				"select extract(MONTH from r.regTime) from Registration r ",
				Integer.class);
		query2.getResultList().stream().findFirst().ifPresent((month) -> {
			System.out.println("Month ===> " + month);
		});;
		
		Query<Integer> query3 = session.createQuery(
				"select extract(DAY from r.regTime) from Registration r ",
				Integer.class);
		query3.getResultList().stream().findFirst().ifPresent((day) -> {
			System.out.println("Day ===> " + day);
		});;
		
		Query<Integer> query4 = session.createQuery(
				"select extract(HOUR from r.regTime) from Registration r ",
				Integer.class);
		query4.getResultList().stream().findFirst().ifPresent((hour) -> {
			System.out.println("Hour ===> " + hour);
		});;
		
		Query<Integer> query5 = session.createQuery(
				"select extract(MINUTE from r.regTime) from Registration r ",
				Integer.class);
		query5.getResultList().stream().findFirst().ifPresent((minute) -> {
			System.out.println("Minute ===> " + minute);
		});
		
		Query<Integer> query6 = session.createQuery(
				"select extract(SECOND from r.regTime) from Registration r ",
				Integer.class);
		query6.getResultList().stream().findFirst().ifPresent((sec) -> {
			System.out.println("Second ===> " + sec);
		});;

		// insertRegistration(session);
	}

	private static void insertRegistration(Session session) {
		Transaction txn = session.beginTransaction();
		Registration r = new Registration();
		r.setRegDate(new java.sql.Date(new java.util.Date().getTime()));
		r.setRegTime(new Timestamp(new java.util.Date().getTime()));

		session.save(r);

		txn.commit();
	}
}

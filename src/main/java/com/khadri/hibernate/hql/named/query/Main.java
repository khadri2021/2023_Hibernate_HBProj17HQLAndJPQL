package com.khadri.hibernate.hql.named.query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Company;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Session session = StandardRegistryUtil.createSession(Company.class);

		Query<Company> query1 = session.createNamedQuery(
				Company.NamedQueriesConstants.BY_LOCATION, Company.class);

		query1.setParameter("loc", "KADIRI");
		query1.getResultList().forEach((comp) -> {
			System.out.println(comp.getId());
			System.out.println(comp.getName());
			System.out.println(comp.getLocation());
		});

		Query<Company> query2 = session
				.createNamedQuery(Company.NamedQueriesConstants.BY_NAME, Company.class);

		query2.setParameter("name", "TCS");
		query2.getResultList().forEach((comp) -> {
			System.out.println(comp.getId());
			System.out.println(comp.getName());
			System.out.println(comp.getLocation());
		});

		insert(session);

	}

	private static void insert(Session session) {
		Transaction txn = session.beginTransaction();
		Company c1 = new Company();
		c1.setName("TCS");
		c1.setLocation("GORANTLA");

		session.save(c1);

		txn.commit();
	}
}

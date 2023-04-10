package com.khadri.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Chicken;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {
		Class<?> class1 = Chicken.class;
		Session session = StandardRegistryUtil.createSession(class1);

		// HQL Query
		Query<Chicken> query1 = session.createQuery(
				"select c from Chiken1 c where name =?1", Chicken.class);

		query1.setParameter(1, "KADAKANATH");
		List<Chicken> list = query1.getResultList();

		System.out.println("Chicken Order Details for name =====>");
		for (Chicken chicken : list) {
			System.out.println(chicken.getId());
			System.out.println(chicken.getName());
			System.out.println(chicken.getCost());
			System.out.println(chicken.getQty());
		}

		Query<Chicken> query2 = session.createQuery(
				"select chicken from Chiken1 chicken where qty = ?1",
				Chicken.class);

		query2.setParameter(1, 2);

		List<Chicken> results = query2.getResultList();

		System.out.println("Chicken Order Details for qty =====>");
		for (Chicken chicken : results) {
			System.out.println(chicken.getId());
			System.out.println(chicken.getName());
			System.out.println(chicken.getCost());
			System.out.println(chicken.getQty());
		}
		Query<Chicken> query3 = session.createQuery(
				"select chicken from Chiken1 chicken where cost <= ?1",
				Chicken.class);

		query3.setParameter(1, 200.00);
		List<Chicken> results2 = query3.getResultList();

		System.out.println("Chicken Order Details for cost =====>");
		for (Chicken chicken : results2) {
			System.out.println(chicken.getId());
			System.out.println(chicken.getName());
			System.out.println(chicken.getCost());
			System.out.println(chicken.getQty());
		}

		Query<Chicken> query4 = session.createQuery(
				"select chicken from Chiken1 chicken where cost <= ?1 and cost > ?2",
				Chicken.class);

		query4.setParameter(1, 200.00);
		query4.setParameter(2, 100.00);

		List<Chicken> results3 = query4.getResultList();

		System.out.println(
				"Chicken Order Details for cost lessthan and greater than =====>");
		for (Chicken chicken : results3) {
			System.out.println(chicken.getId());
			System.out.println(chicken.getName());
			System.out.println(chicken.getCost());
			System.out.println(chicken.getQty());
		}

		 insertChicken(session);
	}

	private static void insertChicken(Session session) {
		Transaction txn = session.beginTransaction();
		Chicken chicken = new Chicken();
		chicken.setName("VENCOFF");
		chicken.setQty(2);
		chicken.setCost(150.00);
		session.save(chicken);
		txn.commit();
	}
}

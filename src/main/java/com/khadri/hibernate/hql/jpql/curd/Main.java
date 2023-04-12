package com.khadri.hibernate.hql.jpql.curd;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Food;
import com.khadri.hibernate.entities.Food1;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Session session = StandardRegistryUtil.createSession(Food.class,
				Food1.class);

		Transaction txn = session.beginTransaction();
		Query<Food> updateQuery = session.createQuery(
				"update Food set cost=:newCost where name=:tiffenName");

		updateQuery.setParameter("newCost", "300");
		updateQuery.setParameter("tiffenName", "POORI");

		int result = updateQuery.executeUpdate();
		System.out.println(result + " updated successfuly");

		Query deleteQuery = session
				.createQuery("delete from Food where id=:value");
		deleteQuery.setParameter("value", 10L);
		int deleteResult = deleteQuery.executeUpdate();
		System.out.println(deleteResult + " deleted successfuly");

		Query insertQuery = session.createQuery(
				"insert into Food(id,cost,name) select f.id,f.cost,f.name from Food1 f where f.id=:value");
		insertQuery.setParameter("value", 10L);
		int insertResult = insertQuery.executeUpdate();
		System.out.println(insertResult + " inserted successfuly");

		txn.commit();
	}
}

package com.khadri.hibernate.hql.jpql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Food;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Session session = StandardRegistryUtil.createSession(Food.class);
//		Query query = session.createQuery("select f from Food f where name=:tiffenName");//HQL
		Query query = session.createQuery("from Food where name=:tiffenName");//JPQL
		query.setParameter("tiffenName", "VADA");
		List list = query.getResultList();
		System.out.println(list);
		
		Query<Food> namedQuery = session.getNamedQuery("find_cost");
		namedQuery.setParameter("tiffenCost", "60");
		Food food = namedQuery.getSingleResult();

		System.out.println(food.getName());
		System.out.println(food.getCost());
		System.out.println(food.getId());
	}
}

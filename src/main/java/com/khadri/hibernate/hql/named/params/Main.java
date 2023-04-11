package com.khadri.hibernate.hql.named.params;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Chicken;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {
	public static void main(String[] args) {
		Class<?> class1 = Chicken.class;
		Session session = StandardRegistryUtil.createSession(class1);

		Query<Chicken> query1 = session.createQuery(
				"select c from Chiken1 c where name =:chickenName",
				Chicken.class);
		query1.setParameter("chickenName", "KADAKANATH");
		List<Chicken> list1 = query1.getResultStream().map((ch) -> {
			ch.setQty(4);
			return ch;
		}).collect(Collectors.toList());

		displayChickenInformation(list1);

		Query<Chicken> query2 = session.createQuery(
				"select c from Chiken1 c where qty =:chickenQuantity",
				Chicken.class);
		query2.setParameter("chickenQuantity", 1);
		List<Chicken> list2 = query2.getResultStream().map((ch) -> {
			ch.setCost(180.98);
			return ch;
		}).collect(Collectors.toList());

		displayChickenInformation(list2);

		Query<Chicken> query3 = session.createQuery(
				"select c from Chiken1 c where cost > :minValue and cost <= :maxValue",
				Chicken.class);
		query3.setParameter("minValue", 100.00);
		query3.setParameter("maxValue", 1300.00);
		List<Chicken> list3 = query3.getResultList();

		displayChickenInformation(list3);
	}

	private static void displayChickenInformation(List<Chicken> list1) {

		System.out.println("########### Chicken Information ###########");
		for (Chicken chicken : list1) {
			System.out.println(chicken.getId());
			System.out.println(chicken.getName());
			System.out.println(chicken.getQty());
			System.out.println(chicken.getCost());
		}
	}
}

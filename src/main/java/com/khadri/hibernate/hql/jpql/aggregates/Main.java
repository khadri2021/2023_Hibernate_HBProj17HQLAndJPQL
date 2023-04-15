package com.khadri.hibernate.hql.jpql.aggregates;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.khadri.hibernate.entities.Employee;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Session session = StandardRegistryUtil.createSession(Employee.class);

		Query<Long> query1 = session
				.createQuery("select count(e) from Employee e", Long.class);
		Long noOfEmployees = query1.getSingleResult();
		System.out.println(noOfEmployees + " Employees are available ");

		Query<Double> query2 = session.createQuery(
				"select max(e.salary) from Employee e", Double.class);
		Double maxSalaryOfEmployee = query2.getSingleResult();
		System.out.println("This " + maxSalaryOfEmployee
				+ " Amount is Max salary of Employee ");

		Query<Double> query3 = session.createQuery(
				"select min(e.salary) from Employee e", Double.class);
		Double minSalaryOfEmployee = query3.getSingleResult();
		System.out.println("This " + minSalaryOfEmployee
				+ " Amount is Min salary of Employee ");

		Query<Integer> query4 = session.createQuery(
				"select max(e.workingDays) from Employee e", Integer.class);
		Integer maxWorkingDays = query4.getSingleResult();
		System.out.println(
				"The max " + maxWorkingDays + " working days of Employee ");

		Query<Employee> maxEmployeeQuery = session.createQuery(
				"select e from Employee e where e.workingDays =:maxDays",
				Employee.class);
		maxEmployeeQuery.setParameter("maxDays", maxWorkingDays);

		System.out.println("==== Best Employee ====");
		maxEmployeeQuery.getResultList().stream().findFirst()
				.ifPresent((emp) -> {
					System.out.println("EMP ID: " + emp.getId());
					System.out.println("EMP NAME: " + emp.getName());
					System.out.println("EMP SALARY: " + emp.getSalary());
					System.out.println(
							"EMPWORKING DAYS: " + emp.getWorkingDays());
					System.out.println("EMP HIKE: " + emp.getHike());
					System.out
							.println("EMP SICK LEAVES: " + emp.getSickLeaves());
				});

		// insertEmployee(session);
	}

	private static void insertEmployee(Session session) {
		Transaction txn = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("THORSTEN");
		e1.setSalary(700000.98);
		e1.setSickLeaves(10);
		e1.setWorkingDays(20);
		e1.setHike(60000.00);
		session.save(e1);

		txn.commit();
	}
}

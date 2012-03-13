package junit.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.edu.bean.Person;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistences");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Person("不想读书"));
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	
	@Test
	public void getPerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistences");
		EntityManager entityManager = factory.createEntityManager();
		Person person = entityManager.find(Person.class,1);
		System.out.println(person.getName());
		entityManager.close();
		factory.close();
	}
	
	@Test
	public void getPerson2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistences");
		EntityManager entityManager = factory.createEntityManager();
		Person person = entityManager.getReference(Person.class,1);  //相当于load
		System.out.println(person.getName());
		entityManager.close();
		factory.close();
	}
	
	@Test
	public void updatePerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistences");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Person person = entityManager.getReference(Person.class,1);
		person.setName("老张");
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	
	@Test
	public void deletePerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistences");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Person person = entityManager.getReference(Person.class,1);
		entityManager.remove(person);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
}

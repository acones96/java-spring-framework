package org.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.telusko.hibernate.Alien;
import org.telusko.hibernate.Laptop;
import org.telusko.hibernate.Student;
import org.telusko.hql.LaptopHQL;
import org.telusko.mapping.AlienMapping;
import org.telusko.mapping.LaptopMapping;

import java.util.List;

public class Main {

    static void create() {
        Student s1 = new Student();

        s1.setName("Acones");
        s1.setRollno(101);
        s1.setAge(27);

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Student.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
//        session.save(s1); // This method is not recommended since V 6.0
        session.persist(s1);

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }

    static void createAlien() {
        Laptop l1 = new Laptop();
        l1.setBrand("HP");
        l1.setMemory(16);
        l1.setModel("Omen");

        Alien a1 = new Alien();
        a1.setTech("Java");
        a1.setName("koneek");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Alien.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(a1);

        transaction.commit();
        System.out.println(a1);


        Alien a2 = session.get(Alien.class, 1);
        System.out.println(a2);

        session.close();
        sf.close();
    }

    static void read() {
        Student s2 = null;

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Student.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        s2 = session.get(Student.class, 102);


        session.close();
        sf.close();

        System.out.println(s2);
    }

    static void update() {
        Student s1 = new Student();

        s1.setName("New Harsh");
        s1.setRollno(107);
        s1.setAge(20);

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Student.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s1); // Change the data from the DB

        transaction.commit(); // If the value doesn't exist, it will create a new one instead of update it. This method would be saverOrUpdate()

        session.close();
        sf.close();

        System.out.println(s1);
    }

    static void delete() {

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Student.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Student s1 = session.get(Student.class, 107);

        Transaction transaction = session.beginTransaction();

        session.remove(s1); // Delete the data from the DB. We can fetch an object or directly use it

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }

    static void createAlienComputerOneToOne() {
        LaptopMapping l1 = new LaptopMapping();
        l1.setBrand("HP");
        l1.setMemory(16);
        l1.setModel("Omen");

        AlienMapping a1 = new AlienMapping();
        a1.setTech("Java");
        a1.setName("koneek");
//        a1.setLaptop(l1); // Need modification for @OneToOne

        SessionFactory sf = new Configuration().
                addAnnotatedClass(AlienMapping.class).
                addAnnotatedClass(LaptopMapping.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(a1);

        transaction.commit();
        System.out.println(a1);


        AlienMapping a2 = session.get(AlienMapping.class, 1);
        System.out.println(a2);

        session.close();
        sf.close();
    }

    static void createAlienComputerManyToOne() {
        LaptopMapping l1 = new LaptopMapping();
        l1.setBrand("HP");
        l1.setMemory(16);
        l1.setModel("Omen");

        LaptopMapping l2 = new LaptopMapping();
        l2.setBrand("Asus");
        l2.setMemory(16);
        l2.setModel("ROG");

        AlienMapping a1 = new AlienMapping();
        a1.setTech("Java");
        a1.setName("koneek");
        a1.setLaptopMappings(List.of(l1, l2));

//        l1.setAlienMapping(a1);
//        l2.setAlienMapping(a1);

        SessionFactory sf = new Configuration().
                addAnnotatedClass(AlienMapping.class).
                addAnnotatedClass(LaptopMapping.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        transaction.commit();
        System.out.println(a1);


        AlienMapping a2 = session.get(AlienMapping.class, 1);
        System.out.println(a2);

        session.close();
        sf.close();
    }

    static void createAlienComputerManyToMany() {
        LaptopMapping l1 = new LaptopMapping();
        l1.setBrand("HP");
        l1.setMemory(16);
        l1.setModel("Omen");

        LaptopMapping l2 = new LaptopMapping();
        l2.setBrand("Asus");
        l2.setMemory(16);
        l2.setModel("ROG");

        LaptopMapping l3 = new LaptopMapping();
        l3.setBrand("Apple");
        l3.setMemory(16);
        l3.setModel("McBook");

        AlienMapping a1 = new AlienMapping();
        a1.setTech("Java");
        a1.setName("koneek");
        a1.setLaptopMappings(List.of(l1, l2));

        AlienMapping a2 = new AlienMapping();
        a2.setTech("Java");
        a2.setName("koneek");
        a2.setLaptopMappings(List.of(l3));

//        l1.setAlienMappings(List.of(a1));
//        l2.setAlienMappings(List.of(a1));
//        l3.setAlienMappings(List.of(a2));

        SessionFactory sf = new Configuration().
                addAnnotatedClass(AlienMapping.class).
                addAnnotatedClass(LaptopMapping.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();

        System.out.println(a1);

        AlienMapping a3 = session.get(AlienMapping.class, 1);
        System.out.println(a3);

        session.close();
        sf.close();
    }

    static void createAlienComputerFetchEager() {
        LaptopMapping l1 = new LaptopMapping();
        l1.setBrand("HP");
        l1.setMemory(16);
        l1.setModel("Omen");

        LaptopMapping l2 = new LaptopMapping();
        l2.setBrand("Asus");
        l2.setMemory(16);
        l2.setModel("ROG");

        LaptopMapping l3 = new LaptopMapping();
        l3.setBrand("Apple");
        l3.setMemory(16);
        l3.setModel("McBook");

        AlienMapping a1 = new AlienMapping();
        a1.setTech("Java");
        a1.setName("koneek");
        a1.setLaptopMappings(List.of(l1, l2));

        AlienMapping a2 = new AlienMapping();
        a2.setTech("Java");
        a2.setName("koneek");
        a2.setLaptopMappings(List.of(l3));

        SessionFactory sf = new Configuration().
                addAnnotatedClass(AlienMapping.class).
                addAnnotatedClass(LaptopMapping.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();

        System.out.println("****** Fetch with caching (first level - session-scoped) and eager loading");
        AlienMapping a3 = session.load(AlienMapping.class, 1);
        System.out.println(a3);

        session.close();

        Session session1 = sf.openSession();

        System.out.println("****** Fetch with eager (second level - configurable) and lazy loading");
        AlienMapping a4 = session1.byId(AlienMapping.class).getReference(2);
        System.out.println(a4);

        session1.close();

        sf.close();
    }

    static void fetchHQL() {
        SessionFactory sf = new Configuration().
                addAnnotatedClass(LaptopHQL.class).
                configure().
                buildSessionFactory();
        Session session = sf.openSession();

        int memory = 16;
        // SELECT brand FROM laptop WHERE memory=16 -> SQL
        Query query = session.createQuery("SELECT brand, model FROM LaptopHQL WHERE memory=?1");
        query.setParameter(1, memory); // We can set the parameters using '?' and the number that represent the parameter order
        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops)
            System.out.println((String)data[0] + ", " + (String) data[1]);


        session.close();
        sf.close();
    }

    public static void main(String[] args) {
//        create();
//        createAlien();
//        createAlienComputerOneToOne();
//        createAlienComputerManyToOne();
//        createAlienComputerManyToMany();
//        createAlienComputerFetchEager();
        fetchHQL();
//        read();
//        update();
//        delete();
    }
}
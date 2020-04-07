/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company1;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Company1 {

    public static void main(String[] args) {
        SessionFactory s;
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("company1/hibernate.cfg.xml").build();

            // Create a metadata sources using the specified service registry.
          Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            s = metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        // SessionFactory s = new Configuration().configure("Company1/hibernate.cfg.xml").buildSessionFactory(); 
        Session session = s.openSession();

        try {
            session.beginTransaction();

            Department dept = new Department();
            dept.setDeptname("cvv");
            dept.setId(125);

            session.save(dept);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        try {

            session.getTransaction().begin();
            Employee emp = new Employee();
            emp = (Employee) session.get(Employee.class, 177);
            emp.setName("ahmedd");
            session.update(emp);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();

        }

    }

}

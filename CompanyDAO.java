package dao;

import entity.Client;
import entity.Company;
import entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

public class CompanyDAO {


        public void create(Company company) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(company);
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void addClientsToCompany(Company company, Client client) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
          //  session.get;
            company.getClients().add(client);
            client.getCompanies().add(company);
            transaction.commit();
        } finally {
            session.close();
        }//return company;

    }

    }

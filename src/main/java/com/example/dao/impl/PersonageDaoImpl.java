package com.example.dao.impl;

import com.example.dao.PersonageDao;
import com.example.exception.DataProcessingException;
import com.example.model.Personage;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PersonageDaoImpl implements PersonageDao {
    private final SessionFactory sessionFactory;

    public PersonageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Personage add(Personage personage) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(personage);
            transaction.commit();
            return personage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert personage to DB with id"
                    + personage.getId(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Personage getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Personage.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Personage entity with id " + id, e);
        }
    }

    @Override
    public List<Personage> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Personage> query = session.createQuery("FROM Personage WHERE name LIKE :name",
                    Personage.class);
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available personage with names"
                    + "which contain " + name, e);
        }
    }
}

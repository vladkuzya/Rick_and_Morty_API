package com.example.dao.impl;

import com.example.dao.LocationDao;
import com.example.exception.DataProcessingException;
import com.example.model.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDao {
    protected final SessionFactory sessionFactory;

    public LocationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location add(Location location) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
            return location;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert location to DB with id "
                    + location.getId(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Location getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Location.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Location entity with id " + id, e);
        }
    }

    @Override
    public void addAll(List<Location> locations) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            for (Location location : locations) {
                transaction = session.beginTransaction();
                session.save(location);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert all locations to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

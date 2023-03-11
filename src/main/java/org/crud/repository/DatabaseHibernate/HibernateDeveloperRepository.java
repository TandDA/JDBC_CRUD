package org.crud.repository.DatabaseHibernate;

import org.crud.model.Developer;
import org.crud.model.Skill;
import org.crud.model.Status;
import org.crud.repository.DeveloperRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDeveloperRepository implements DeveloperRepository {
    HibernateContext hibernateContext = HibernateContext.getHibernateContext();
    @Override
    public Developer getById(Integer id) {
        Developer developer = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            developer = (Developer) session.get(Developer.class, id);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return developer;
        }
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developerList = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            developerList = session.createQuery("FROM Developer dev JOIN FETCH dev.skills JOIN FETCH dev.specialty").list();

            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developerList;
        }
    }

    @Override
    public Developer save(Developer developer) {
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developer;
        }
    }

    @Override
    public Developer update(Developer newDeveloper) {
        Developer developerToUpdate = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            developerToUpdate = (Developer) session.get(Developer.class, newDeveloper.getId());
            developerToUpdate.setFirstName(newDeveloper.getFirstName());
            developerToUpdate.setLastName(newDeveloper.getLastName());
            developerToUpdate.setSpecialty(newDeveloper.getSpecialty());

            session.update(developerToUpdate);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return developerToUpdate;
        }
    }

    @Override
    public void deleteById(Integer id) {
        Developer developerToDelete = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            developerToDelete = (Developer) session.get(Developer.class, id);
            developerToDelete.setStatus(Status.DELETED);
            session.update(developerToDelete);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

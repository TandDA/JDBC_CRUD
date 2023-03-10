package org.crud.repository.DatabaseHibernate;

import org.crud.model.Developer;
import org.crud.model.Specialty;
import org.crud.model.Status;
import org.crud.repository.SpecialtyRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSpecialtyRepository implements SpecialtyRepository {
    private HibernateContext hibernateContext = HibernateContext.getHibernateContext();

    @Override
    public Specialty getById(Integer id) {
        Specialty specialty = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            specialty = (Specialty) session.get(Specialty.class, id);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return specialty;
        }
    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialtyList = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            specialtyList = session.createQuery("FROM Specialty").list();

            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return specialtyList;
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialty);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return specialty;
        }
    }

    @Override
    public Specialty update(Specialty newSpecialty) {
        Specialty specialtyToUpdate = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            specialtyToUpdate = (Specialty) session.get(Specialty.class, newSpecialty.getId());
            specialtyToUpdate.setSpecName(newSpecialty.getSpecName());
            session.update(specialtyToUpdate);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return specialtyToUpdate;
        }
    }

    @Override
    public void deleteById(Integer id) {
        Specialty specialtyToDelete = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            specialtyToDelete = (Specialty) session.get(Specialty.class, id);
            specialtyToDelete.setStatus(Status.DELETED);
            session.update(specialtyToDelete);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

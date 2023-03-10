package org.crud.repository.DatabaseHibernate;

import org.crud.model.Skill;
import org.crud.model.Specialty;
import org.crud.model.Status;
import org.crud.repository.SkillRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSkillRepository implements SkillRepository {
    HibernateContext hibernateContext = HibernateContext.getHibernateContext();
    @Override
    public Skill getById(Integer id) {
        Skill skill = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            skill = (Skill) session.get(Skill.class, id);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return skill;
        }
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            skillList = session.createQuery("FROM Skill").list();

            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return skillList;
        }
    }

    @Override
    public Skill save(Skill skill) {
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return skill;
        }
    }

    @Override
    public Skill update(Skill newSkill) {
        Skill skillToUpdate = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            skillToUpdate = (Skill) session.get(Skill.class, newSkill.getId());
            skillToUpdate.setName(newSkill.getName());
            session.update(skillToUpdate);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return skillToUpdate;
        }
    }

    @Override
    public void deleteById(Integer id) {
        Skill skillToDelete = null;
        try (Session session = hibernateContext.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            skillToDelete = (Skill) session.get(Skill.class, id);
            skillToDelete.setStatus(Status.DELETED);
            session.update(skillToDelete);
            transaction.commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

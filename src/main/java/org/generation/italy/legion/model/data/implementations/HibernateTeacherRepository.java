package org.generation.italy.legion.model.data.implementations;

import jakarta.persistence.EntityManager;
import org.generation.italy.legion.model.data.abstractions.TeacherRepository;
import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.generation.italy.legion.model.data.HibernateConstants.*;

@Repository
@Profile("hibernate")
public class HibernateTeacherRepository extends GenericCrudRepository<Teacher> implements TeacherRepository {

    @Autowired
    public HibernateTeacherRepository(EntityManager em) {
        super(em, Teacher.class);
    }

    @Override
    public Iterable<Teacher> findWithCompetenceByLevel(Level teacherLevel) throws DataException {
        return session.createSelectionQuery(HQL_FIND_TEACHER_BY_LEVEL, Teacher.class)
                .setParameter("level", teacherLevel).list();

    }

    @Override
    public List<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel) {
        return session.createSelectionQuery(HQL_FIND_TEACHER_BY_SKILL_LEVEL, Teacher.class)
              .setParameter("level", competenceLevel)
              .setParameter("id", idSkill).list();
    }
    //una funzione che trovi tutti i teacher che hanno insegnato a N editionModule
    public Iterable<Teacher> findTeachersByNCourseEdition(int n){
        return session.createSelectionQuery(HQL_FIND_TEACHERS_BY_COURSE_EDITION, Teacher.class)
              .setParameter("n", n).list();
    }

}

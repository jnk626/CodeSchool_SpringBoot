package org.generation.italy.legion.model.data.abstractions;

import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;

import java.util.List;

public interface TeacherRepository extends AbstractCrudRepository<Teacher>{
    Iterable<Teacher> findWithCompetenceByLevel(Level teacherLevel) throws DataException;
    List<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel);
}

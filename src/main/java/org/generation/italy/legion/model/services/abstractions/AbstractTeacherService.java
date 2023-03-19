package org.generation.italy.legion.model.services.abstractions;

import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;

import java.util.List;

public interface AbstractTeacherService {
    List<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel);
}

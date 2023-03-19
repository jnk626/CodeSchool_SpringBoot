package org.generation.italy.legion.model.services.implementations;

import org.generation.italy.legion.model.data.abstractions.TeacherRepository;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractTeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardTeacherService implements AbstractTeacherService {

    private TeacherRepository repository;

    public StandardTeacherService(TeacherRepository repo) {
        this.repository = repo;
    }
    @Override
    public List<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel) {
        return repository.findWithSkillAndLevel(idSkill, competenceLevel);
    }
}

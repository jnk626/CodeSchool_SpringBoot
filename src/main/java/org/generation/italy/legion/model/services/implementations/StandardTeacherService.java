package org.generation.italy.legion.model.services.implementations;

import org.generation.italy.legion.model.data.abstractions.TeacherRepository;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardTeacherService implements AbstractTeacherService {

    private TeacherRepository repository;

    @Autowired
    public StandardTeacherService(TeacherRepository repo) {
        this.repository = repo;
    }

    public void setRepository(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel) {
        return repository.findWithSkillAndLevel(idSkill, competenceLevel);
    }
}

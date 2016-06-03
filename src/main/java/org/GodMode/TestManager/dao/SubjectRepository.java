package org.GodMode.TestManager.dao;

import java.util.List;

import org.GodMode.TestManager.entity.Subject;

public interface SubjectRepository {

    public void save(Subject subject);

    public void update(Subject subject);

    public void remove(Long id);

    public Subject findById(Long id);

    public List<Subject> getAllSubjects();
}

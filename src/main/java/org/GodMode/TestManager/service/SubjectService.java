package org.GodMode.TestManager.service;

import org.GodMode.TestManager.entity.Subject;

import java.util.List;



public interface SubjectService {

    public void save(Subject subject);

    public void update(Subject subject);

    public void remove(Long id);

    public Subject findById(Long id);

    public List<Subject> getAllSubjects();
}

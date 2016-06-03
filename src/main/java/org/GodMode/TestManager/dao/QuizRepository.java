package org.GodMode.TestManager.dao;

import java.util.List;

import org.GodMode.TestManager.entity.Quiz;
import org.GodMode.TestManager.entity.Subject;

public interface QuizRepository {

    public void save(Quiz quiz);

    public void update(Quiz quiz);

    public void remove(Long id);

    public Quiz findById(Long id);

    public List<Quiz> findQuizesBySubject(Subject subject);

    public List<Quiz> findAllQuizes();

}

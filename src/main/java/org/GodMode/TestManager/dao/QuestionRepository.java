package org.GodMode.TestManager.dao;

import java.util.List;

import org.GodMode.TestManager.entity.Question;

public interface QuestionRepository {

    public void save(Question question);

    public void update(Question question);

    public void remove(Long id);

    public Question findById(Long id);

    public List<Question> findAllQuestions();

}

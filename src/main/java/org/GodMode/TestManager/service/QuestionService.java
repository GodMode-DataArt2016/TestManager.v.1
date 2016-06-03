package org.GodMode.TestManager.service;

import org.GodMode.TestManager.entity.Question;

import java.util.List;


public interface QuestionService {

    public void save(Question question);

    public void update(Question question);

    public void remove(Long id);

    public Question findById(Long id);

    public List<Question> findAllQuestions();

}

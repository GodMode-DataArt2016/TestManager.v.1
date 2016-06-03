package org.GodMode.TestManager.service;

import org.GodMode.TestManager.entity.Quiz;
import org.GodMode.TestManager.entity.QuizResult;
import org.GodMode.TestManager.entity.User;

import java.util.List;



public interface QuizResultService {

    public void save(QuizResult quizResult);

    public QuizResult findById(Long id);

    public List<QuizResult> findByUser(User user);

    public List<QuizResult> findByQuiz(Quiz quiz);

    public void remove(Long id);
}

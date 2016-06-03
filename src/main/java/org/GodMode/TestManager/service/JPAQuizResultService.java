package org.GodMode.TestManager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.GodMode.TestManager.dao.QuizResultRepository;
import org.GodMode.TestManager.entity.Quiz;
import org.GodMode.TestManager.entity.QuizResult;
import org.GodMode.TestManager.entity.User;

@Service
public class JPAQuizResultService implements QuizResultService {

    @Autowired
    private QuizResultRepository quizResultRepository;

    @Transactional
    @Override
    public void save(QuizResult quizResult) {
        quizResultRepository.save(quizResult);
    }

    @Override
    public QuizResult findById(Long id) {
        return quizResultRepository.findById(id);
    }

    @Override
    public List<QuizResult> findByUser(User user) {
        return quizResultRepository.findByUser(user);
    }

    @Override
    public List<QuizResult> findByQuiz(Quiz quiz) {
        return quizResultRepository.findByQuiz(quiz);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        quizResultRepository.remove(id);
    }

}

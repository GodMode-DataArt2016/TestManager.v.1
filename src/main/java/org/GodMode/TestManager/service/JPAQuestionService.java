package org.GodMode.TestManager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.GodMode.TestManager.dao.QuestionRepository;
import org.GodMode.TestManager.entity.Question;


@Service
public class JPAQuestionService implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public void update(Question question) {
        questionRepository.update(question);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionRepository.findAllQuestions();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        questionRepository.remove(id);
    }

}

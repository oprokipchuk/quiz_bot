package com.telegram_bots.quiz_bot.bot.services.impl;

import com.telegram_bots.quiz_bot.bot.entity.Answer;
import com.telegram_bots.quiz_bot.bot.entity.Question;
import com.telegram_bots.quiz_bot.bot.repos.AnswerRepository;
import com.telegram_bots.quiz_bot.bot.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.getOne(id);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Long getAnswersCount() {
        return answerRepository.count();
    }

    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        return question.getAnswers();
    }

    @Override
    public List<Answer> getAnswerByText(String text) {
        return answerRepository.findAnswersByAnswerText(text);
    }
}

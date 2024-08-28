package pro.sky.course2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.course2.exceptions.NotEnoughQuestionsException;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.ExaminerService;
import pro.sky.course2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionsException();
        }

        Set<Question>set=new HashSet<>();
        while (set.size()<amount){set.add(questionService.getRandomQuestoin());}
        return set;

       /* Stream.generate(questionService::getRandomQuestoin).
                distinct().
                limit(amount).
                toList();*/
    }
}

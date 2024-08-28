package pro.sky.course2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.course2.exceptions.QuestionNotFound;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestoin() {
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}

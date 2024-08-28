package pro.sky.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.impl.JavaQuestionService;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    @DisplayName("Проверка добавления вопроса")
    void addTest() {
        JavaQuestionService.add("что говорит кошка?", "мяу");
        Assertions.assertEquals(javaQuestionService.getAll().size(), 1);
    }

    @Test
    @DisplayName("Проверка исключения когда вопрос существует")
    void addException() {
        Assertions.assertThrows(QuestionAlreadyExistsException.class,
        JavaQuestionService.add("что говорит кошка?", "мяу"));
    }

}

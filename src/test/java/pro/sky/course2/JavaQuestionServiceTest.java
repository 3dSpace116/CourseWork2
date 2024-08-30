package pro.sky.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.course2.exceptions.QuestionNotFound;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.impl.JavaQuestionService;

public class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    @DisplayName("Проверка добавления вопроса")
    void addTest() {
        javaQuestionService.add("что говорит кошка?", "мяу");
        Assertions.assertEquals(javaQuestionService.getAll().size(), 1);
    }

    @Test
    @DisplayName("Проверка исключения когда вопрос существует")
    void addExceptionTest() {
        javaQuestionService.add("что говорит кошка?", "мяу");
        Assertions.assertThrows(QuestionAlreadyExistsException.class, () ->
                javaQuestionService.add("что говорит кошка?", "мяу"));
    }

    @Test
    @DisplayName("Проверка удаления вопроса")
    void removeTest() {
        Question meow = javaQuestionService.add("что говорит кошка?", "мяу");
        javaQuestionService.remove(meow);
        Assertions.assertEquals(javaQuestionService.getAll().size(), 0);
    }

    @Test
    @DisplayName("Проверка исключения когда вопроса не существует")
    void removeExceptionTest() throws Exception {
        Question meow = null;
        Assertions.assertThrows(QuestionNotFound.class, () -> javaQuestionService.remove(meow));
    }

    @Test
    @DisplayName("Проверка запроса всех вопросов")
    void getAllTest() {
        javaQuestionService.add("что говорит кошка?", "мяу");
        javaQuestionService.add("что говорит собака?", "гав");
        javaQuestionService.add("что говорит попугай?", "мяу-гав");
        Assertions.assertEquals(javaQuestionService.getAll().size(), 3);

    }

    /*@Test по условиям задания тест не обязателен, Assertions не понимает ||, вернусь позже к решению
    @DisplayName("Проверка выдачи случайного вопроса")
    void getRandomQuestionTest() {
        Question first= javaQuestionService.add("что говорит кошка?", "мяу");
        Question second=javaQuestionService.add("что говорит собака?", "гав");
        Question third= javaQuestionService.add("что говорит попугай?", "мяу-гав");
        Assertions.assertEquals(javaQuestionService.getRandomQuestion(), second || first || third);
    }*/

}

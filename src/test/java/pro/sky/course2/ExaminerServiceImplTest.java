package pro.sky.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.exceptions.NotEnoughQuestionsException;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.impl.ExaminerServiceImpl;
import pro.sky.course2.service.impl.JavaQuestionService;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void init() {
        when(javaQuestionService.getAll()).thenReturn(List.of(
                new Question("что говорит кошка?", "мяу"),
                new Question("что говорит собака?", "гав"),
                new Question("что говорит попугай?", "мяу-гав")));
    }


    @Test
    @DisplayName("Проверка выброса исключения")
    void exceptionTest() throws Exception {
        Assertions.assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(4));
    }

    @Test
    @DisplayName("Тест выдачи вопросов")
    void examinerServiceTest() {
        String allQuestions = examinerService.getQuestions(3).toString();
        Assertions.assertTrue(allQuestions.contains("что говорит кошка?"));
        Assertions.assertTrue(allQuestions.contains("что говорит собака?"));
        Assertions.assertTrue(allQuestions.contains("что говорит попугай?"));
    }
}

package pro.sky.course2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.model.Question;
import pro.sky.course2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/random")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getRandomQuestion(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}

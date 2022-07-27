package com.project.backspring.controller;

import com.project.backspring.model.Course;
import com.project.backspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Indica que a classe tem um 'endpoint', ou seja, tem uma URL na qual ela pode ser acessada
@RestController
// Indica o endpoint que será exposto para o acesso dos métodos
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    // considera-se esse atributo como final, para que não haja alteração na instância
    private final CourseRepository courseRepository;

    //    public CourseController(CourseRepository courseRepository) {
    //        this.courseRepository = courseRepository;
    //    }
        //  isso Pode ser feito por meio do Lombok, com o @AllArgsConstructor

    // Seria o mesmo que escrever: @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public @ResponseBody List<Course> list() {
        // findAll faz um SELECT * da tabela, sem clausulas WHERE
        return courseRepository.findAll();
    }
}

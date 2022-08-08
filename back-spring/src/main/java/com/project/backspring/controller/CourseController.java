package com.project.backspring.controller;

import com.project.backspring.model.Course;
import com.project.backspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Método responsável por criar os cursos no BD
    // Seria o mesmo que escrever: @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
        public Course create(@RequestBody Course course) {
            return courseRepository.save(course);
        //  return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }
}

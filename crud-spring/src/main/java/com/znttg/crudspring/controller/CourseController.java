package com.znttg.crudspring.controller;

import com.znttg.crudspring.model.Course;
import com.znttg.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private CourseRepository courseRepository;

    @GetMapping
    private @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> finById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) // Utilizado quando não é preciso manusear o retorno
    // A notação de @RequestBody mapeia os atributos passados pelo front de acordo com a classe de cursos do back
    public Course create(@RequestBody Course course) {
        //System.out.println(course.getName());
        return courseRepository.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED)
        //.body(courseRepository.save(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    Course updated = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

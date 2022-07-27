package com.project.backspring.repository;

import com.project.backspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ao declara como uma interface, consegue-se extender as interfaces do próprio JPA (Spring Data)
// O JPA facilita o acesso ao banco de dados
@Repository
// <[Interface], [Tipo da chave primaria]>
public interface CourseRepository extends JpaRepository<Course, Long> {

}

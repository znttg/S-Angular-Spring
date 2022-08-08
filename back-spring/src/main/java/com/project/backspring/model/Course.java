package com.project.backspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
// pode usar @Table(name = "cursos"), caso a tabela tenha um nome diferente da entity
public class Course {

    @Id
    // Gera um valor incremental para o ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;
}

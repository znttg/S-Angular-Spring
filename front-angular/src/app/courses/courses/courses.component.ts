import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';

import { Course } from './../model/course';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  // Essa variável é um array do tipo Cursos, definido na interface ./../model/course.ts
  courses: Observable<Course[]>;

  // Array de string com o nome das propriedades da interface
  displayedColumns = ['name', 'category'];

  // Injeção de dependência
  // coursesService: CoursesService;

  // Injeção de dependência direto no construtor
  constructor(private coursesService: CoursesService) {
    // this.courses = [];

    // Instanciamento de classe
    // this.coursesService = new CoursesService();
    this.courses = this.coursesService.list();
  }

  // Roda no momento em que o componente é inicializado
  ngOnInit(): void {
    // this.courses = this.coursesService.list();
  }

}

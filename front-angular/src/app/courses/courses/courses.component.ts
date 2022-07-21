import { Component, OnInit } from '@angular/core';

import { Course } from './../model/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  // Essa variável é um array do tipo Cursos, definido na interface ./../model/course.ts
  courses: Course[] = [
    { _id: "1", name: 'Angular', category: 'front-end'},
    { _id: "1", name: 'Angular', category: 'front-end'},
    { _id: "1", name: 'Angular', category: 'front-end'},
  ];

  // Array de string com o nome das propriedades da interface
  displayedColumns = ['name', 'category'];

  constructor() {
    // this.courses = [];
  }

  ngOnInit(): void {
  }

}

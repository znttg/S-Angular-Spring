import { CourseFormComponent } from './course-form/course-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CoursesComponent } from './courses/courses.component';

const routes: Routes = [
  // Quando for apenas /courses/, ou seja, quando vier '' (nada) depois da url definida no router principal,
  // o CoursesComponente vai ser mostrado na tela
  { path: '', component: CoursesComponent },
  { path: 'new', component: CourseFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }

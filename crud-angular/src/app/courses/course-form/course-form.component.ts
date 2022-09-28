import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private service: CoursesService, private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    })
  }

  ngOnInit(): void {
  }

  onSubmit() {
    // O método não faz nada se não houver um subscribe, pois retorna um observable
    this.service.save(this.form.value)
      .subscribe(result => console.log(result), error => {this.onError()});
  }

  onCancel() {

  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso.', '', {duration: 5000});
  }
}

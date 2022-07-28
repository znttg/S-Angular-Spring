import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';

import { Course } from './../model/course';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  // Essa variável é um array do tipo Cursos, definido na interface ./../model/course.ts
  courses$: Observable<Course[]>;

  // Array de string com o nome das propriedades da interface
  displayedColumns = ['name', 'category', 'actions'];

  // Injeção de dependência
  // coursesService: CoursesService;

  // Injeção de dependência direto no construtor
  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    // Classe que controla o roteamento
    private router: Router,
    // Pegar o parâmetro pra pagina atual
    private route: ActivatedRoute

    ) {
    // this.courses = [];

    // Instanciamento de classe
    // this.coursesService = new CoursesService();
    this.courses$ = this.coursesService.list().pipe(
      catchError(error => {
        this.onError('Erro ao carregar cursos.');
        return of([]);
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  // Roda no momento em que o componente é inicializado
  ngOnInit(): void {
    // this.courses = this.coursesService.list();
  }

  // Ao clicar no botão, chama esse método, conforme determinado no HTML
  onAdd() {
    // Pega a rota atual e adiciona /new, ou seja, fica "cursos/new"
    this.router.navigate(['new'], {relativeTo: this.route});
  }


}

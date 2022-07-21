import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Course } from '../model/course';

/*
  A classe de serviço, que sim, é apenas uma classe, é responsável por tratar os dados
  que chegam do backend

  O que determina que essa classe será um serviço, é a anotação @Injectable
 */

@Injectable({
  // A instância dessa classe ficará disponível na raíz do projeto, ou seja, de modo global
  providedIn: 'root'
})

// A utilização dessa classe no componente é feita por meio da injeção de dependência
export class CoursesService {

  // Para fazer a conexão com o backend, utiliza-se o HttpClient do Angular, que é fornecido automaticamente
  // quando a declaração é feita aqui (injeção de dependência)
  constructor(private httpClient: HttpClient) { }

  list(): Course[] {
    return [
      { _id: "1", name: 'Angular', category: 'front-end'},
    ]
  }
}

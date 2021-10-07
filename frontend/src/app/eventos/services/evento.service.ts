import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Select } from '../../models/select.model';
import { Evento } from '../models/evento.model';
import { EventoListagem } from '../models/eventoListagem.model';

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  baseUrl: string = environment.apiUrl + '/evento';

  constructor(private httClient: HttpClient) { }

  // options = { params: new HttpParams()};

  // buildFilter(): any{
  //   var teste = new HttpParams();
  //   if(params['nome']){
  //     return { params: new HttpParams().append('nome', 'Evento')};
  //   }
  //   if(params['data']){
  //     return { params: new HttpParams().append('nome', 'Evento')};
  //   }
  // }

  filter(params?: { [key:string]: string }): Observable<EventoListagem[]>{
    const url = `${this.baseUrl}/filtro`;
    var options = { params: new HttpParams() };
    if(params && params['nome']){
      options.params = options.params.append('nome', params['nome']);
    }
    if(params && params['data']){
      options.params = options.params.append('data', params['data'])
    }
    if(params && params['motivo']){
      options.params = options.params.append('motivo', params['motivo'])
    }
    if(params && params['situacao']){
      options.params = options.params.append('situacao', params['situacao'])
    }
    if(params && params['usuario']){
      options.params = options.params.append('usuario', params['usuario'])
    }
    return this.httClient.get<EventoListagem[]>(url, options);
  }

  mostrarPorId(id: number): Observable<Evento>{
    const url = `${this.baseUrl}/${id}`
    return this.httClient.get<Evento>(url);
  }

  criarEvento(evento: Evento): Observable<Evento>{
    return this.httClient.post<Evento>(this.baseUrl, evento);
  }

}

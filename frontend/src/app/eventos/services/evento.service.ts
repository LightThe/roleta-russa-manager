import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Evento } from '../models/evento.model';
import { EventoListagem } from '../models/eventoListagem.model';

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  baseUrl: string = environment.apiUrl + '/evento';

  constructor(private httClient: HttpClient) { }

  filter(): Observable<EventoListagem[]>{
    const url = `${this.baseUrl}/filtro`;
    return this.httClient.get<EventoListagem[]>(url);
  }

  mostrarPorId(id: number): Observable<Evento>{
    const url = `${this.baseUrl}/${id}`
    return this.httClient.get<Evento>(url);
  }

  criarEvento(evento: Evento): Observable<Evento>{
    return this.httClient.post<Evento>(this.baseUrl, evento);
  }

}

import { Component, OnInit } from '@angular/core';
import { EventoListagem } from '../../models/eventoListagem.model';
import { EventoService } from '../../services/evento.service';

@Component({
  selector: 'app-evento-read',
  templateUrl: './evento-read.component.html',
  styleUrls: ['./evento-read.component.css']
})
export class EventoReadComponent implements OnInit {

  eventos: EventoListagem[] = [];
  headers: string[] = [
    'Nome',
    'Data'
  ];
  listaEventoSelecionado: EventoListagem[];


  constructor(private eventoService: EventoService) { }

  ngOnInit(): void {
    this.eventoService.filter().subscribe(element => this.eventos = element);
  }

}

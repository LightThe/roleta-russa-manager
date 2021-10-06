import { Component, OnInit } from '@angular/core';
import { Select } from 'src/app/models/select.model';
import { Evento } from '../../models/evento.model';
import { EventoListagem } from '../../models/eventoListagem.model';
import { EventoService } from '../../services/evento.service';

@Component({
  selector: 'app-evento-read',
  templateUrl: './evento-read.component.html',
  styleUrls: ['./evento-read.component.scss']
})
export class EventoReadComponent implements OnInit {

  eventos: EventoListagem[] = [];
  eventosFiltrado: EventoListagem[] = [];
  value: Date;
  eventoCompleto: Evento;
  listaEventoSelecionado: EventoListagem[];
  mostrarEvento: boolean = false;
  eventonovo: EventoListagem;
  
  constructor(private eventoService: EventoService) { }

  ngOnInit(): void {
    this.eventoService.filter().subscribe(element => this.eventos = element);
  }

  mostrar(id: number): void{
    this.eventoService.mostrarPorId(id).subscribe(element => {
      this.eventoCompleto = element;
      this.mostrarEvento = true;
    });
  }

  filtrar(nome: string): void{
    // console.log("filtrou");
    this.eventoService.filter().subscribe(element => 
      {
        this.eventos = element;
        // console.log(element);
      });
  }

}

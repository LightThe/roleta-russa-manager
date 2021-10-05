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
  eventoCompleto: Evento;
  headers: string[] = [
    'Nome',
    'Data'
  ];
  listaEventoSelecionado: EventoListagem[];
  mostrarEvento: boolean = false;
  
  //TODO: remover esses caras
  eventoAtual: EventoListagem = {
    id: 1,
    nome: 'DELETEME: Evento local de teste!',
    dataEvento: new Date(2021, 11, 10)
  };
  


  constructor(private eventoService: EventoService) { }

  ngOnInit(): void {
    this.eventoService.filter().subscribe(element => this.eventos = element);
    //this.eventos.push(this.eventoAtual);
    //this.eventos.push(this.eventoAtual);
  }

  mostrar(id: number): void{
    console.log(id);
    this.eventoService.mostrarPorId(id).subscribe(element => this.eventoCompleto = element);
    // this.eventoCompleto = {
    //   id: 1,
    //   nome: 'Nome do evento',
    //   dataEvento: new Date(2021, 11, 10),
    //   justificativa: null,
    //   valor: '80',
    //   motivo: {
    //     value: 1,
    //     label: 'A gente quer beber'
    //   },
    //   situacao: {
    //     value: 1,
    //     label: 'Agendado'
    //   },
    //   usuarios: [
    //     {
    //       value: 1,
    //       label: 'Márcia'
    //     }
    //   ]
    // }
    this.mostrarEvento = true;
  }
}

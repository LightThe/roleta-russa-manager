import { Component, OnInit } from '@angular/core';
import { Evento } from '../../models/evento.model';
import { EventoListagem } from '../../models/eventoListagem.model';
import { EventoService } from '../../services/evento.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

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

  buscaForm: FormGroup;
  formBuilder: FormBuilder = new FormBuilder();

  br: any;

  ngOnInit(): void {
    this.eventoService.filter({ 'situacao': 'Em Espera' }).subscribe(element => this.eventos = element);
    this.criarForm();
    this.localizacaoCalendario();
  }

  localizacaoCalendario(): void {
    this.br = {
      firstDayOfWeek: 0,
      dayNames: ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
      dayNamesShort: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
      dayNamesMin: ["D","S","T","Q","Q","S","S"],
      monthNames: [ "Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro" ],
      monthNamesShort: [ "Jan", "Fev", "Mar", "Abr", "Mai", "Jun","Jul", "Ago", "Set", "Out", "Nov", "Dez" ],
      today: 'Hoje',
      clear: 'Limpar',
      dateFormat: 'dd/mm/yy',
      weekHeader: 'Sm'
    };
  }

  criarForm(): void{
    this.buscaForm = this.formBuilder.group({
      nome: [''],
      data: [''],
      motivo: [''],
      situacao: [''],
      usuario: ['']
    })
  }

  mostrar(id: number): void{
    this.eventoService.mostrarPorId(id).subscribe(element => {
      this.eventoCompleto = element;
      this.mostrarEvento = true;
      console.log(this.eventoCompleto.usuario);
    });
  }

  filtrar(nome: string): void{
    var dadosForm = this.buscaForm.getRawValue();
    if(dadosForm.data != "" && dadosForm.data != null) {
      dadosForm.data = this.buscaForm.get('data').value.toJSON().split('T')[0];
    }
    this.eventoService.filter(dadosForm).subscribe(element => this.eventos = element);
  }

  trocar(id: number): void{
    // 
    this.eventoService.trocarEventos(id, null);
  }
  adiar(id: number): void{
    this.eventoService.adiarEvento(id);
  }
  cancelar(id: number): void{
    this.eventoService.cancelarEvento(id);
  }

}

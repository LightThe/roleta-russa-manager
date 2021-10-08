import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Select } from 'src/app/models/select.model';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';
import { MotivoService } from 'src/app/service/motivo.service';
import { UsuarioService } from 'src/app/service/usuario.service';
import { Evento } from '../../models/evento.model';
import { EventoService } from '../../services/evento.service';

@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.scss']
})
export class EventoCreateComponent implements OnInit {

  constructor(private usuarioSvc: UsuarioService, private motivoSvc: MotivoService, private eventoSvc: EventoService) { }

  usuariosAtivos: Select[] = [];
  usuariosEvento: Select[] = [];
  motivos: Select[];
  minDateValue: Date;
  form: FormGroup;
  formBuilder: FormBuilder = new FormBuilder;
  dadosEvento: Evento;

  ngOnInit(): void {
    this.criarFormulario();
    this.minDateValue = new Date();
    this.motivoSvc.buscarTodos().subscribe(element => this.motivos = element);
    this.usuarioSvc.buscarUsuariosAtivos().subscribe(element => {
      element.forEach(usuario => { this.usuariosAtivos.push({ value: usuario.id, label: usuario.nome }) });
    });
  }

  criarFormulario(): void {
    this.form = this.formBuilder.group({
    id: [''],
    nome: [''],
    dataEvento: [''],
    justificativa: [''],
    valor: [''],
    motivo: [''],
    situacao: [''],
    usuario: [''],
    })
  }

  criarEvento(): void{
    this.dadosEvento = this.form.getRawValue();
    this.dadosEvento.motivo = { value: this.form.get('motivo').value}
    this.dadosEvento.situacao = { value: 1 }
    this.dadosEvento.usuario = this.usuariosEvento;
    this.eventoSvc.criarEvento(this.dadosEvento).subscribe(()=> console.log("teste"));
    console.log(this.dadosEvento);
  }

}

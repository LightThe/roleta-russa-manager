import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';
import { Evento } from '../../models/evento.model';

@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.css']
})
export class EventoCreateComponent implements OnInit {

  constructor() { }

  usuariosAtivos: UsuarioListagem[] = [];
  usuariosEvento: UsuarioListagem[] = [];

  usuarioTeste: UsuarioModel = {
    id: 1,
    nome: "John Doe",
    cpf: "52698701005",
    dataNascimento: new Date(1994, 10, 10),
    email: "john.doe@mail.com",
    telefone: "111111111",
    status: true,
    cargo:{
      value:1
    }
  }
  form: FormGroup;
  formBuilder: FormBuilder = new FormBuilder;
  dadosEvento: Evento;

  ngOnInit(): void {
    this.criarFormulario();
    //Chamada ao usuario Service
    this.usuariosAtivos.push(this.usuarioTeste);
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
    usuarios: [''],
    })
  }

  criarEvento(): void{
    this.dadosEvento = this.form.getRawValue();
    console.log(this.form.getRawValue());
  }

}

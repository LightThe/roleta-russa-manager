import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';

@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.css']
})
export class EventoCreateComponent implements OnInit {

  constructor() { }

  usuariosAtivos: UsuarioListagem[];
  usuariosEvento: UsuarioListagem[];

  form: FormGroup;
  formBuilder: FormBuilder = new FormBuilder;

  ngOnInit(): void {
    this.criarFormulario();
    //Chamada ao usuario Service
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
    console.log(this.form.getRawValue());
  }

}

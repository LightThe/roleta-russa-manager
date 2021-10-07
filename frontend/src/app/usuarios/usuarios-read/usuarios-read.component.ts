import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessagesModule, SelectItem } from 'primeng';
import { Select } from 'src/app/models/select.model';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';
import { CargoService } from 'src/app/service/cargo.service';
import { UsuarioService } from 'src/app/service/usuario.service';
import * as moment from 'moment';
import { DataPipe } from 'src/app/pipe/data.pipe';
import { UsuarioStatusPipe } from 'src/app/pipe/status.pipe';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-usuarios-read',
  templateUrl: './usuarios-read.component.html',
  styleUrls: ['./usuarios-read.component.css']
})
export class UsuariosReadComponent implements OnInit {

  usuarios: UsuarioListagem[] = [];
  headers: string[] = [
    'Nome',
    'Cargo'
  ];
  usuarioSelecionado: UsuarioListagem;
  usuarioCompleto: UsuarioModel;

  form: FormGroup;
  formBuilder: FormBuilder = new FormBuilder;
  cargos: SelectItem[] = [];
  ativadorDialog: boolean;
  habilitarSalvar: boolean;

  dataCalendario: string;




  constructor(private usuarioService: UsuarioService, private cargoService: CargoService, private router: Router,
     private statusPipe: UsuarioStatusPipe) { }

  ngOnInit() {
    this.inicializarListagem();
  }

  mostrar(): void {
    this.usuarioService.mostrarPoriD(this.usuarioSelecionado.id).subscribe(element => {
      this.gerarListaDeCargos();
      this.usuarioCompleto = element;
      this.exibirDialog();
      this.preencherFormulario();


    });

  }


  inicializarListagem(): void {
    this.usuarioService. buscarUsuariosAtivos().subscribe(element => this.usuarios = element);
    this.criarFormulario();
  }

  gerarListaDeCargos(): void {
    this.cargoService.buscarTodos().subscribe((element: SelectItem[]) => this.cargos = [{ label: 'Selecione o cargo', value: null } as SelectItem].concat(element))
  }


  exibirDialog(): void {
    this.ativadorDialog = true;
    this.habilitarSalvar = true;
  }



  criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: [''],
      nome: [''],
      cpf: [''],
      dataNascimento: [''],
      email: [''],
      telefone: [''],
      status: [''],
      cargo: ['']
    });
  }

  preencherFormulario(): void {
    this.form.get('id').setValue(this.usuarioCompleto.id);
    this.form.get('nome').setValue(this.usuarioCompleto.nome);
    this.form.get('cpf').setValue(this.usuarioCompleto.cpf);
    this.dataCalendario = this.usuarioCompleto.dataNascimento.toString();
    this.form.get('dataNascimento').setValue(this.converterData(this.usuarioCompleto.dataNascimento, 1));
    this.form.get('email').setValue(this.usuarioCompleto.email);
    this.form.get('telefone').setValue(this.usuarioCompleto.telefone);
    this.form.get('status').setValue(this.statusPipe.transform(this.usuarioCompleto.status));
    this.form.get('cargo').setValue(this.usuarioCompleto.cargo.value);

    this.bloquearCampos();
  }

  bloquearCampos(): void {
    this.form.disable();
  }

  habilitarEdicao(): void {
    this.form.enable();
    this.form.get('cpf').disable()
    this.form.get('status').disable();
    this.habilitarSalvar = false;

  }

  editarUsuario(): void {

    console.log(this.form)
    let usuario: UsuarioModel = this.form.getRawValue();
    usuario.status = this.usuarioCompleto.status;
    usuario.cargo = { value: this.form.get('cargo').value };

    // let data: moment.Moment = moment.utc(this.form.value.dataNascimento).local();
    // usuario.dataNascimento = data.format('YYYY-MM-DD');

    this.usuarioService.editarUsuario(usuario).subscribe(() => this.inicializarListagem());
    this.ativadorDialog = false;


  }


  inativarUsuario(): void {
    this.usuarioService.inativarUsuario(this.usuarioSelecionado.id).subscribe(() => this.inicializarListagem());

  }


 converterData(dataConv: Date, type: number): Date{
    if(type = 1){
      let data: moment.Moment = moment.utc(dataConv).local();
      return new Date(data.format('DD/MM/YYYY'));
      
    }

    if(type = 2){
      let data: moment.Moment = moment.utc(dataConv).local();
      return new Date(data.format('YYYY-MM-DD'));
    }
 }





}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessagesModule, SelectItem } from 'primeng';
import { Select } from 'src/app/models/select.model';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';
import { CargoService } from 'src/app/service/cargo.service';
import { UsuarioService } from 'src/app/service/usuario.service';


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





  constructor(private usuarioService: UsuarioService, private cargoService: CargoService) { }

  ngOnInit() {
    this.usuarioService.filter().subscribe(element => this.usuarios = element);
    this.criarFormulario();
  }

  mostrar(): void {
    this.usuarioService.mostrarPoriD(this.usuarioSelecionado.id).subscribe(element => {
      this.usuarioCompleto = element;
      this.exibirDialog();
      this.preencherFormulario();


    });

  }

  ativadorDialog: boolean;

  exibirDialog(): void {
    this.ativadorDialog = true;
  }



  criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: [''],
      nome: [''],
      cpf: [''],
      data: [''],
      email: [''],
      telefone: [''],
      status: [''],
      cargo: ['', Validators.required],

    })

  }

  preencherFormulario(): void {
    this.form.get('id').setValue(this.usuarioCompleto.id);
    this.form.get('nome').setValue(this.usuarioCompleto.nome);
    this.form.get('cpf').setValue(this.usuarioCompleto.cpf);
    this.form.get('data').setValue(this.usuarioCompleto.dataNascimento);
    this.form.get('email').setValue(this.usuarioCompleto.email);
    this.form.get('telefone').setValue(this.usuarioCompleto.telefone);
    this.form.get('status').setValue(this.usuarioCompleto.status);
    this.form.get('cargo').setValue(this.usuarioCompleto.cargo.value);

    this.gerarListaDeCargos();
    this.bloquearCampos();
  }

  bloquearCampos(): void {
    this.form.disable();

  }

  editarUsuario(): void {
    this.form.enable();
    this.habilitarSalvar = true;

  }



  inativarUsuario(): void {
    this.usuarioService.inativarUsuario(this.usuarioSelecionado.id).subscribe(() => {

    });

  }



  gerarListaDeCargos(): void {
    // this.cargoService.buscarTodos().subscribe((element: SelectItem[]) => this.cargos = [{label: 'Selecione o cargo', value: null} as SelectItem].concat(element))
    this.cargoService.buscarTodos().subscribe(element => this.cargos = element)
    console.log(this.cargos)
  }


 habilitarSalvar: boolean;


}

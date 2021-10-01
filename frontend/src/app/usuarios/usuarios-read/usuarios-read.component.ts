import { Component, OnInit } from '@angular/core';
import { element } from 'protractor';
import { UsuarioModel } from 'src/app/models/usuario.model';
import { UsuarioListagem } from 'src/app/models/usuarioListagem.model';
import { UsuarioService } from 'src/app/service/usuario.service';
import { Usuario } from 'src/app/usuario/usuario';

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



  constructor(private usarioService: UsuarioService) { }

  ngOnInit() {
      this.usarioService.filter().subscribe(element => this.usuarios = element);
  }

  mostrar(): void{
    this.usarioService.mostrarPoriD(this.usuarioSelecionado.id).subscribe(element => {
      this.usuarioCompleto = element;
      
    });
  
  }


}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UsuariosReadComponent } from './usuarios-read/usuarios-read.component';



@NgModule({
  declarations: [UsuariosReadComponent],
  imports: [
    CommonModule,
    UsuariosRoutingModule
  ]
})
export class UsuariosModule { }

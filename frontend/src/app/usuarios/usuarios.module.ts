import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UsuariosReadComponent } from './usuarios-read/usuarios-read.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [UsuariosReadComponent],
  imports: [
    CommonModule,
    UsuariosRoutingModule,
    SharedModule
  ]
})
export class UsuariosModule { }

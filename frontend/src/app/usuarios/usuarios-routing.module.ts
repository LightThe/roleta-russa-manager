import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioisCreateComponent } from './usuarios-create/usuariois-create.component';
import { UsuariosReadComponent } from './usuarios-read/usuarios-read.component';



const routes: Routes = [
  {path: '', component: UsuariosReadComponent},
  {path: 'criar', component: UsuarioisCreateComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class UsuariosRoutingModule{

}
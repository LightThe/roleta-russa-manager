import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosReadComponent } from './usuarios-read/usuarios-read.component';



const routes: Routes = [
  // {path:'', redirectTo:'listar', pathMatch: 'full' },
  {path: '', component: UsuariosReadComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class UsuariosRoutingModule{

}
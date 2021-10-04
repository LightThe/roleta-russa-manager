import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventoReadComponent } from './components/evento-read/evento-read.component';


const routes: Routes = [
  { path: '', redirectTo: 'listar' },
  { path: 'listar', component: EventoReadComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventosRoutingModule { }

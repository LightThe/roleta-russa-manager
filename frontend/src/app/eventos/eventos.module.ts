import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventosRoutingModule } from './eventos-routing.module';
import { EventoReadComponent } from './components/evento-read/evento-read.component';


@NgModule({
  declarations: [EventoReadComponent],
  imports: [
    CommonModule,
    EventosRoutingModule
  ]
})
export class EventosModule { }

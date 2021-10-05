import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventosRoutingModule } from './eventos-routing.module';
import { EventoReadComponent } from './components/evento-read/evento-read.component';
import { PRIMENG_IMPORTS } from '../shared/primeng-imports';


@NgModule({
  declarations: [EventoReadComponent],
  imports: [
    CommonModule,
    EventosRoutingModule,
    PRIMENG_IMPORTS
  ]
})
export class EventosModule { }

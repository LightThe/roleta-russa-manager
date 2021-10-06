import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventosRoutingModule } from './eventos-routing.module';
import { EventoReadComponent } from './components/evento-read/evento-read.component';
import { PRIMENG_IMPORTS } from '../shared/primeng-imports';
import { EventoCreateComponent } from './components/evento-create/evento-create.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [EventoReadComponent, EventoCreateComponent],
  imports: [
    CommonModule,
    EventosRoutingModule,
    SharedModule
  ]
})
export class EventosModule { }

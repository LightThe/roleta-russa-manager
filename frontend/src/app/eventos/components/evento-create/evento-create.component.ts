import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.css']
})
export class EventoCreateComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  formEvento = new FormGroup({
    nome: new FormControl('')
  });

}

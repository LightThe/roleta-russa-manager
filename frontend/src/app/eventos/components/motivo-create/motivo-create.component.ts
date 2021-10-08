import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MotivoService } from 'src/app/service/motivo.service';

@Component({
  selector: 'app-motivo-create',
  templateUrl: './motivo-create.component.html',
  styleUrls: ['./motivo-create.component.css']
})
export class MotivoCreateComponent implements OnInit {

  constructor(private motivoSvc: MotivoService) { }

  motivoForm: FormGroup;
  formBuilder: FormBuilder = new FormBuilder();

  ngOnInit(): void {
    this.motivoForm = this.formBuilder.group({
      id: [''],
      motivo: [''],
      descricao: ['']
    })
  }

  criaMotivo():void {
    this.motivoSvc.criarMotivo(this.motivoForm.getRawValue()).subscribe();
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SelectItem } from 'primeng';
import { CargoService } from 'src/app/service/cargo.service';

@Component({
  selector: 'app-usuariois-create',
  templateUrl: './usuariois-create.component.html',
  styleUrls: ['./usuariois-create.component.css']
})
export class UsuarioisCreateComponent implements OnInit {

  
  form: FormGroup;
  formBuilder: FormBuilder = new FormBuilder;
  cargos: SelectItem[] = [];

  constructor(private cargoService: CargoService ) {}

  ngOnInit(): void {
    this.criarFormulario();
    this.gerarListaDeCargos();
  }

  criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: [''],
      nome: [''],
      cpf: [''],
      dataNascimento: [''],
      email: [''],
      telefone: [''],
      cargo: ['']
    });
  }


  gerarListaDeCargos(): void {
    this.cargoService.buscarTodos().subscribe((element: SelectItem[]) => this.cargos = [{ label: 'Selecione o cargo', value: null } as SelectItem].concat(element))
  }  


}

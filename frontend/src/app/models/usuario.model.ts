import { Select } from "./select.model";

export class UsuarioModel{
    public id : number;
    public nome : string;
    public cpf : string;
    public dataNascimento : string;
    public email : string;
    public telefone : string;
    public status : boolean;
    public cargo : Select;
}
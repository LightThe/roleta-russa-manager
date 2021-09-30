import { Select } from "./select.model";

export class Evento{
    public id : number
    public nome : string;
    public dataEvento : Date;
    public justificativa : string;
    public valor : string;
    public motivo : Select;
    public situacao : Select;
    public usuarios : Select[];
}
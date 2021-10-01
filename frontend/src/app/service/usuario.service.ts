import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { UsuarioModel } from "../models/usuario.model";
import { UsuarioListagem } from "../models/usuarioListagem.model";
import { Usuario } from "../usuario/usuario";






@Injectable({
    providedIn:'root'
})

export class UsuarioService {
    baseUrl: string = environment.apiUrl + '/usuario';


    constructor(private httClient: HttpClient) { }


    filter(): Observable<UsuarioListagem[]> {
        const url = `${this.baseUrl}/filtro`
        return this.httClient.get<UsuarioListagem[]>(url);

    }

    mostrarPoriD(id: number): Observable<UsuarioModel>{
        const url = `${this.baseUrl}/${id}`;
        return this.httClient.get<UsuarioModel>(url);
    }


}

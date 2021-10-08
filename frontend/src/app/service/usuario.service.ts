import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ObserveOnSubscriber } from "rxjs/internal/operators/observeOn";
import { environment } from "src/environments/environment";
import { Select } from "../models/select.model";
import { UsuarioModel } from "../models/usuario.model";
import { UsuarioListagem } from "../models/usuarioListagem.model";
import { Usuario } from "../usuario/usuario";






@Injectable({
    providedIn:'root'
})

export class UsuarioService {
    baseUrl: string = environment.apiUrl + '/usuario';


    constructor(private httClient: HttpClient) { }


    buscarTodosDropDow(): Observable<Select[]>{
        const url = `${this.baseUrl}`
        return this.httClient.get<Select[]>(url);
    }

    buscarUsuariosAtivos(): Observable<UsuarioListagem[]> {
        const url = `${this.baseUrl}/filtro?status=true`
        return this.httClient.get<UsuarioListagem[]>(url);

    }

    mostrarPoriD(id: number): Observable<UsuarioModel>{
        const url = `${this.baseUrl}/${id}`;
        return this.httClient.get<UsuarioModel>(url);
    }

    salvarUsuario(usuario: UsuarioModel): Observable<UsuarioModel>{
        const url = `${this.baseUrl}`;
        return this.httClient.post<UsuarioModel>(url, usuario);
    }

    editarUsuario(usuario: UsuarioModel): Observable<UsuarioModel>{
        const url = `${this.baseUrl}`;
        return this.httClient.put<UsuarioModel>(url, usuario)
    }

    ativarUsuario(id: number): Observable<UsuarioModel>{
        const url = `${this.baseUrl}/${id}`;
        return this.httClient.put<UsuarioModel>(url, null);
    }

    inativarUsuario(id: number): Observable<any>{
        const url = `${this.baseUrl}/${id}`;
        return this.httClient.delete<any>(url);
    }



}

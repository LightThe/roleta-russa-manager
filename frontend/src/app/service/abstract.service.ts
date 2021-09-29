import { HttpClient } from "@angular/common/http";

export class AbstractService{

    protected readonly url: string;
    protected readonly httpClient: HttpClient;

    protected constructor (http: HttpClient, resource: string){
        this.httpClient = http;
        
    }

}
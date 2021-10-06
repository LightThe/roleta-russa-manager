import { NgModule } from '@angular/core';
import { UsuarioStatusPipe } from '../pipe/status.pipe';
import { PRIMENG_IMPORTS } from './primeng-imports';

@NgModule({
    declarations:[
        UsuarioStatusPipe
    ],
    imports: [
        PRIMENG_IMPORTS,
        
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
        UsuarioStatusPipe
    ]
})
export class SharedModule { }

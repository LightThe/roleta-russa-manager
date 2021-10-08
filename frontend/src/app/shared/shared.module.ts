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
    providers: [
        UsuarioStatusPipe
    ],
    exports: [
        PRIMENG_IMPORTS,
      
    ]
})
export class SharedModule { }

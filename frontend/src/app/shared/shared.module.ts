import { NgModule } from '@angular/core';
import { DataPipe } from '../pipe/data.pipe';
import { UsuarioStatusPipe } from '../pipe/status.pipe';
import { PRIMENG_IMPORTS } from './primeng-imports';

@NgModule({
    declarations:[
        UsuarioStatusPipe,
        DataPipe
    
    ],
    imports: [
        PRIMENG_IMPORTS,
        
    ],
    providers: [
        DataPipe,
        UsuarioStatusPipe
    ],
    exports: [
        PRIMENG_IMPORTS,
        UsuarioStatusPipe,
        DataPipe
      
    ]
})
export class SharedModule { }

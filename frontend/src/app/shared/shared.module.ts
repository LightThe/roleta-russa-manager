import { NgModule } from '@angular/core';
import { DataPipe } from '../pipe/data.pipe';
import { UsuarioStatusPipe } from '../pipe/status.pipe';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
    declarations:[
        UsuarioStatusPipe,
        DataPipe
    
    ],
    imports: [
        PRIMENG_IMPORTS,
        ReactiveFormsModule
        
    ],
    providers: [
        DataPipe,
        UsuarioStatusPipe
    ],
    exports: [
        PRIMENG_IMPORTS,
        ReactiveFormsModule,
        UsuarioStatusPipe,
        DataPipe
      
    ]
})
export class SharedModule { }

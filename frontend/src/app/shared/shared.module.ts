import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
        ReactiveFormsModule
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
        ReactiveFormsModule
    ]
})
export class SharedModule { }

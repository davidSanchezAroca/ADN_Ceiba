import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CrearOrdenRoutingModule } from './crear-orden-routing.module';
import { CrearOrdenComponent } from './crear-orden.component';
import {
  ReactiveFormsModule,
  FormsModule
} from "@angular/forms";

@NgModule({
  declarations: [
    CrearOrdenComponent
  ],
  imports: [
    CommonModule,
    CrearOrdenRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class CrearOrdenModule { }

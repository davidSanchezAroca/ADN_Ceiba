import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListarOrdenRoutingModule } from './listar-orden-routing.module';
import { ListarOrdenComponent } from './listar-orden.component';
import { ReactiveFormsModule, FormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    ListarOrdenComponent
  ],
  imports: [
    CommonModule,
    ListarOrdenRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]

})
export class ListarOrdenModule { }

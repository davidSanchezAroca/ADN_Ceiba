import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarClienteRoutingModule } from './listar-cliente-routing.module';
import { ListarClienteComponent } from './listar-cliente.component';

@NgModule({
  declarations: [
    ListarClienteComponent
  ],
  imports: [
    CommonModule,
    ListarClienteRoutingModule
  ]
})
export class ListarClienteModule { }

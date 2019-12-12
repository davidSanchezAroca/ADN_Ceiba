import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule} from '@angular/common';
import { CrearClienteRoutingModule } from './crear-cliente-routing.module';
import { CrearClienteComponent } from './crear-cliente.component';
import { ReactiveFormsModule, FormsModule } from "@angular/forms";



@NgModule({
  declarations: [
    CrearClienteComponent
  ],
  imports: [
    CommonModule,
    CrearClienteRoutingModule,
    FormsModule,
    ReactiveFormsModule
    
  ]
})
export class CrearClienteModule { }

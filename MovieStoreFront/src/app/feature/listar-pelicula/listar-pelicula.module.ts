import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarPeliculaRoutingModule } from './listar-pelicula-routing.module';
import { ListarPeliculaComponent } from './listar-pelicula.component';
import { ReactiveFormsModule, FormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    ListarPeliculaComponent
  ],
  imports: [
    CommonModule,
    ListarPeliculaRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class ListarPeliculaModule { }

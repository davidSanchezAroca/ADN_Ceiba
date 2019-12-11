import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearPeliculaComponent } from './crear-pelicula.component';

const routes: Routes = [{
  path: '',
  component: CrearPeliculaComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CrearPeliculaRoutingModule { }

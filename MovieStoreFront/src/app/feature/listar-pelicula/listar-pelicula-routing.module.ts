import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarPeliculaComponent } from './listar-pelicula.component';

const routes: Routes = [{
  path: '',
  component: ListarPeliculaComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarPeliculaRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarOrdenComponent } from './feature/listar-orden/listar-orden.component';
import { MoviestoreComponent } from './feature/moviestore/moviestore.component';
import { CrearPeliculaComponent } from './feature/crear-pelicula/crear-pelicula.component';
import { CrearOrdenComponent } from './feature/crear-orden/crear-orden.component';
import { ListarPeliculaComponent } from './feature/listar-pelicula/listar-pelicula.component';
import { ListarClienteComponent } from './feature/listar-cliente/listar-cliente.component';




const routes: Routes = [
  { path: "", component: MoviestoreComponent },
  {
    path: "",
    children: [
      { path: "movie-store", component: MoviestoreComponent },
      { path: "listar-orden-form", component: ListarOrdenComponent },
      { path: "listar-pelicula-form", component: ListarPeliculaComponent },
      { path: "pelicula-form", component: CrearPeliculaComponent },
      { path: "orden-form", component: CrearOrdenComponent },
      {
        path: 'cliente-form',
        loadChildren: () => import('./feature/crear-cliente/crear-cliente.module').then(m => m.CrearClienteModule)
      },
      { path: "listar-cliente-form", component: ListarClienteComponent },
      { path: '**', redirectTo: 'cliente-form' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

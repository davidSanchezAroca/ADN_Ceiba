import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviestoreComponent } from './feature/moviestore/moviestore.component';




const routes: Routes = [
  { path: "", component: MoviestoreComponent },
  {
    path: "",
    children: [
      { path: "movie-store", 
        component:MoviestoreComponent
      },
      {
        path: "listar-orden-form",
        loadChildren: () => import('./feature/listar-orden/listar-orden.module').then(m => m.ListarOrdenModule)
      },
      {
        path: "listar-pelicula-form",
        loadChildren: () => import('./feature/listar-pelicula/listar-pelicula.module').then(m => m.ListarPeliculaModule)
      },
      {
        path: "pelicula-form",
        loadChildren: () => import('./feature/crear-pelicula/crear-pelicula.module').then(m => m.CrearPeliculaModule)
      },
      {
        path: "orden-form",
        loadChildren: () => import('./feature/crear-orden/crear-orden.module').then(m => m.CrearOrdenModule)
      },
      {
        path: 'cliente-form',
        loadChildren: () => import('./feature/crear-cliente/crear-cliente.module').then(m => m.CrearClienteModule)
      },
      {
        path: "listar-cliente-form",
        loadChildren: () => import('./feature/listar-cliente/listar-cliente.module').then(m => m.ListarClienteModule)
      },
      { path: '**', redirectTo: 'cliente-form' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

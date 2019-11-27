import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UrgenciasComponent } from './feature/urgencias/urgencias.component';
import { MostrarFacturaComponent } from './feature/mostrar-factura/mostrar-factura.component';
import { ListarOrdenComponent } from './feature/listar-orden/listar-orden.component';
import { MoviestoreComponent } from './feature/moviestore/moviestore.component';
import { CrearClienteComponent } from './feature/crear-cliente/crear-cliente.component';
import { CrearPeliculaComponent } from './feature/crear-pelicula/crear-pelicula.component';
import { CrearOrdenComponent } from './feature/crear-orden/crear-orden.component';
import { ListarPeliculaComponent } from './feature/listar-pelicula/listar-pelicula.component';




const routes: Routes = [
  { path: "", component: MoviestoreComponent },
  {
    path: "",
    children: [
      { path: "movie-store", component: MoviestoreComponent },
      { path: "listar-orden-form", component: ListarOrdenComponent },
      { path: "listar-pelicula-form", component: ListarPeliculaComponent},
      { path: "pelicula-form", component: CrearPeliculaComponent },
      { path: "orden-form", component: CrearOrdenComponent},
      { path: "cliente-form", component: CrearClienteComponent},
      { path: "factura/:id", component: MostrarFacturaComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

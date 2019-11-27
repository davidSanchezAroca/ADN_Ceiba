import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearClienteComponent } from './feature/crear-cliente/crear-cliente.component';


const routes: Routes = [
  { path: 'cliente', component: CrearClienteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

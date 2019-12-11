import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearOrdenComponent } from './crear-orden.component';

const routes: Routes = [{
  path: '',
  component: CrearOrdenComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CrearOrdenRoutingModule { }

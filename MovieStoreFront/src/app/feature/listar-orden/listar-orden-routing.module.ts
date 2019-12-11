import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarOrdenComponent } from './listar-orden.component';

const routes: Routes = [{
  path: '',
  component: ListarOrdenComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarOrdenRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviestoreComponent } from './moviestore.component';

const routes: Routes = [
  {
    path: '',
    component: MoviestoreComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MoviestoreRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MoviestoreRoutingModule } from './moviestore-routing.module';
import { MoviestoreComponent } from './moviestore.component';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MoviestoreComponent,
    MoviestoreRoutingModule
  ]
})
export class MoviestoreModule { }

import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';

import { CrearPeliculaRoutingModule } from './crear-pelicula-routing.module';
import { CrearPeliculaComponent } from './crear-pelicula.component';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { HttpClient} from "@angular/common/http";
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import es from "@angular/common/locales/es";
import {
  ReactiveFormsModule,
  FormsModule
} from "@angular/forms";
import { TranslateHttpLoader } from '@ngx-translate/http-loader';


defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
  declarations: [
    CrearPeliculaComponent
  ],
  imports: [
    CommonModule,
    CrearPeliculaRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: "es-ES"
    }
  ]
})
export class CrearPeliculaModule { }

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "assets/i18n/", ".json");
}
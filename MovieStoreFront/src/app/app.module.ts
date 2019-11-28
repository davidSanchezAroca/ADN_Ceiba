import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { HttpModule } from "@angular/http";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import {
  ReactiveFormsModule,
  FormsModule
} from "@angular/forms";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import es from "@angular/common/locales/es";
import { registerLocaleData } from "@angular/common";
import { LOCALE_ID } from "@angular/core";
import { CrearClienteComponent } from './feature/crear-cliente/crear-cliente.component';
import { MoviestoreComponent } from './feature/moviestore/moviestore.component';
import { CrearPeliculaComponent } from './feature/crear-pelicula/crear-pelicula.component';
import { CrearOrdenComponent } from './feature/crear-orden/crear-orden.component';
import { ListarOrdenComponent } from './feature/listar-orden/listar-orden.component';
import { ListarPeliculaComponent } from './feature/listar-pelicula/listar-pelicula.component';
import { ListarClienteComponent } from './feature/listar-cliente/listar-cliente.component';

defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
  declarations: [
    AppComponent,
    CrearClienteComponent,
    MoviestoreComponent,
    CrearPeliculaComponent,
    CrearOrdenComponent,
    ListarOrdenComponent,
    ListarPeliculaComponent,
    ListarClienteComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    AppRoutingModule,
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
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}

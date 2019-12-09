import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';

import { CrearClienteRoutingModule } from './crear-cliente-routing.module';
import { CrearClienteComponent} from './crear-cliente.component'
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { HttpClient} from "@angular/common/http";
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import es from "@angular/common/locales/es";
import {
  ReactiveFormsModule,
  FormsModule
} from "@angular/forms";

defineLocale("es", esLocale);
registerLocaleData(es);



@NgModule({
  declarations: [
    CrearClienteComponent
  ],
  imports: [
    CommonModule,
    CrearClienteRoutingModule,
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
export class CrearClienteModule { }

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "assets/i18n/", ".json");
}

import { Component, OnInit } from '@angular/core';
import swal from "sweetalert2";
import { Router, ActivatedRoute } from "@angular/router";
import { RestService } from 'src/app/core/services/rest.service';
import { Pelicula } from 'src/app/shared/interfaces/pelicula';
import { FormGroup, FormControl, Validators } from "@angular/forms";

@Component({
  selector: 'app-listar-pelicula',
  templateUrl: './listar-pelicula.component.html',
  styleUrls: ['./listar-pelicula.component.scss']
})
export class ListarPeliculaComponent implements OnInit {

  public editing: boolean = false;
  public peliculas : Pelicula[] = [];
  private nombre:string = null;
  private orden:number = null;
  public page: number = 1;
  public pageSize: number = 4;
  public collectionSize: number = this.peliculas.length;
  public myForm: FormGroup;

  constructor(private service: RestService,  private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.nombre = this.route.snapshot.queryParams["nombre"];
    this.orden = this.route.snapshot.queryParams["orden"];

    this.myForm = new FormGroup({
      nombre: new FormControl("nombre", [Validators.required]),
      orden: new FormControl("orden", [Validators.required]),
    });

    this.myForm.controls["nombre"].setValue("");
    this.myForm.controls["orden"].setValue("");

    this.getPeliculas();
  }

  getPeliculas(){
    let url = `api/pelicula/listar`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.peliculas = result;
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  agregar(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosAgregar = {
      nombre: controls["nombre"].value,
      orden: controls["orden"].value,
    };
    let url = `api/pelicula/orden/agregar`;
    let data = {
      "pelicula": {
        "nombre":datosAgregar.nombre
      },
      "orden":{
        "numeroOrden":datosAgregar.orden
      }
    }

    let body = JSON.stringify(data);
    this.service.queryPost(url, body).subscribe(data => {
      let result = data;
      if (result) {
        swal({
          title: "Exitoso",
          text: "Listado de peliculas",
          type: "success",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: "Ok",
        }).then(result => {

          this.router.navigate(["/movie-store"]);
        });
      } else {
        swal({
          title: "Error",
          text: "Error",
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: "Ok",
        }).then(result => {
          return false;
        });
      }
    }, err => {
      console.log(err);
    });
  }

  confirmVolver() {
    swal({
      title: "Confirmar",
      text: "Volver atras",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "si",
      cancelButtonText: "Cancelar"
    }).then(result => {
      if (result.value) {
        this.router.navigate(["/movie-store"]);
      }
    });
  }

  public controlHasError(controlName: string, validationType: string): boolean {
    const control = this.myForm.controls[controlName];
    if (!control) {
      return false;
    }
    const result =
      control.hasError(validationType) && (control.dirty || control.touched);
    return result;
  }



}

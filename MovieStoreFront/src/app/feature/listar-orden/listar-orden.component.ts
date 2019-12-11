import { Component, OnInit } from '@angular/core';
import swal from "sweetalert2";
import { Router, ActivatedRoute } from "@angular/router";
import { RestService } from 'src/app/core/services/rest.service';
import { Orden } from 'src/app/shared/interfaces/orden';
import { FormGroup, FormControl, Validators } from "@angular/forms";

@Component({
  selector: 'app-listar-orden',
  templateUrl: './listar-orden.component.html',
  styleUrls: ['./listar-orden.component.scss']
})
export class ListarOrdenComponent implements OnInit {

  public editing: boolean = false;
  public orden: Orden[]=[];
  public page: number = 1;
  public pageSize: number = 4;
  public collectionSize: number = this.orden.length;
  private cedula:string= null;
  public myForm: FormGroup;

  constructor(private service: RestService,  private router: Router,private route: ActivatedRoute) { }


  ngOnInit() {
    this.cedula = this.route.snapshot.queryParams["cedula"];
    this.myForm = new FormGroup({
      cedula: new FormControl("cedula", [Validators.required]),
    });

    this.myForm.controls["cedula"].setValue("");
  }

  getUrgencias(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }
    const datosOrden = {
      cedula: controls["cedula"].value,
    };
    let url = `api/orden/listar/`+datosOrden.cedula;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.orden = result;
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  confirmVolver() {
    swal({
      title: "Confirmar",
      text: "Volver atras",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "yes",
      cancelButtonText: "Cancelar"
    }).then(result => {
      if (result.value) {
        this.router.navigate(["/movie-store"]);
      }
    });
  }

  getPrecio(orden,cedula){
    swal({
      title: "Confirmar",
      text: "Error",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si",
      cancelButtonText: "Cancelar"
    }).then(result => {
      if (result.value) {
        this.calcularPrecio(orden,cedula);
      }
    });
  }

  private calcularPrecio(orden,cedula) {
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    let url = `api/orden/precio`;
    const datosOrden = {
      cedula: controls["cedula"].value,
    };
    let data = {
      "numeroOrden":1,
      "fechaOrden":orden.fechaOrden,
      "fechaInicio":orden.fechaInicio,
      "fechaFin":orden.fechaFin,
      "valor":0,
      "cliente":{
        "cedula":datosOrden.cedula
      }
    }
    let body = JSON.stringify(data);
    console.log(body);
    this.service.queryPost(url, body).subscribe(data => {
      let result = data;
      if (result) {
        swal({
          title: "Exitoso",
          text: "Lista cargada",
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
          text: "Error listando",
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

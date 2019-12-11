import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';

@Component({
  selector: 'app-crear-orden',
  templateUrl: './crear-orden.component.html',
  styleUrls: ['./crear-orden.component.scss']
})
export class CrearOrdenComponent implements OnInit {
  public editing: boolean = false;
  private numeroOrden:number= null;
  private fechaOrden: number = null;
  private fechaInicio: number = null;
  private fechaFin: number = null;
  private valor: number = null;
  private cedula:string = null;
  public myForm: FormGroup;

  constructor(
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

    this.fechaOrden = this.route.snapshot.queryParams["fechaOrden"];
    this.fechaInicio = this.route.snapshot.queryParams["fechaInicio"];
    this.fechaFin = this.route.snapshot.queryParams["fechaFin"];
    this.cedula = this.route.snapshot.queryParams["cedula"];

    this.myForm = new FormGroup({
     
      fechaOrden: new FormControl("fechaOrden", [Validators.required]),
      fechaInicio: new FormControl("fechaInicio", [Validators.required]),
      fechaFin: new FormControl("fechaFin", [Validators.required]),
      cedula: new FormControl("cedula", [Validators.required])
      
    });

    if (null !== this.cedula && undefined !== this.cedula) {
      this.myForm.controls["cedula"].setValue(this.cedula);
      this.editing = true;
    }

    this.myForm.controls["fechaOrden"].setValue("");
    this.myForm.controls["fechaInicio"].setValue("");
    this.myForm.controls["fechaFin"].setValue("");
    this.myForm.controls["cedula"].setValue("");
  }

  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosOrden = {
      
      fechaOrden: controls["fechaOrden"].value,
      fechaInicio: controls["fechaInicio"].value,
      fechaFin: controls["fechaFin"].value,
      cedula:controls["cedula"].value
      
    };
    let url = `api/orden/agregar`;

    let data = {
      "fechaOrden":datosOrden.fechaOrden,
      "fechaInicio":datosOrden.fechaInicio,
      "fechaFin":datosOrden.fechaFin,
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
          text: "Orden creada",
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
          text: "Error creando la orden",
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
      swal({
        title: "Error",
        text: "Verifique las fechas y cedula de usuario",
        type: "error",
        showCancelButton: false,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Ok",
      }).then(result => {
        return false;
      });
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
      confirmButtonText: "Si",
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

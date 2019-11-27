import { Component, OnInit } from '@angular/core';
import swal from "sweetalert2";
import { TranslateService } from '@ngx-translate/core';
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

  constructor(private service: RestService, public translate: TranslateService, private router: Router,private route: ActivatedRoute) { }


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
    let url = `http://localhost:8080/orden/listar/`+datosOrden.cedula;
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
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_volver"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
    }).then(result => {
      if (result.value) {
        this.router.navigate(["/movie-store"]);
      }
    });
  }

  getPrecio(orden,cedula){
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_delete"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
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

    let url = `http://localhost:8080/orden/precio`;
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
          title: this.translate.instant("alerts.success"),
          text: this.translate.instant("alerts.stored_urgencia"),
          type: "success",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
        }).then(result => {

          this.router.navigate(["/movie-store"]);
        });
      } else {
        swal({
          title: this.translate.instant("alerts.error"),
          text: this.translate.instant("alerts.cannot_delete_urgencia"),
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
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

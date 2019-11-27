import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
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
    private translate: TranslateService,
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
    let url = `http://localhost:8080/orden/agregar`;

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

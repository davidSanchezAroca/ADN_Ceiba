import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.scss']
})
export class CrearClienteComponent implements OnInit {
  public editing: boolean = false;
  private cedula:string = null;
  private nombre:string = null;
  private apellido:string = null;
  private fechaNacimiento: number = null;
  public myForm: FormGroup;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.cedula = this.route.snapshot.queryParams["cedula"];
    this.nombre = this.route.snapshot.queryParams["nombre"];
    this.apellido = this.route.snapshot.queryParams["apellido"];
    this.fechaNacimiento = this.route.snapshot.queryParams["fechaNacimiento"];

    this.myForm = new FormGroup({
      cedula: new FormControl("cedula", [Validators.required]),
      nombre: new FormControl("nombre", [Validators.required]),
      apellido: new FormControl("apellido", [Validators.required]),
      fechaNacimiento: new FormControl("fechaNacimiento", [Validators.required])
    });

    if (null !== this.cedula && undefined !== this.cedula) {
      this.myForm.controls["cedula"].setValue(this.cedula);
      this.editing = true;
    }

    this.myForm.controls["nombre"].setValue("");

    this.myForm.controls["apellido"].setValue("");

    this.myForm.controls["fechaNacimiento"].setValue("");
  }

  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosCliente = {
      cedula: controls["cedula"].value,
      nombre: controls["nombre"].value,
      apellido: controls["apellido"].value,
      fechaNacimiento: controls["fechaNacimiento"].value,
    };
    let url = `http://localhost:8080/cliente/agregar`;

    let data = {
      "cedula": datosCliente.cedula,
      "nombre": datosCliente.nombre,
      "apellido": datosCliente.apellido,
      "fechaNacimiento": datosCliente.fechaNacimiento
    }
    let body = JSON.stringify(data);
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

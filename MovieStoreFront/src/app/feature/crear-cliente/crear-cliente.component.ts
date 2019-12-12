import { Component, OnInit } from "@angular/core";
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

   

    this.myForm.controls["cedula"].setValue("");

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
    let url = `/api/cliente/agregar`;

    let data = {
      "cedula": datosCliente.cedula,
      "nombre": datosCliente.nombre,
      "apellido": datosCliente.apellido,
      "fechaNacimiento": datosCliente.fechaNacimiento
    }
    let body = JSON.stringify(data);
    this.service.queryPost(url, body).subscribe(data => {
      let result = data;
      console.log(result);
      if (result) {
        swal({
          title: "Exitoso",
          text: "Cliente creado",
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
          text:"Error",
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
        text: "Ya existe cliente",
        type: "error",
        showCancelButton: false,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText:"Ok",
      }).then(result => {
        return false;
      });
    });
  }

  confirmVolver() {
    swal({
      title: "Volver atras",
      text: "volver atras",
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

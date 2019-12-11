import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';

@Component({
  selector: 'app-crear-pelicula',
  templateUrl: './crear-pelicula.component.html',
  styleUrls: ['./crear-pelicula.component.scss']
})
export class CrearPeliculaComponent implements OnInit {

  public editing: boolean = false;
  private idProducto:number = null;
  private nombre:string = null;
  private valor:number = null;
  public myForm: FormGroup;
  constructor(
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

    this.nombre = this.route.snapshot.queryParams["nombre"];
    this.valor = this.route.snapshot.queryParams["valor"];

    this.myForm = new FormGroup({
     
      nombre: new FormControl("nombre", [Validators.required]),
      valor: new FormControl("valor", [Validators.required])
      
    });

    if (null !== this.nombre && undefined !== this.nombre) {
      this.myForm.controls["nombre"].setValue(this.nombre);
      this.editing = true;
    }

    this.myForm.controls["nombre"].setValue("");

    this.myForm.controls["valor"].setValue("");

  }

  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosPelicula = {
      
      nombre: controls["nombre"].value,
      valor: controls["valor"].value,
      
    };
    let url = `api/pelicula/agregar`;

    let data = {
      "nombre": datosPelicula.nombre,
      "valor": datosPelicula.valor,
    }
    let body = JSON.stringify(data);
    this.service.queryPost(url, body).subscribe(data => {
      let result = data;
      if (result) {
        swal({
          title: "Proceso exitoso",
          text: "pelicula guardada",
          type: "success",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: "ok",
        }).then(result => {

          this.router.navigate(["/movie-store"]);
        });
      } else {
        swal({
          title:"Error",
          text: "Error al crear la pelicula",
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText:"Ok",
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

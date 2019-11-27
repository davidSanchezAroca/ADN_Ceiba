import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
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
    private translate: TranslateService,
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
    let url = `http://localhost:8080/pelicula/agregar`;

    let data = {
      "nombre": datosPelicula.nombre,
      "valor": datosPelicula.valor,
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

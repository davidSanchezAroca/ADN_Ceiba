import { Component, OnInit } from '@angular/core';
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
  private cedula: string = null;
  private nombre: string = null;
  private apellido: string = null;
  private fechaNacimiento : number = null;
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
        cedula: new FormControl("cedula",[Validators.required]),
        nombre: new FormControl( "nombre",[Validators.required]),
        apellido: new FormControl("apellido",[Validators.required]),
        fechaNacimiento: new FormControl("fechaNacimiento",[Validators.required])
    });

    if(this.cedula !== null && undefined !== this.cedula){
      this.myForm.controls["cedula"].setValue(this.cedula);
      this.editing=true
    }

    this.myForm.controls["nombre"].setValue("");
    this.myForm.controls["apellido"].setValue("");

    if(this.fechaNacimiento !== null && undefined !== this.fechaNacimiento){
      this.myForm.controls["fechaNacimiento"].setValue(this.fechaNacimiento);
    }
  }

}


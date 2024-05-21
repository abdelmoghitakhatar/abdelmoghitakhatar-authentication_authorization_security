import {NgModule} from "@angular/core";
import {PrimengModule} from "./primeng/primeng.module";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports:[
    PrimengModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations:[],
  exports:[
    PrimengModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class SharedModule{}

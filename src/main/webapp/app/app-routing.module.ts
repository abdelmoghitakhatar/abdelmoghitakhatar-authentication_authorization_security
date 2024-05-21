import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NAVBAR_ROUTE} from "./layouts/navbar/navbar.route";
import {EntitiesRoutingModule} from "./entities/entities-routing.module";

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(m => m.LoginModule),
  },
  {
    path: '',
    loadChildren: () => import("./entities/entities-routing.module").then(m => m.EntitiesRoutingModule)
  },
  NAVBAR_ROUTE
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import {NgModule} from "@angular/core";
import {HomeComponent} from "./home.component";
import {SharedModule} from "../../shared/shared.module";
import {RouterModule} from "@angular/router";
import {HOME_ROUTE} from "./home.route";

@NgModule({
  imports: [SharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class HomeModule {}

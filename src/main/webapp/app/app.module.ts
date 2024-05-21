import {LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule, Title} from '@angular/platform-browser';
import * as fr from '@angular/common/locales/fr';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './layouts/main/app.component';
import {NavbarComponent} from "./layouts/navbar/navbar.component";
import {FooterComponent} from "./layouts/footer/footer.component";
import {httpInterceptorProviders} from "./core/interceptors";
import {registerLocaleData} from "@angular/common";
import {SharedModule} from "./shared/shared.module";
import {HomeModule} from "./layouts/home/home.module";
import {LoginModule} from "./login/login.module";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HomeModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [
    Title,
    { provide: LOCALE_ID, useValue: 'fr' },
    httpInterceptorProviders,],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(){
    registerLocaleData(fr.default);
  }
}

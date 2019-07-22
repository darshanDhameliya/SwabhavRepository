import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './homePage.component';
import { AboutPageComponent } from './aboutPage.component';
import { CareerPageComponent } from './careerPage.component';
import { RouteArray } from './RoutingConfig';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,HomePageComponent,AboutPageComponent,CareerPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(RouteArray)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

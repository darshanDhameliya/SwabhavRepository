import { Route } from "@angular/router";
import { AboutPageComponent } from './aboutPage.component';
import { CareerPageComponent } from './careerPage.component';
import { HomePageComponent } from './homePage.component';

export const RouteArray:Route[]=  [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'about', component: AboutPageComponent},
  {path: 'career', component: CareerPageComponent},
  ];

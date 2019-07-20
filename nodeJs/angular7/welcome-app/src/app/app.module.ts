import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { MultiBind } from './multiBind/multiBind.component'; 
import { ToggleButtonComponent } from './toggleButton/toggleButton.component'; 
import { BlueBall } from './blueBallGame/blueBall.component';
import { CgpaBedge } from './pipes/cgpaBedge.pipe';
import { StarRatingComponent } from './starRating/star.rating.component';
import { MathService } from './services/mathService';

@NgModule({
  declarations: [
    WelcomeComponent,
    StudentComponent,
    MultiBind,
    CgpaBedge,
    BlueBall,
    ToggleButtonComponent,
    StarRatingComponent
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [MathService],
  bootstrap: [WelcomeComponent,StudentComponent,MultiBind,BlueBall]
})
export class AppModule { }

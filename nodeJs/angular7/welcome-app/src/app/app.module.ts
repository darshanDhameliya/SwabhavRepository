import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { MultiBind } from './multiBind/multiBind.component'; 
import { BlueBall } from './blueBallGame/blueBall.component';
import { CgpaBedge } from './pipes/cgpaBedge.pipe';

@NgModule({
  declarations: [
    WelcomeComponent,
    StudentComponent,
    MultiBind,
    CgpaBedge,
    BlueBall
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [],
  bootstrap: [WelcomeComponent,StudentComponent,MultiBind,BlueBall]
})
export class AppModule { }

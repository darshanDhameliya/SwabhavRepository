import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { CgpaBedge } from './pipes/cgpaBedge.pipe';

@NgModule({
  declarations: [
    WelcomeComponent,
    StudentComponent,
    CgpaBedge
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [],
  bootstrap: [WelcomeComponent,StudentComponent]
})
export class AppModule { }

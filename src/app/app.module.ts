import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatToolbarModule, MatDialogModule, MatButtonModule, MatIconModule, MatInputModule } from '@angular/material'

import { AppComponent } from './app.component';
import { DialogInfoComponent } from './dialog-info/dialog-info.component';
import { DialogComfirmComponent } from './dialog-comfirm/dialog-comfirm.component';
import { DialogInputComponent } from './dialog-input/dialog-input.component';
import { FormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    DialogInfoComponent,
    DialogComfirmComponent,
    DialogInputComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    FormsModule
  ],
  entryComponents: [DialogInfoComponent, DialogComfirmComponent, DialogInputComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

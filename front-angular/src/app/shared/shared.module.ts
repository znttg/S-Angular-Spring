import { AppMaterialModule } from './app-material/app-material.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';

import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';

@NgModule({
  declarations: [
    ErrorDialogComponent
  ],
  imports: [
    CommonModule,
    MatDialogModule,
    AppMaterialModule
  ],
  exports: [
    ErrorDialogComponent
  ]
})
export class SharedModule { }

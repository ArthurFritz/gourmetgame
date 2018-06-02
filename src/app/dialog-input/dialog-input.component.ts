import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Inject } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-dialog-input',
  templateUrl: './dialog-input.component.html',
  styleUrls: ['./dialog-input.component.scss']
})
export class DialogInputComponent implements OnInit {

  public resultInfo = "";
  constructor(public dialogRef: MatDialogRef<DialogInputComponent>, @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  fechar(){
    if(this.resultInfo && this.resultInfo != ""){
      this.dialogRef.close(this.resultInfo);
    }else{
      this.dialogRef.close(null);
    }
    
  }
}

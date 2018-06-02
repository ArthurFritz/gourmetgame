import { Component, OnInit } from '@angular/core';
import { Inject } from "@angular/core";
import { MAT_DIALOG_DATA } from "@angular/material/dialog";
import { MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-dialog-comfirm',
  templateUrl: './dialog-comfirm.component.html',
  styleUrls: ['./dialog-comfirm.component.scss']
})
export class DialogComfirmComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogComfirmComponent>,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

   fechar(status){
      this.dialogRef.close(status);
  }

}

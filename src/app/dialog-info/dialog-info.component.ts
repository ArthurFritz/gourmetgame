import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from "@angular/material";
import { Inject } from "@angular/core";

@Component({
  selector: 'app-dialog-info',
  templateUrl: './dialog-info.component.html',
  styleUrls: ['./dialog-info.component.scss']
})
export class DialogInfoComponent implements OnInit {
  
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

}

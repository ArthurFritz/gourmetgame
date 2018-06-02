import { Component } from '@angular/core';
import { Response } from "src/app/model/Response";
import { MatDialog } from "@angular/material";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  game = new Response("massa", this.dialog);
  constructor(private dialog:MatDialog){
    this.game.changePositiveAndNegative("Lasanha","Bolo de Chocolate");
  }

  callGame() {
    this.game.quiz();
  }
}

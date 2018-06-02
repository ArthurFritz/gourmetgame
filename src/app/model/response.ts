import { Question } from "src/app/model/question";
import { EmptyResponse } from "src/app/model/emptyResponse";
import { MatDialog } from "@angular/material";
import { DialogComfirmComponent } from "src/app/dialog-comfirm/dialog-comfirm.component";

export class Response implements Question {

    private information:string;
    private responsePositive:Question = new EmptyResponse(this.dialog);
    private responseNegative:Question = new EmptyResponse(this.dialog);

    constructor(information: string,private dialog:MatDialog) {
        this.information = information;
    }

    public changePositiveAndNegative(positive:string, negative:string) : void {
        this.responsePositive = new Response(positive, this.dialog);
        this.responseNegative = new Response(negative, this.dialog);
    }
    
    quiz() {
         this.dialog.open(DialogComfirmComponent, {
            data: {
                message: `O prato que você pensou é ${this.information}?`
            }, disableClose : true
        }).afterClosed().subscribe(data=>{
            data ? this.responsePositive.positive() : this.responseNegative.negative(this);
        });
    }
    positive() {
        this.quiz();
    }
    negative(question: Question) {
        this.quiz();
    }
    addQuestion(otherDish: string, difference: string) {
        this.responseNegative = new Response(this.information, this.dialog);
        this.responsePositive = new Response(otherDish, this.dialog);
        this.information = difference;
    }

    getInformation(): string {
        return this.information;
    }

}
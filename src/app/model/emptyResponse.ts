import { Question } from "src/app/model/question";
import { MatDialog } from "@angular/material";
import { DialogInfoComponent } from "src/app/dialog-info/dialog-info.component";
import { ReflectiveInjector } from "@angular/core";
import { Inject } from "@angular/core";
import { DialogInputComponent } from "src/app/dialog-input/dialog-input.component";


export class EmptyResponse implements Question {
    
    private TEXT_QUESTION_NEW:string = "Qual prato que você pensou ?";
    private ACERTEI_DE_NOVO:string = "Acertei de novo!";
    constructor(private dialog:MatDialog){        }

    quiz() {
        throw new Error("Não há informações do prato para chamada deste método");
    }

    positive() {
        this.dialog.open(DialogInfoComponent, {
            data: {
                message: this.ACERTEI_DE_NOVO
            }
        });
    }

    negative(question: Question) {
        let otherDish, difference;
        this.dialog.open(DialogInputComponent, {
            data: {
                message: this.TEXT_QUESTION_NEW
            }, disableClose : true
        }).afterClosed().subscribe(data=>{
            otherDish = data;
            this.callDiference(question, data);
        });
    }

    callDiference(question:Question, otherDish){
        this.dialog.open(DialogInputComponent, {
            data: {
                message: `${otherDish} é ___________ mas ${question.getInformation()} não.`
            }, disableClose : true
        }).afterClosed().subscribe(data=>{
            question.addQuestion(otherDish, data);
        })
    }

    addQuestion(otherDish: string, difference: string) {
        throw new Error("Não há informações do prato para inclusão da questão");
    }
    getInformation(): string {
        throw new Error("Não há informações do prato para obter as informações");
    }

}
export interface Question {
    quiz();
    positive();
    negative(question: Question);
    addQuestion(otherDish:string, difference:string);
    getInformation():string;
}
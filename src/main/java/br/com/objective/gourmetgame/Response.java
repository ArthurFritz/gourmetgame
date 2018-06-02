package br.com.objective.gourmetgame;

import javax.swing.*;

public class Response implements Question {

    public static final String TEXT_QUESTION = "O prato que você pensou é %s?";
    private String information;
    private Question responsePositive = new EmptyResponse();
    private Question responseNegative = new EmptyResponse();

    public Response(String information){
        this.information = information;
    }

    public void changePositiveAndNegative(String positive, String negative){
        this.responsePositive = new Response(positive);
        this.responseNegative = new Response(negative);
    }

    @Override
    public void quiz() {
        String textQuestion = String.format(TEXT_QUESTION, this.information);
        int response = JOptionPane.showConfirmDialog(null, textQuestion , titleQuestion, JOptionPane.YES_NO_OPTION);
        switch (response){
            case JOptionPane.YES_OPTION:
                responsePositive.positive();
                break;
            default:
                responseNegative.negative(this);
                break;
        }
    }

    @Override
    public void positive() {
        this.quiz();
    }

    @Override
    public void negative(Question question) {
        this.quiz();
    }

    @Override
    public void addQuestion(String otherDish,String difference) {
        responseNegative = new Response(this.information);
        responsePositive = new Response(otherDish);
        this.information = difference;
    }

    @Override
    public String getInformation() {
        return information;
    }

}

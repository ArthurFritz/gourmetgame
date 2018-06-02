package br.com.objective.gourmetgame;

public interface Question {

    static String titleQuestion = "Pergunta";

    void quiz();

    void positive();

    void negative(Question question);

    void addQuestion(String otherDish,String difference);

    String getInformation();

}

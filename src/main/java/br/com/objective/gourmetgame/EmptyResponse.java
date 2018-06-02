package br.com.objective.gourmetgame;

import javax.swing.*;

public class EmptyResponse implements Question {

    public static final String TEXT_QUESTION_NEW = "Qual prato que você pensou?";
    public static final String TEXT_QUESTION_IS = "%s é ___________ mas %s não.";
    private static final String ACERTEI_DE_NOVO = "Acertei de novo!";

    @Override
    public void quiz() {
        throw new UnsupportedOperationException("Não há informações do prato para chamada deste método");
    }

    @Override
    public void positive() {
        JOptionPane.showMessageDialog(null, ACERTEI_DE_NOVO);
    }

    @Override
    public void negative(Question question) {
        String otherDish = JOptionPane.showInputDialog(null, TEXT_QUESTION_NEW, titleQuestion, JOptionPane.QUESTION_MESSAGE);
        String txtQuestion = String.format(TEXT_QUESTION_IS, otherDish, question.getInformation());
        String difference = JOptionPane.showInputDialog(null, txtQuestion, titleQuestion, JOptionPane.QUESTION_MESSAGE);
        question.addQuestion(otherDish,difference);
    }

    @Override
    public void addQuestion(String otherDish,String difference) {
        throw new UnsupportedOperationException("Não há informações do prato para inclusão da questão");
    }

    @Override
    public String getInformation() {
        throw new UnsupportedOperationException("Não há informações do prato para obter as informações");
    }

}

package br.com.objective.gourmetgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ JOptionPane.class })
public class ResponseTest {

    private static final String NEW_RESPONSE = "new response";
    private Response game;

    @Before
    public void setup(){
        game = new Response(NEW_RESPONSE);
    }

    @Test
    public void testGetInformation(){
        assertEquals(game.getInformation(), NEW_RESPONSE);
    }

    @Test
    public void testAddQuestion(){
        game.addQuestion("otherDish","difference");
        assertEquals(game.getInformation(), "difference");
    }

    @Test
    public void testPositive(){
        PowerMockito.mockStatic(JOptionPane.class);
        game.positive();
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        JOptionPane.showConfirmDialog(eq(null), eq(textQuestion) , eq(Question.titleQuestion), eq(JOptionPane.YES_NO_OPTION));
    }

    @Test
    public void testNegative(){
        PowerMockito.mockStatic(JOptionPane.class);
        game.negative(new Response("other"));
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        JOptionPane.showConfirmDialog(eq(null), eq(textQuestion) , eq(Question.titleQuestion), eq(JOptionPane.YES_NO_OPTION));
    }

    @Test
    public void testQuizOkEmptyPositive(){
        PowerMockito.mockStatic(JOptionPane.class);
        game.quiz();
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        PowerMockito.when(JOptionPane.showConfirmDialog(eq(null),eq(textQuestion),anyString(),eq(JOptionPane.YES_NO_OPTION))).thenReturn(JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(eq(null), eq("Acertei de novo!"));
    }

    @Test
    public void testQuizOkPositive(){
        PowerMockito.mockStatic(JOptionPane.class);
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        PowerMockito.when(JOptionPane.showConfirmDialog(eq(null),eq(textQuestion),anyString(),eq(JOptionPane.YES_NO_OPTION))).thenReturn(JOptionPane.YES_OPTION);
        game.changePositiveAndNegative("positive","negative");
        String textQuestionSecond = String.format(Response.TEXT_QUESTION, "positive");
        JOptionPane.showConfirmDialog(eq(null), eq(textQuestionSecond) , eq(Question.titleQuestion), eq(JOptionPane.YES_NO_OPTION));
    }

    @Test
    public void testQuizEmptyCancel(){
        PowerMockito.mockStatic(JOptionPane.class);
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        PowerMockito.when(JOptionPane.showConfirmDialog(eq(null),eq(textQuestion),anyString(),eq(JOptionPane.YES_NO_OPTION))).thenReturn(JOptionPane.NO_OPTION);
        String txtOtherDish = String.format(EmptyResponse.TEXT_QUESTION_IS, "otherDish", NEW_RESPONSE);
        PowerMockito.when(JOptionPane.showInputDialog(eq(null),eq(EmptyResponse.TEXT_QUESTION_NEW),anyString(),eq(JOptionPane.QUESTION_MESSAGE))).thenReturn("otherDish");
        PowerMockito.when(JOptionPane.showInputDialog(eq(null), eq(txtOtherDish),anyString(), eq(JOptionPane.QUESTION_MESSAGE))).thenReturn("diference");
        game.quiz();
        assertEquals("diference", game.getInformation());
    }

    @Test
    public void testQuizCancel(){
        PowerMockito.mockStatic(JOptionPane.class);
        String textQuestion = String.format(Response.TEXT_QUESTION, NEW_RESPONSE);
        PowerMockito.when(JOptionPane.showConfirmDialog(eq(null),eq(textQuestion),anyString(),eq(JOptionPane.YES_NO_OPTION))).thenReturn(JOptionPane.NO_OPTION);
        game.changePositiveAndNegative("positive","negative");
        String textQuestionSecond = String.format(Response.TEXT_QUESTION, "negative");
        JOptionPane.showConfirmDialog(eq(null), eq(textQuestionSecond) , eq(Question.titleQuestion), eq(JOptionPane.YES_NO_OPTION));
    }

}

package br.com.objective.gourmetgame;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
public class EmptyResponseTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private EmptyResponse response;

    @Before
    public void setup(){
        response = new EmptyResponse();
    }

    @Test
    public void testExceptionInformation(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Não há informações do prato para obter as informações");
        response.getInformation();
    }

    @Test
    public void testExceptionAddQuestion(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Não há informações do prato para inclusão da questão");
        response.addQuestion("otherDish","diferrence");
    }

    @Test
    public void testExceptionQuiz(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Não há informações do prato para chamada deste método");
        response.quiz();
    }

    @Test
    public void positive(){
        PowerMockito.mockStatic(JOptionPane.class);
        response.positive();
        JOptionPane.showMessageDialog(eq(null), eq("Acertei de novo!"));
    }

    @Test
    public void negative(){
        Response newResponse = new Response("newResponse");
        PowerMockito.mockStatic(JOptionPane.class);
        String txtQuestion = String.format(EmptyResponse.TEXT_QUESTION_IS, "otherDish", newResponse.getInformation());
        PowerMockito.when(JOptionPane.showInputDialog(eq(null),eq(EmptyResponse.TEXT_QUESTION_NEW),anyString(),eq(JOptionPane.QUESTION_MESSAGE))).thenReturn("otherDish");
        PowerMockito.when(JOptionPane.showInputDialog(eq(null), eq(txtQuestion),anyString(), eq(JOptionPane.QUESTION_MESSAGE))).thenReturn("diference");
        response.negative(newResponse);
        assertEquals("diference", newResponse.getInformation());
    }


}

package br.com.objective.gourmetgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App
{
    private static Response game;

    public static void main( String[] args )
    {
        configureGame();
        createLayout();
    }

    private static void configureGame() {
        game = new Response("massa");
        game.changePositiveAndNegative("Lasanha","Bolo de Chocolate");
    }

    private static void createLayout() {
        final JFrame frame = new JFrame(":: Gourmet Game :: ");
        JLabel informationLabel = new JLabel("Pense em um prato que gosta");
        JButton okButton = new JButton("OK");
        frame.setSize(300,130);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(informationLabel);
        informationLabel.setBounds(60,0,300, 60);
        frame.add(okButton);
        okButton.setBounds(90 , 60, 100 , 25);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.quiz();
            }
        });
    }
}

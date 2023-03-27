package org.example.Compulsory;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        //Main frame-ul aplicatiei
        JFrame mainFrame = new JFrame("Lab 6");
        mainFrame.setSize(1000,800);
        mainFrame.setLayout(new BorderLayout());

        //Un configuration panel pentru a introduce numarul de puncte/linii si pentru butonul care creaza un nou joc
        JPanel configurationPanel = new JPanel(new GridLayout(1, 5));

        JLabel dots = new JLabel("Number of dots: ");
        JTextField dotsField = new JTextField();
        JLabel lines = new JLabel("Number of lines: ");
        JTextField linesField = new JTextField();
        JButton newGame = new JButton("Create new game");

        dots.setHorizontalAlignment(JLabel.CENTER);
        lines.setHorizontalAlignment(JLabel.CENTER);

        configurationPanel.add(dots);
        configurationPanel.add(dotsField);
        configurationPanel.add(lines);
        configurationPanel.add(linesField);
        configurationPanel.add(newGame);

        //Un drawing panel pentru a desena tabla de joc
        DrawingPanel canvas = new DrawingPanel(200, 10, 6,15);

        //Un control panel cu butoane pentru load, save, reset, exit
        JPanel controlPanel = new JPanel();
        JButton load = new JButton("Load");
        JButton save = new JButton("Save");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        controlPanel.add(load);
        controlPanel.add(save);
        controlPanel.add(reset);
        controlPanel.add(exit);

        //Adaugarea componentelor la mainframe
        mainFrame.add(configurationPanel, BorderLayout.NORTH);
        mainFrame.add(canvas, BorderLayout.CENTER);
        mainFrame.add(controlPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }
}
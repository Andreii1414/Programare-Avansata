package org.example.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args) {
        //Main frame-ul aplicatiei
        final JFrame[] mainFrame = {new JFrame("Lab 6")};
        mainFrame[0].setSize(1000,800);
        mainFrame[0].setLayout(new BorderLayout());

        //Un configuration panel pentru a introduce numarul de puncte/linii si pentru butonul care creaza un nou joc
        JPanel configurationPanel = new JPanel(new GridLayout(1, 5));

        JLabel dots = new JLabel("Number of dots: ");
        JTextField dotsField = new JTextField();
        JLabel lines = new JLabel("Number of lines: ");
        JSpinner linesField = new JSpinner();
        JButton newGame = new JButton("Create new game");

        dots.setHorizontalAlignment(JLabel.CENTER);
        lines.setHorizontalAlignment(JLabel.CENTER);

        configurationPanel.add(dots);
        configurationPanel.add(dotsField);
        configurationPanel.add(lines);
        configurationPanel.add(linesField);
        configurationPanel.add(newGame);

        //Un drawing panel pentru a desena tabla de joc
        final DrawingPanel[] canvas = {new DrawingPanel(200, 10, 6, 15)};

        //Un control panel cu butoane pentru load, save, reset, exit
        JPanel controlPanel = new JPanel();
        JButton load = new JButton("Load");
        JButton save = new JButton("Save");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        JButton export = new JButton("Export");
        controlPanel.add(load);
        controlPanel.add(save);
        controlPanel.add(reset);
        controlPanel.add(exit);
        controlPanel.add(export);

        //Adaugarea componentelor la mainframe
        mainFrame[0].add(configurationPanel, BorderLayout.NORTH);
        mainFrame[0].add(canvas[0], BorderLayout.CENTER);
        mainFrame[0].add(controlPanel, BorderLayout.SOUTH);


        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nrDots = Integer.parseInt(dotsField.getText());
                    int nrLines = (int) linesField.getValue();
                    DrawingPanel drawingPanel = new DrawingPanel(200, 10, nrDots, nrLines);
                    mainFrame[0].remove(canvas[0]);
                    canvas[0] = drawingPanel;
                    mainFrame[0].add(drawingPanel, BorderLayout.CENTER);
                    mainFrame[0].revalidate();
                    mainFrame[0].repaint();

                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(mainFrame[0], "Invalid input for number of dots");
                }
                catch (InvalidNumberOfDotsOrLines ex) {
                    JOptionPane.showMessageDialog(mainFrame[0], ex.getMessage());
                }
            }
        });

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(mainFrame[0]);
                game.exportImage();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(mainFrame[0]);
                game.saveGame("savedGame.ser");
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(mainFrame[0]);
                game.loadGame("savedGame.ser");
                mainFrame[0].repaint();

            }
        });

        mainFrame[0].setVisible(true);
    }
}
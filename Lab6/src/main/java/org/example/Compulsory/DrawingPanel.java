package org.example.Compulsory;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    private int radius;
    private int dotRadius;
    private int number_of_dots;
    private int number_of_lines;

    public DrawingPanel(int radius, int dotRadius, int number_of_dots, int number_of_lines) {

        if(number_of_dots < 4)
            throw new InvalidNumberOfDotsOrLines("Numarul de puncte trebuie sa fie 4 sau mai mult");
        if(number_of_lines < number_of_dots)
            throw new InvalidNumberOfDotsOrLines("Numarul de linii trebuie sa fie cel putin egal cu numarul de puncte");
        if(number_of_lines > number_of_dots*(number_of_dots - 1)/2)
            throw new InvalidNumberOfDotsOrLines("Numarul maxim de linii este nrPuncte(nrPuncte - 1)/2");

        this.radius = radius;
        this.dotRadius = dotRadius;
        this.number_of_dots = number_of_dots;
        this.number_of_lines = number_of_lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.WHITE);

        //mijlocul spatiului de joc
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        //gasirea coordonatelor punctelor calculand gradul unghiurilor in functie de nr de puncte
        int[] x = new int[number_of_dots];
        int[] y = new int[number_of_dots];
        for (int i = 0; i < number_of_dots; i++) {
            double angle = (2*Math.PI) / number_of_dots * i;
            x[i] = (int) (centerX + radius * Math.cos(angle));
            y[i] = (int) (centerY + radius * Math.sin(angle));
        }

        //desenarea punctelor
        g.setColor(Color.BLACK);
        for(int i = 0; i < number_of_dots; i++) {
            g.fillOval(x[i]-dotRadius, y[i]-dotRadius, dotRadius*2, dotRadius*2);
        }

        //desenarea liniilor
        g.setColor(Color.GRAY);
        int lines = number_of_lines;
        for(int i = 0; i < number_of_dots - 1 && lines != 0; i++) {
            for (int j = i + 1; j < number_of_dots; j++) {
                if (lines == 0) break;
                g.drawLine(x[i], y[i], x[j], y[j]);
                lines--;
            }
        }

    }
}

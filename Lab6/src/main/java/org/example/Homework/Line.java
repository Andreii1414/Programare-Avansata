package org.example.Homework;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    private Dot dot1, dot2;
    private Color color;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.color = Color.GRAY;
    }

    public Dot getDot1() {
        return dot1;
    }

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean contains(Point p)
    {
        int d1 = (int) Math.sqrt(Math.pow(p.getX() - dot1.getX(), 2) + Math.pow(p.getY() - dot1.getY(), 2));
        int d2 = (int) Math.sqrt(Math.pow(p.getX() - dot2.getX(), 2) + Math.pow(p.getY() - dot2.getY(), 2));
        int dline = (int) Math.sqrt(Math.pow(dot2.getX() - dot1.getX(), 2) + Math.pow(dot2.getY() - dot1.getY(), 2));
        return d1 + d2 == dline;
    }
}

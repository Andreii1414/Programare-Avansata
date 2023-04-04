package org.example.Homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class Game extends JFrame implements Serializable {

    private static final long serialVersionUID = 1L;

    JFrame frame;

    public Game(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void exportImage() {
        try {
            BufferedImage image = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = image.createGraphics();
            frame.paint(graphics);
            graphics.dispose();
            File file = new File("boardGame.png");
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveGame(String filename)
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadGame(String filename)
    {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Game game = (Game) objectInputStream.readObject();
            this.setFrame(game.getFrame());
            objectInputStream.close();
            fileInputStream.close();

            game.getFrame().setVisible(true);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

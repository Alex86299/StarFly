import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy {
    public static final int MAX_X = 650;
    public static final int MIN_X = 20;
    Random rand = new Random();
    int ex;
    int ey = -140;//visota
    int dey = rand.nextInt((10)+5);
    //ускорение врагов
    int dx;
    Image img = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\enemy.gif").getImage();
    //Image img2 = new ImageIcon("res/enemy2.gif").getImage();//second enemy
    // Image img = new
    // ImageIcon(getClass().getClassLoader().getResource("res/enemy1.gif")).getImage();
    // Image img2 = new
    // ImageIcon(getClass().getClassLoader().getResource("res/enemy2.gif")).getImage();
    Space space;



    public Rectangle getRect() {
        return new Rectangle(ex, ey, 80, 80);

    }

    public Enemy(int x, int y, Space space) {
        this.ex = x;
        this.ey = y;
        this.space = space;

        //ограничение на врагов нельзя выходить за границы окна
        if (ex <= MIN_X)
            ex = MIN_X;
        if (ex >= MAX_X)
            ex = MAX_X;
    }

    public void move() {
        Random rand = new Random();
        ex = rand.nextInt(500)+150;

    }

    public void move1() {
        Random rand = new Random();
        ey = ey + dey;

    }
}

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {


    public static final int MAX_X = 650;
    public static final int MIN_X = 20;
    public static final int MAX_Y = 650;
    public static final int MIN_Y = 20;
    public static final int MAX_DY = 450;

    Image imgc = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\heroc.gif").getImage();
    Image imgl = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\herol.gif").getImage();
    Image imgr = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\heror.gif").getImage();

    /* ImageIcon(getClass().getClassLoader().getResource("res/heroc.gif")).getImage(); Image imgl = new
     * ImageIcon(getClass().getClassLoader().getResource("res/herol.gif")).getImage(); Image imgr = new
     * ImageIcon(getClass().getClassLoader().getResource("res/heror.gif")).getImage();					 */
    Image img = imgc;

    public Rectangle getRect() {
        return new Rectangle(x, y, 80, 80);
    }

    int v = 15;

    int x = 350;// koordinat hero
    int y = 650;
    int dx;
    int dy;

    int layer1 = 0;
    int layer2 = -800;

    public void move() {

        y += dy;
        if (y <= MIN_Y)
            y = MIN_Y;
        if (y >= MAX_Y)
            y = MAX_Y;
        if (x <= MIN_X)
            x = MIN_X;
        if (x >= MAX_X)
            x = MAX_X;
        x += dx;
        if (layer2 + v >= 0) {
            layer2 = -800;
            layer1 = 0;
        } else
            layer1 += v;
        layer2 += v;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy -= 15;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy += 15;

        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -18;
            img = imgl;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = +18;
            img = imgr;
        }
        if (key == KeyEvent.VK_SPACE){
            //	Paint.ball = true;  //SHOOT
        }
    }

    public void keyReleassed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
            img = imgc;
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
            img = imgc;
        }

    }
}
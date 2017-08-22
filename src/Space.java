import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Space extends JPanel implements ActionListener, Runnable {

    Timer mainTimer = new Timer(20, this);

    Image img = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\fon.jpg").getImage();
    // Image img = new
    // ImageIcon(getClass().getClassLoader().getResource("res/fon.jpg")).getImage();

    Player p = new Player();

    Thread enemiesFactory = new Thread(this);

    List<Enemy> enemies = new ArrayList<Enemy>();

    public Space() {

        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            p.keyReleassed(e);
        }

    }

    public void paint(Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(img, 0, p.layer1, null);
        // (рисунок, смещение от верхнего левого угла + вправо - влево,
        // смещение от верхнего левого угла + вверх - вниз
        g.drawImage(img, 0, p.layer2, null);// рисуем второй слой фона и смещаем
        // его вниз
        g.drawImage(p.img, p.x, p.y, null);// рисуем корабль игрока

        // score counter
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 25);
        g.setFont(font);
        g.drawString("SCORE ", 100, 30);

        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();

            e.move1();
            g.drawImage(e.img, e.ex, e.ey, null);
            //	g.drawImage(e.img2, (e.ex - 250), (e.ey - 250), null);//second enemy

        }

    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        testCollisionWithEnemies();
    }

    private void testCollisionWithEnemies() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (p.getRect().intersects(e.getRect())) {
                JOptionPane.showMessageDialog(null, "YOU LOSE!");
                i.remove();
                System.exit(1);
                // BOOM.gif

            }
        }

    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();

            try {
                Thread.sleep(rand.nextInt(2500));
                enemies.add(new Enemy(rand.nextInt(1000), -100, this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

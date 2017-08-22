import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
    public static Image background = new ImageIcon("C:\\IdeaProjects\\Star_fly\\src\\res\\menu.jpg").getImage();
    static JFrame frame = new JFrame("STAR FIGHT");


    public Main() {
        try {
            initComponents();
        } catch (Exception ex) {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    private void initComponents() throws Exception {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 800);
        MainMenuPanel mmp = new MainMenuPanel();
        frame.add(mmp);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MainMenuPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    // create labels for Main Menu
    public PopUpJLabel multiPlayerModeLabel;
    public static PopUpJLabel2 singlePlayerModeLabel;
    public PopUpJLabel3 optionsLabel;

    public PopUpJLabel4 aboutLabel;
    // create variable to hold background

    private Dimension preferredDimensions;
    public static String gameType;
    public static final String SINGLE_PLAYER = "Single Player",
            VERSUS_MODE = "VS Mode";

    /**
     * Default constructor to initialize double buffered JPanel with
     * GridBagLayout
     */
    public MainMenuPanel() {
        super(new GridBagLayout(), true);
        try {
            initComponents();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Could not load main menu background!",
                    "Main Menu Error: 0x004", JOptionPane.ERROR_MESSAGE);
            System.exit(4);
        }
    }

    /*
     * Create JPanel and its components
     */
    private void initComponents() throws Exception {

        // set prefered size of JPanel
        preferredDimensions = new Dimension(800, 800);

        // create label instances
        singlePlayerModeLabel = new PopUpJLabel2("Single Player Mode");
        multiPlayerModeLabel = new PopUpJLabel("Multi Player Mode");
        multiPlayerModeLabel.setEnabled(false);
        optionsLabel = new PopUpJLabel3("Options");
        aboutLabel = new PopUpJLabel4("About");

        // create new constraints for gridbag
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 10;// vertical spacing

        // add newGameLabel to panel with constraints
        gc.gridx = 0;
        gc.gridy = 0;
        add(singlePlayerModeLabel, gc);

        gc.gridy = 1;
        add(multiPlayerModeLabel, gc);
        // add optionsLabel to panel with constraints (x is the same)
        gc.gridy = 2;
        add(optionsLabel, gc);
        // add helpLabel to panel with constraints (x is the same)
        gc.gridy = 3;
        //add(helpLabel, gc);
        // add aboutLabel to panel with constraints (x is the same)
        gc.gridy = 4;
        add(aboutLabel, gc);
    }

    /*
     * Will return the preffered size of JPanel
     */
    @Override
    public Dimension getPreferredSize() {
        return preferredDimensions;
    }

	/*
	 * Will draw the background to JPanel with anti-aliasing on and quality
	 * rendering
	 */

    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        // convert graphics object to graphics2d object
        Graphics2D g2d = (Graphics2D) grphcs;

        // set anti-aliasing on and rendering etc
        // GamePanel.applyRenderHints(g2d);

        // draw the image as the background
        g2d.drawImage(Main.background, 0, 0, null);

        // g2d.dispose();//if I uncomment this no LAbels will be shown
    }
}

class PopUpJLabel extends JLabel {

    private static final long serialVersionUID = 1L;
    public final static Font defaultFont = new Font("Arial", Font.PLAIN, 50);
    public final static Font hoverFont = new Font("Arial", Font.BOLD, 70);

    PopUpJLabel(String text) {
        super(text);
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.BLUE);
        setFont(defaultFont);

        // allow component to be focusable
        setFocusable(true);

        // add focus adapter to change fints when focus is gained or lost (used
        // for transversing labels with keys)
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                super.focusGained(fe);
                if (isEnabled()) {
                    setFont(getHoverFont());
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                super.focusLost(fe);
                setFont(getDefaultFont());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

            }

            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);

                if (isEnabled()) {
                    setFont(getHoverFont());
                }
                // call for focus mouse is over this component
                requestFocusInWindow();
            }
        });

    }

    Font getDefaultFont() {
        return defaultFont;
    }

    Font getHoverFont() {
        return hoverFont;
    }
}

class PopUpJLabel2 extends JLabel {
    static int img = 1;
    static File f;
    static boolean ball = false;
    private static final long serialVersionUID = 1L;
    public final static Font defaultFont = new Font("Arial", Font.PLAIN, 50);
    public final static Font hoverFont = new Font("Arial", Font.BOLD, 70);
    static JFrame m = new JFrame("Single Player Mode");

    PopUpJLabel2(String text) {
        super(text);
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.BLUE);
        setFont(defaultFont);

        // allow component to be focusable
        setFocusable(true);

        // add focus adapter to change fints when focus is gained or lost (used
        // for transversing labels with keys)
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                super.focusGained(fe);
                if (isEnabled()) {
                    setFont(getHoverFont());
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                super.focusLost(fe);
                setFont(getDefaultFont());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {//вход из меню в игру
                super.mouseClicked(me);
                Main.frame.setVisible(false);

                JFrame f = new JFrame("STAR FIGHT");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(800, 800);

                f.add(new Space());
                f.setResizable(false);
                f.setLocationRelativeTo(null);
                f.setVisible(true);



            }

            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);

                if (isEnabled()) {
                    setFont(getHoverFont());
                }
                // call for focus mouse is over this component
                requestFocusInWindow();
            }
        });

    }

    Font getDefaultFont() {
        return defaultFont;
    }

    Font getHoverFont() {
        return hoverFont;
    }
}

class PopUpJLabel3 extends JLabel {
    private static final long serialVersionUID = 1L;
    public final static Font defaultFont = new Font("Arial", Font.PLAIN, 50);
    public final static Font hoverFont = new Font("Arial", Font.BOLD, 70);

    PopUpJLabel3(String text) {
        super(text);
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.BLUE);
        setFont(defaultFont);

        // allow component to be focusable
        setFocusable(true);

        // add focus adapter to change fints when focus is gained or lost (used
        // for transversing labels with keys)
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                super.focusGained(fe);
                if (isEnabled()) {
                    setFont(getHoverFont());
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                super.focusLost(fe);
                setFont(getDefaultFont());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

            }

            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);

                if (isEnabled()) {
                    setFont(getHoverFont());
                }
                // call for focus mouse is over this component
                requestFocusInWindow();
            }
        });

    }

    Font getDefaultFont() {
        return defaultFont;
    }

    Font getHoverFont() {
        return hoverFont;
    }
}



class PopUpJLabel4 extends JLabel {
    private static final long serialVersionUID = 1L;
    public final static Font defaultFont = new Font("Arial", Font.PLAIN, 50);
    public final static Font hoverFont = new Font("Arial", Font.BOLD, 70);

    PopUpJLabel4(String text) {
        super(text);
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.BLUE);
        setFont(defaultFont);

        // allow component to be focusable
        setFocusable(true);

        // add focus adapter to change fints when focus is gained or lost (used
        // for transversing labels with keys)
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                super.focusGained(fe);
                if (isEnabled()) {
                    setFont(getHoverFont());
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                super.focusLost(fe);
                setFont(getDefaultFont());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

            }

            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);

                if (isEnabled()) {
                    setFont(getHoverFont());
                }
                // call for focus mouse is over this component
                requestFocusInWindow();
            }
        });

    }

    Font getDefaultFont() {
        return defaultFont;
    }

    Font getHoverFont() {
        return hoverFont;
    }
}
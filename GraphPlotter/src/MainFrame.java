import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem addTab;
    private JTabbedPane tb;
    private int count = 1;
    private int windowX;
    private int windowY;

    public MainFrame() {
        windowX = ScreenDimensions.getScreenWidth();
        windowY = ScreenDimensions.getScreenHeight();

        tb = new JTabbedPane();
        setContentPane(tb);

        menuBar = new JMenuBar();

        menu = new JMenu("New");
        menu.setFont(new Font("Calibri", Font.BOLD, 18));

        addTab = new JMenuItem("Add new plot");
        addTab.setFont(new Font("Calibri", Font.BOLD, 18));
        addTab.addActionListener(e -> {
            String name = "Plot " + count++;
            tb.addTab(name, new GraphPanel(name));
        });
        addTab.setIcon(createScaledIcon(getClass().getResource("/images/plus.png")));

        menu.add(addTab);
        menuBar.add(menu);

        setJMenuBar(menuBar);

        setSize(windowX, windowY);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private ImageIcon createScaledIcon(URL imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}

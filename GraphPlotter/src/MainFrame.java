import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

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
        addTab = new JMenuItem("Add new plot");
        addTab.addActionListener(e -> {
            String name = "Plot " + count++;
            tb.addTab(name, new GraphPanel(name));
        });

        menu.add(addTab);
        menuBar.add(menu);

        setJMenuBar(menuBar);

        setSize(windowX, windowY);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

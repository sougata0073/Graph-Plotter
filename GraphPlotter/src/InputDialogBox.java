import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class InputDialogBox extends JDialog {

    private GraphPanel panel;

    private JTextField xCordsTf;
    private JTextField yCordsTf;
    private JTextField xScaleTf;
    private JTextField yScaleTf;
    private JLabel xCordsLabel;
    private JLabel yCordsLabel;
    private JLabel xScaleLabel;
    private JLabel yScaleLabel;

    private JButton enterButton;

    private ClickHandler clickHandler;

    public InputDialogBox(GraphPanel panel){

        setTitle("Inputs");

        this.panel = panel;

        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        Font font2 = new Font("Calibri", Font.BOLD, 25);

        this.xCordsTf = new JTextField(30);
        this.xCordsTf.setFont(font1);
        this.xCordsLabel = new JLabel("X axis co-ordinates");
        this.xCordsLabel.setFont(font2);

        this.yCordsTf = new JTextField(30);
        this.yCordsTf.setFont(font1);
        this.yCordsLabel = new JLabel("Y axis co-ordinates");
        this.yCordsLabel.setFont(font2);

        this.xScaleTf = new JTextField(10);
        this.xScaleTf.setFont(font1);
        this.xScaleLabel = new JLabel("X axis scale");
        this.xScaleLabel.setFont(font2);

        this.yScaleTf = new JTextField(10);
        this.yScaleTf.setFont(font1);
        this.yScaleLabel = new JLabel("Y axis scale");
        this.yScaleLabel.setFont(font2);

        this.enterButton = new JButton("Enter");
        this.enterButton.setFont(font2);

        this.clickHandler = new ClickHandler(this.panel, this);

        this.enterButton.addActionListener(this.clickHandler);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(xCordsLabel, gbc);
        gbc.gridy = 1;
        add(xCordsTf, gbc);
        gbc.gridy = 2;
        add(yCordsLabel, gbc);
        gbc.gridy = 3;
        add(yCordsTf, gbc);
        gbc.gridy = 4;
        add(xScaleLabel, gbc);
        gbc.gridy = 5;
        add(xScaleTf, gbc);
        gbc.gridy = 6;
        add(yScaleLabel, gbc);
        gbc.gridy = 7;
        add(yScaleTf, gbc);
        gbc.gridy = 8;
        add(enterButton, gbc);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public GraphDataModel getDataModel(){
        return this.clickHandler.getDataModel();
    }

    public String getxCordsString(){
        return this.xCordsTf.getText();
    }

    public String getyCordsString(){
        return this.yCordsTf.getText();
    }

    public String getxCordsScaleString(){
        return this.xScaleTf.getText();
    }

    public String getyCordsScaleString(){
        return this.yScaleTf.getText();
    }
}

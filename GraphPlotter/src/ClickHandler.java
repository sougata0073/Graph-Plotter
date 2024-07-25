import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickHandler implements ActionListener {

    private GraphDataModel dataModel;

    private GraphPanel panel;
    private InputDialogBox dialog;

    // X-axis start and end cords
    private int xAxisStartX;
    private int xAxisStartY;
    private int xAxisEndX;
    private int xAxisEndY;

    // Y-axis start and end cords
    private int yAxisStartX;
    private int yAxisStartY;
    private int yAxisEndX;
    private int yAxisEndY;

    // Length of X and Y axis lines
    private int xLength;
    private int yLength;

    // X and Y cords input string
    private String xCordsString;
    private String yCordsString;

    // X and Y co-ordinates array from user
    private float[] xCords;
    private float[] yCords;

    // X and Y cords scale input string
    private String xCordsScaleString;
    private String yCordsScaleString;

    // Scale densities
    private int xScaleDensity;
    private int yScaleDensity;

    // Max cord
    private float xMaxCord;
    private float yMaxCord;

    // Screen dimensions
    private int xScreen;
    private int yScreen;

    // Spacing
    private int spacingX;
    private int spacingY;

    public ClickHandler(GraphPanel panel, InputDialogBox dialog) {
        this.panel = panel;
        this.dialog = dialog;

        this.xScreen = ScreenDimensions.getScreenWidth();
        this.yScreen = ScreenDimensions.getScreenHeight();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.dataModel = new GraphDataModel();

        this.spacingX = dataModel.getSpacingX();
        this.spacingY = dataModel.getSpacingY();

        this.xCordsString = this.dialog.getxCordsString();
        this.yCordsString = this.dialog.getyCordsString();
        this.xCordsScaleString = this.dialog.getxCordsScaleString();
        this.yCordsScaleString = this.dialog.getyCordsScaleString();

        this.xCords = getXCords(this.xCordsString);
        if (this.xCords == null) return;

        this.yCords = getYCords(this.yCordsString);
        if (this.yCords == null) return;

        if(this.xCords.length != this.yCords.length){
            JOptionPane.showMessageDialog(this.panel, "Number of X and Y co-ordinates should be equal", "Unequal number of co-ordinates", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.xScaleDensity = getAxisScale(this.xCordsScaleString);
        if (this.xScaleDensity == -1) return;

        this.yScaleDensity = getAxisScale(this.yCordsScaleString);
        if (this.yScaleDensity == -1) return;

        this.xMaxCord = getArrMax(this.xCords);
        this.yMaxCord = getArrMax(this.yCords);

        // X-axis start and end co-ordinate calculation
        this.xAxisStartX = this.spacingX;
        this.xAxisStartY = this.yScreen - this.spacingY;
        this.xAxisEndX = this.xScreen - this.spacingX;
        this.xAxisEndY = this.yScreen - this.spacingY;

        // Y-axis start and end co-ordinate calculation
        this.yAxisStartX = this.spacingX;
        this.yAxisStartY = this.yScreen - this.spacingY;
        this.yAxisEndX = this.spacingX;
        this.yAxisEndY = this.spacingX;

        // X and Y axis lines length calculation
        this.xLength = this.xAxisEndX - this.xAxisStartX;
        this.yLength = this.yAxisStartY - this.yAxisEndY;

        // Setting up data model
        this.dataModel.setxScreen(this.xScreen);
        this.dataModel.setyScreen(this.yScreen);

        this.dataModel.setxCords(this.xCords);
        this.dataModel.setyCords(this.yCords);

        this.dataModel.setxScaleDensity(this.xScaleDensity);
        this.dataModel.setyScaleDensity(this.yScaleDensity);

        this.dataModel.setxMaxCords(this.xMaxCord);
        this.dataModel.setyMaxCords(this.yMaxCord);

        this.dataModel.setxAxisStartX(this.xAxisStartX);
        this.dataModel.setxAxisStartY(this.xAxisStartY);
        this.dataModel.setxAxisEndX(this.xAxisEndX);
        this.dataModel.setxAxisEndY(this.xAxisEndY);

        this.dataModel.setyAxisStartX(this.yAxisStartX);
        this.dataModel.setyAxisStartY(this.yAxisStartY);
        this.dataModel.setyAxisEndX(this.yAxisEndX);
        this.dataModel.setyAxisEndY(this.yAxisEndY);

        this.dataModel.setxLength(this.xLength);
        this.dataModel.setyLength(this.yLength);

        this.dialog.dispose();

        this.panel.repaint();
    }

    public GraphDataModel getDataModel() {
        return this.dataModel;
    }

    private float[] getXCords(String xCordsString) {
        if (xCordsString.isEmpty()) {
            JOptionPane.showMessageDialog(this.panel, "This field cannot be empty", "Empty input field", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String[] xArrString = xCordsString.split("\\s*,\\s*");
        float[] xCords = new float[xArrString.length];
        for (int i = 0; i < xCords.length; i++) {
            try {
                xCords[i] = Float.parseFloat(xArrString[i]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.panel, "Enter valid X co-ordinates", "Wrong input field", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return xCords;
    }

    public float[] getYCords(String yCordsString) {
        if (yCordsString.isEmpty()) {
            JOptionPane.showMessageDialog(this.panel, "This field cannot be empty", "Empty input field", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String[] yArrString = yCordsString.split("\\s*,\\s*");
        float[] yCords = new float[yArrString.length];
        for (int i = 0; i < yCords.length; i++) {
            try {
                yCords[i] = Float.parseFloat(yArrString[i]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.panel, "Enter valid Y co-ordinates", "Wrong input field", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return yCords;
    }

    public int getAxisScale(String scaleString) {
        if (scaleString.isEmpty()) {
            JOptionPane.showMessageDialog(this.panel, "This field cannot be empty", "Empty input field", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        int scale = 0;

        try {
            scale = Integer.parseInt(scaleString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.panel, "Enter valid scale", "Empty input field", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return scale;
    }

    private float getArrMax(float[] arr) {
        float max = arr[0];
        for (float i : arr) {
            if (max < i) max = i;
        }
        return max;
    }
}


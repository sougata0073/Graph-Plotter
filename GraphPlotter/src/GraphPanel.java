import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GraphPanel extends JPanel {

    private InputDialogBox inputDialogBox;

    private GraphDataModel dataModel;

    public GraphPanel(String name) {
        setName(name);
        this.inputDialogBox = new InputDialogBox(this);
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.dataModel = this.inputDialogBox.getDataModel();

        if (this.dataModel == null) {
            return;
        }

        // Drawing X and Y axis lines
        g.setColor(Color.BLACK);
        g.drawLine(this.dataModel.getxAxisStartX(), this.dataModel.getxAxisStartY(), this.dataModel.getxAxisEndX(), this.dataModel.getxAxisEndY());
        g.drawLine(this.dataModel.getyAxisStartX(), this.dataModel.getyAxisStartY(), this.dataModel.getyAxisEndX(), this.dataModel.getyAxisEndY());

        // Drawing X-axis dividing dots and dot values
        drawDividingDotsX(g, this.dataModel);

        // Drawing X-axis dividing dots and dot values
        drawDividingDotsY(g, this.dataModel);

        // Plotting values
        plotValues(g, this.dataModel);
    }

    private void drawDividingDotsX(Graphics g, GraphDataModel dataModel) {
        int dotDiameter = dataModel.getDotDiameter();
        int halfDot = dotDiameter / 2;
        int perDiv = dataModel.getxLength() / dataModel.getxScaleDensity();
        float dotVal = dataModel.getxMaxCords() / dataModel.getxScaleDensity();

        String dotValString;
        int xDot;
        int yDot = dataModel.getxAxisStartY() - halfDot;

        int dotValSpacing;

        g.setColor(Color.RED);

        for (int i = 0; i <= dataModel.getxScaleDensity(); i++) {
            xDot = dataModel.getxAxisStartX() + (perDiv * i) - halfDot;
            g.fillOval(xDot, yDot, dotDiameter, dotDiameter);

            if (i % 2 == 0) dotValSpacing = 20;
            else dotValSpacing = 30;

            dotValString = String.format("%.2f", dotVal * i);
            g.drawString(dotValString, xDot - 5, yDot + dotValSpacing);
        }
    }

    private void drawDividingDotsY(Graphics g, GraphDataModel dataModel) {
        int dotDiameter = dataModel.getDotDiameter();
        int halfDot = dotDiameter / 2;
        int perDiv = dataModel.getyLength() / dataModel.getyScaleDensity();
        float dotVal = dataModel.getyMaxCords() / dataModel.getyScaleDensity();

        String dotValString;
        int xDot = dataModel.getyAxisStartX() - halfDot;
        int yDot;

        g.setColor(Color.RED);

        for (int i = 0; i <= dataModel.getyScaleDensity(); i++) {
            yDot = dataModel.getyAxisStartY() - (perDiv * i) - halfDot;
            g.fillOval(xDot, yDot, dotDiameter, dotDiameter);

            dotValString = String.format("%.2f", dotVal * i);
            g.drawString(dotValString, xDot - 35, yDot + 9);
        }
    }

    private void plotValues(Graphics g, GraphDataModel dataModel) {
        int dotDiameter = dataModel.getDotDiameter();
        int halfDot = dotDiameter / 2;
        float[] xCords = dataModel.getxCords();
        float[] yCords = dataModel.getyCords();
        int spacingX = dataModel.getSpacingX();
        int yLength = dataModel.getyLength();

        int arrLength = xCords.length;
        float singleDivX = dataModel.getxLength() / dataModel.getxMaxCords();
        float singleDivY = dataModel.getyLength() / dataModel.getyMaxCords();
        int xDot;
        int yDot;

        int[] cordsLocationX = new int[arrLength];
        int[] cordsLocationY = new int[arrLength];

        g.setColor(Color.RED);

        for (int i = 0; i < arrLength; i++) {
            xDot = (int) (singleDivX * xCords[i] + spacingX - halfDot);
            yDot = (int) (yLength - singleDivY * yCords[i] + spacingX - halfDot);

            cordsLocationX[i] = xDot;
            cordsLocationY[i] = yDot;

            g.fillOval(xDot, yDot, dotDiameter, dotDiameter);
        }

        g.setColor(Color.BLACK);

        for (int i = 0; i < arrLength - 1; i++) {
            g.drawLine(cordsLocationX[i] + halfDot,
                    cordsLocationY[i] + halfDot,
                    cordsLocationX[i + 1] + halfDot,
                    cordsLocationY[i + 1] + halfDot);
        }
    }
}

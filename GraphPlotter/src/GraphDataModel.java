import java.util.Arrays;

public class GraphDataModel {
    private final int spacingX = 80;
    private final int spacingY = 200;
    private final int dotDiameter = 8;

    private float[] xCords;
    private float[] yCords;

    private int xScreen;
    private int yScreen;

    private int xScaleDensity;
    private int yScaleDensity;

    private float xMaxCords;
    private float yMaxCords;

    private int xAxisStartX;
    private int xAxisStartY;
    private int xAxisEndX;
    private int xAxisEndY;

    private int yAxisStartX;
    private int yAxisStartY;
    private int yAxisEndX;
    private int yAxisEndY;

    private int xLength;
    private int yLength;

    public GraphDataModel(){

    }

    public int getSpacingX() {
        return this.spacingX;
    }

    public int getSpacingY() {
        return this.spacingY;
    }

    public int getDotDiameter() {
        return this.dotDiameter;
    }

    public float[] getxCords() {
        return xCords;
    }

    public void setxCords(float[] xCords) {
        this.xCords = xCords;
    }

    public float[] getyCords() {
        return yCords;
    }

    public void setyCords(float[] yCords) {
        this.yCords = yCords;
    }

    public int getxScreen() {
        return xScreen;
    }

    public void setxScreen(int xScreen) {
        this.xScreen = xScreen;
    }

    public int getyScreen() {
        return yScreen;
    }

    public void setyScreen(int yScreen) {
        this.yScreen = yScreen;
    }

    public int getxScaleDensity() {
        return xScaleDensity;
    }

    public void setxScaleDensity(int xScaleDensity) {
        this.xScaleDensity = xScaleDensity;
    }

    public int getyScaleDensity() {
        return yScaleDensity;
    }

    public void setyScaleDensity(int yScaleDensity) {
        this.yScaleDensity = yScaleDensity;
    }

    public float getxMaxCords() {
        return xMaxCords;
    }

    public void setxMaxCords(float xMaxCords) {
        this.xMaxCords = xMaxCords;
    }

    public float getyMaxCords() {
        return yMaxCords;
    }

    public void setyMaxCords(float yMaxCords) {
        this.yMaxCords = yMaxCords;
    }

    public int getxAxisStartX() {
        return xAxisStartX;
    }

    public void setxAxisStartX(int xAxisStartX) {
        this.xAxisStartX = xAxisStartX;
    }

    public int getxAxisStartY() {
        return xAxisStartY;
    }

    public void setxAxisStartY(int xAxisStartY) {
        this.xAxisStartY = xAxisStartY;
    }

    public int getxAxisEndX() {
        return xAxisEndX;
    }

    public void setxAxisEndX(int xAxisEndX) {
        this.xAxisEndX = xAxisEndX;
    }

    public int getxAxisEndY() {
        return xAxisEndY;
    }

    public void setxAxisEndY(int xAxisEndY) {
        this.xAxisEndY = xAxisEndY;
    }

    public int getyAxisStartX() {
        return yAxisStartX;
    }

    public void setyAxisStartX(int yAxisStartX) {
        this.yAxisStartX = yAxisStartX;
    }

    public int getyAxisStartY() {
        return yAxisStartY;
    }

    public void setyAxisStartY(int yAxisStartY) {
        this.yAxisStartY = yAxisStartY;
    }

    public int getyAxisEndX() {
        return yAxisEndX;
    }

    public void setyAxisEndX(int yAxisEndX) {
        this.yAxisEndX = yAxisEndX;
    }

    public int getyAxisEndY() {
        return yAxisEndY;
    }

    public void setyAxisEndY(int yAxisEndY) {
        this.yAxisEndY = yAxisEndY;
    }

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    @Override
    public String toString() {
        return "GraphDataModel{" +
                "spacingX=" + spacingX +
                "spacingY=" + spacingY +
                ", dotDiameter=" + dotDiameter +
                ", xCords=" + Arrays.toString(xCords) +
                ", yCords=" + Arrays.toString(yCords) +
                ", xScreen=" + xScreen +
                ", yScreen=" + yScreen +
                ", xScaleDensity=" + xScaleDensity +
                ", yScaleDensity=" + yScaleDensity +
                ", xMaxCords=" + xMaxCords +
                ", yMaxCords=" + yMaxCords +
                ", xAxisStartX=" + xAxisStartX +
                ", xAxisStartY=" + xAxisStartY +
                ", xAxisEndX=" + xAxisEndX +
                ", xAxisEndY=" + xAxisEndY +
                ", yAxisStartX=" + yAxisStartX +
                ", yAxisStartY=" + yAxisStartY +
                ", yAxisEndX=" + yAxisEndX +
                ", yAxisEndY=" + yAxisEndY +
                ", xLength=" + xLength +
                ", yLength=" + yLength +
                '}';
    }
}

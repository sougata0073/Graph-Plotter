import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class ScreenDimensions {
    private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static GraphicsDevice[] screens = ge.getScreenDevices();
    private static DisplayMode mode = screens[0].getDisplayMode();

    public static int getScreenWidth() {
        return mode.getWidth();
    }

    public static int getScreenHeight() {
        return mode.getHeight();
    }
}

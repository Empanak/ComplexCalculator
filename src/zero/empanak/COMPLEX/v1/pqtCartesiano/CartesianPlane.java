package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;

public class CartesianPlane extends JPanel {
    private static Graphics2D cartesianPlane;
    private static Color color = new Color(Constants.xy_AxisColor.getRGB());
    public void create(Graphics g, int width, int height){
        cartesianPlane = (Graphics2D) g;
        cartesianPlane.setColor(color);
        cartesianPlane.drawLine(0, height/2, width, height/2);
        cartesianPlane.drawLine(width/2, 0, width/2, height);
    }
}

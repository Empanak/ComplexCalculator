package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JPanel;

public class Background extends JPanel {
    private static Graphics2D bg;
    private static Color color = new Color(Constants.bgColor.getRGB());
    public void create(Graphics g, int width, int height){
        bg = (Graphics2D) g; //Casteo
        bg.setPaint(color);
        bg.fill(new Rectangle(width, height));
    }
}
package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.*;
import javax.swing.JPanel;

import zero.empanak.COMPLEX.v1.pqt1.Complex;

public class ComplexDraw extends JPanel {
    private static Graphics2D complexDraw;
    private static Graphics2D textDraw;

    private double x, y;

    public void create(Graphics g, int width, int height, Complex z){
        Color color = new Color(Constants.complexColor.getRGB());
        int quantity = Constants.getQuantityPoints(z.getA(), z.getB());

        x = (double) width / 2 + (z.getA() * ((double) width / quantity));
        y = (double) height / 2 - (z.getB() * ((double) height / quantity));

        complexDraw = (Graphics2D) g;
        complexDraw.setStroke(new BasicStroke(2));
        complexDraw.setColor(color);

        complexDraw.drawLine(width/2, height/2, (int) x, (int) y);
        complexDraw.fillOval((int) x - Constants.POINTSIZE/2, (int) y - Constants.POINTSIZE/2, Constants.POINTSIZE, Constants.POINTSIZE);
        complexDraw.drawArc(width/2-30, height/2-30,
                            60, 60,
                            0, (int)z.argument());

        createText(g, width, height, z);
    }

    public void createText(Graphics g, int width, int height, Complex z){
        textDraw = (Graphics2D) g;
        textDraw.setColor(Constants.textColor);
        textDraw.setFont(new Font("Arial", Font.ITALIC, 15));
        textDraw.drawString(String.format("%.2f °", z.argument()), width/2+35, height/2-15);

        int quadrant = z.quadrant();
        if(quadrant == 1 || quadrant == 4)
            textDraw.drawString(z.show(), (int) x + 10, (int) y + 5);
        if(quadrant == 2 || quadrant == 3)
            textDraw.drawString(z.show(), (int) x - z.show().length()*5 - 5, (int) y + 5);
        if(quadrant == 0)
            textDraw.drawString(z.show(), (int) x + 10, (int) y - 15);
    }
}
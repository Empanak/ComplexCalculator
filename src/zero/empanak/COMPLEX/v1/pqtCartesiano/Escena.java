package zero.empanak.COMPLEX.v1.pqtCartesiano;

import zero.empanak.COMPLEX.v1.pqt1.Complex;

import java.awt.*;
import javax.swing.*;

public class Escena extends JPanel {

    private static Complex z;

    public Escena(){}
    @Override
    public void paintComponent(Graphics g){
        Background bg = new Background();
        CartesianPlane cartesianPlane = new CartesianPlane();
        Coordinates coordinates = new Coordinates();
        ComplexDraw complexDraw = new ComplexDraw();
        Buttons buttons = new Buttons();
        repaint();

        bg.create(g, this.getWidth(), this.getHeight());
        cartesianPlane.create(g, this.getWidth(), this.getHeight());
        coordinates.create(g, this.getWidth(), this.getHeight(), z.getA(), z.getB());
        complexDraw.create(g, this.getWidth(), this.getHeight(), z);
        buttons.create(g, this.getWidth(), this.getHeight());

    }

    protected void setZ(Complex z){
        Escena.z = z;
    }
}

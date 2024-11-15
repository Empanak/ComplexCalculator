package zero.empanak.COMPLEX.v1.pqtCartesiano;

import zero.empanak.COMPLEX.v1.pqt1.Complex;

import javax.swing.*;
import java.awt.*;

public class MenuGraph extends JFrame {

    static Escena escena = new Escena();
    public MenuGraph(){
        super("Forma Gráfica - Complex");
        add(escena, BorderLayout.CENTER);
        JButton angle = new JButton("Angle");
    }

    protected void setZ(Complex z){
        escena.setZ(z);
    }
}

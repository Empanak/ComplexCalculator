package zero.empanak.COMPLEX.v1.pqtCartesiano;

import zero.empanak.COMPLEX.v1.pqt1.Complex;

import javax.swing.*;
import java.util.Scanner;

public class Canva{

    private static Complex z;

    //Cracion frame principal
    public static void createFrame(){
        Scanner scan = new Scanner(System.in);
        MenuGraph frame = new MenuGraph();
        frame.setZ(z);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    //Control de elementos swing (seguridad de hilos)
    public static void controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                createFrame();
            }
        });
    }

    public void setZ(Complex z) {
        Canva.z = z;
    }
}
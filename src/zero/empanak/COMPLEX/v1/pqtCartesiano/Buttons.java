package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Buttons extends JButton {
    private static Graphics2D buttons;
    Color color = new Color(Constants.buttonColor.getRGB());
    //JButton angle = new JButton("Angle");

    public void create(Graphics g, int width, int height) {
        buttons = (Graphics2D) g;
        JButton angle = new JButton("Angle");
        //angle.setBackground(Constants.buttonColor);
        angle.setBounds(20, 20, 100, 30);
        /*angle.setFont(new Font("Arial", Font.BOLD, 20));
        angle.setVisible(true);*/

        add(angle);

    }

}

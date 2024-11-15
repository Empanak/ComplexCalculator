package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;

public class Coordinates extends JPanel {
    private static Graphics2D coordinates;
    private static Color color = Constants.xy_AxisColor;

    public void create(Graphics g, int width, int height, double a, double b){

        int quantity = Constants.getQuantityPoints(a, b);
        double addCoord = 1;
        boolean isAlterated = false;
        if(quantity>30) {
            addCoord = (double) (quantity / 2) / 15;
            isAlterated = true;
            quantity = 30;
        }

        int bound = (width / (width /quantity)), space = width / quantity;
        double valueCoordinate = 0;
        coordinates = (Graphics2D) g;
        coordinates.setColor(color);

        //ZeroPoint
        coordinates.fillOval((width/2)-(Constants.POINTSIZE/2), (height/2)-(Constants.POINTSIZE/2), Constants.POINTSIZE, Constants.POINTSIZE);

        //Right Side
        for(int i=0; i<bound; i++){
            coordinates.fillOval((width/2) - Constants.POINTSIZE/2 + space, (height/2) - (Constants.POINTSIZE/2), Constants.POINTSIZE, Constants.POINTSIZE);
            coordinates.fillOval((width/2) - (Constants.POINTSIZE/2), (height/2) - (Constants.POINTSIZE/2) + space, Constants.POINTSIZE, Constants.POINTSIZE);

            String coordStr = String.format("%.0f", valueCoordinate+addCoord);

            coordinates.drawString(coordStr, (width/2) - (Constants.POINTSIZE/2) + space, (height/2) + (Constants.POINTSIZE*3));
            coordinates.drawString('-' + coordStr, (width/2) - (Constants.POINTSIZE*3), (height/2) + (Constants.POINTSIZE/2) + space);

            if(isAlterated){
                valueCoordinate+=addCoord;
            }else
                valueCoordinate++;

            space += width / quantity;
        }

        //Left Side
        space = width / quantity;
        valueCoordinate = 0;
        for(int i=bound; i>0; i--){
            coordinates.fillOval((width/2) - (Constants.POINTSIZE/2) - space, (height/2) - (Constants.POINTSIZE/2), Constants.POINTSIZE, Constants.POINTSIZE);
            coordinates.fillOval((width/2) - (Constants.POINTSIZE/2), (height/2) - (Constants.POINTSIZE/2) - space, Constants.POINTSIZE, Constants.POINTSIZE);

            String coordStr = String.format("%.0f", valueCoordinate+addCoord);

            coordinates.drawString('-' + coordStr, (width/2) - (Constants.POINTSIZE/2) - space, (height/2) + (Constants.POINTSIZE*3));
            coordinates.drawString(coordStr, (width/2) - (Constants.POINTSIZE*3), (height/2) + (Constants.POINTSIZE/2) - space);

            if(isAlterated){
                valueCoordinate+=addCoord;
            }else
                valueCoordinate++;

            space += width / quantity;
        }
    }
}
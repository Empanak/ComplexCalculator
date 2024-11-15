package zero.empanak.COMPLEX.v1.pqtCartesiano;

import java.awt.Color;

abstract class Constants {
    public static int
            WIDTH = 800,
            HEIGHT = 800,
            POINTSIZE = 6;
    //public static Color bgColor = new Color(167, 170, 156);
    public static Color bgColor = new Color(208, 208, 208);
    public static Color xy_AxisColor = new Color(0, 0, 0);
    public static Color complexColor = new Color(51, 147, 220);
    public static Color textColor = new Color(0, 0, 0);
    public static Color buttonColor = new Color(70, 70, 70);

    public static int getQuantityPoints(double a, double b){
        double max = Math.max(a,b);

        int addXSpaces = String.valueOf((int)max).length();

        String spaces = "1"+"0".repeat(addXSpaces);
        addXSpaces = (Integer.parseInt(spaces)/10 + (int)max)*2;

        return addXSpaces;
    }
}
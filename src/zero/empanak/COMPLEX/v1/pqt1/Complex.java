package zero.empanak.COMPLEX.v1.pqt1;

import java.lang.Math;

public class Complex {

    private double a;
    private double b;

    public Complex(){
        this.a = 0;
        this.b = 0;
    }
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public int quadrant(){
        if(this.a > 0 && this.b > 0)
            return 1;
        if(this.a < 0 && this.b > 0)
            return 2;
        if(this.a < 0 && this.b < 0)
            return 3;
        if(this.a > 0 && this.b < 0)
            return 4;
        return 0;
    }

    public String show(){
        if(b<0&&a<0)
            return ("z= - " + Math.abs(a) + " - " + Math.abs(b) +'i');
        else if(a==0&&b!=0)
            return ("z= "+b+'i');
        else if(a<0 && b==0)
            return ("z= - "+ (-a));
        else if(b<0 && a>0)
            return ("z= " + a + " - " + Math.abs(b) + 'i');
        else if(a<0 && b>0)
            return ("z= - " + Math.abs(a) + " + " + b + 'i');
        else if(b==0)
            return ("z= "+a);
        else
            return ("z= "+a+" + "+b+'i');
    }

    public Complex addition(Complex z){
        return new Complex(this.a + z.a, this.b + z.b);
    }

    public Complex subtraction(Complex z){
        return new Complex(this.a - z.a, this.b - z.b);
    }

    public Complex multiplication(Complex z){
        return new Complex(this.a * z.a - this.b * z.b, this.a * z.b + this.b * z.a);
    }

    public Complex division (Complex z){
        Complex temp = this.multiplication(z.conjugate()); //num * den conjugado
        double divTemp = z.multiplication(z.conjugate()).a; //den * den conjugado

        return new Complex((temp.a/divTemp), (temp.b/ divTemp));
    }

    public Complex conjugate(){
        return new Complex(this.a, -this.b);
    }

    public double modulus(){
        return (Math.sqrt(Math.pow(this.a, 2)+Math.pow(this.b, 2)));
    }

    public double argument(){
        if(this.a > 0 && this.b > 0) {
            return Math.toDegrees(Math.atan((this.b / this.a)));
        }else if((this.a < 0 && this.b > 0 ) || (this.a < 0 && this.b <0)){
            return 180 + Math.toDegrees(Math.atan(this.b / this.a));
        }else if(this.a > 0 && this.b < 0){
            return 360 + Math.toDegrees(Math.atan(this.b / this.a));
        }
        if(this.a==0 && this.b>0){
            return 90;
        }
        if(this.a==0 && this.b<0){
            return 270;
        }
        if(this.a<0){
            return 180;
        }
        return 0;
    }
}
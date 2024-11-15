package zero.empanak.COMPLEX.v1.pqt1;

import java.util.InputMismatchException;
import java.util.Scanner;
import zero.empanak.COMPLEX.v1.pqtCartesiano.Canva;

@SuppressWarnings("WriteOnlyObject")
public class Menu {

    private Complex save = new Complex();

    public void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        int opcion;
        boolean flag = false;

        while(!flag) {

            System.out.println("\n*** COMPLEX MENU ***");
            System.out.println("1. Operaciones con Complejos");
            System.out.println("2. Salir");

            try {
                System.out.print("\nIngrese una opcion: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        opLoader();
                        System.out.println("1. Modulo-Argumento\n2. Polar-Exponencial\n3. Graficar!\n4. Salir");
                        close:
                        while (true) {
                            System.out.print("Ingrese una opcion: ");
                            opcion = scan.nextInt();
                            switch (opcion) {
                                case 1:
                                    System.out.println("El modulo de z = es: " + save.modulus() + 'u');
                                    System.out.println("El argumento de z es: " + save.argument() + "°");
                                    break;
                                case 2:
                                    System.out.println("Forma polar: " + save.modulus() + " Cis " + save.argument() + "°");
                                    System.out.println("Forma exponencial: " + save.modulus() + " e ^ " + Math.toRadians(save.argument()) + "i");
                                    break;
                                case 3:
                                    graphicater();
                                    break;
                                case 4:
                                    break close;
                                default:
                                    System.out.println("Opciones del 1 al 4.");
                                    break;
                            }
                        }
                        break;
                    case 2:
                        flag = true;
                        System.out.println("bai.");
                        break;
                    default:
                        System.out.println("Opciones del 1 al 2.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa solo numeros.\n");
                scan.next();
            }
        }//WHILE
    }

    public void opLoader(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Si deseas usar un valor anterior escribe (ans)");
        System.out.print("Ingrese la(s) operacion(es): ");
        save = OpLoader.calculate(scan.nextLine(), save);
        System.out.println(save.show());
    }

    public void graphicater(){
        Canva canva = new Canva();
        canva.setZ(save);
        Canva.controller();
    }

}
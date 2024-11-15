package zero.empanak.COMPLEX.v1.pqt1;
import java.util.Stack;
import java.util.regex.Pattern;

/***************************************************+
 * Mecanismo de convertido String -> Operaciones
 * 2 día hasta el momento
 * Ojalá funcione papa Dio'
 */

abstract class OpLoader {

    public static Complex calculate(String s, Complex ans) {
        Stack<Complex> complexStack= new Stack<>();
        Complex result;

        s = s.replace(" ", "");
        s = "(" + s + ")";

        if(s.charAt(s.length()-1) == ')' && s.charAt(0) != '(')
            throw new IllegalArgumentException("Syntax Error: Check parenthesis");

        boolean isNotComplex;
        for (int i = 0; i < s.length(); i++) {

            isNotComplex = false;
            boolean isConjugate = false;
            if(s.charAt(i) == ')'){
                int back = i;
                boolean twoPartComplex = false;
                boolean ansComplex = false;
                while(s.charAt(back) != '('){
                    try {
                        if (s.substring(back, back + 3).equals("ans")) {
                            ansComplex = true;
                            break;
                        }
                    }catch (StringIndexOutOfBoundsException ignored){}
                    back--;
                    if(back < 0){
                        throw new IllegalArgumentException("Syntax Error: Check parenthesis");
                    }
                    if(s.charAt(back) == 'c'){
                        isNotComplex = true;
                        break;
                    }
                    if(s.charAt(back) == '*' || s.charAt(back) == '/'){
                        throw new NumberFormatException("Syntax Error: Invalid Complex Number");
                    }
                    if((s.charAt(back) == '+' || s.charAt(back) == '-') && Character.isDigit(s.charAt(back-1))){ //Verificar que hayan 2 partes
                        twoPartComplex = true;
                    }
                }
                if(ansComplex){
                    s = s.replaceFirst("ans", "c");
                    complexStack.push(ans);
                    i = i - 3;
                    continue;
                }

                try {
                    if (s.charAt(back - 1) == '|')
                        isConjugate = true;
                } catch (StringIndexOutOfBoundsException ignored){}

                if(!isNotComplex) {//Cuando encuentro grupos convertidos / leídos


                    String part = "";
                    Complex zSave = new Complex();
                    if (twoPartComplex) {
                        for (int j = back + 1; j < i; j++) { //Leer un numero complejo de dos partes
                            if (s.charAt(j) == '*' || s.charAt(j) == '/') {
                                throw new IllegalArgumentException("Syntax Error: Invalid Complex Number");
                            }
                            if ((s.charAt(j) == '+' || s.charAt(j) == '-')&&(j!=back+1)) {
                                zSave.setA(Double.parseDouble(part));
                                part = String.valueOf(s.charAt(j));
                                //part = s.charAt(j) + "";
                                continue;
                            }
                            if (s.charAt(j) == 'i') {
                                zSave.setB(Double.parseDouble(part));
                                continue;
                            }
                            part += s.charAt(j);
                        }
                    } else {
                        for (int j = back + 1; j < i; j++) {
                            if (s.charAt(j) == 'i') {
                                zSave.setB(Double.parseDouble(part));
                                zSave.setA(0);
                                break;
                            }
                            part += s.charAt(j); //Aki por cuestion de logica, nse, tengo sueño (Ya no tengo sueño, es para que sume hasta el último número)
                            if (j == i - 1) {
                                zSave.setA(Double.parseDouble(part));
                                zSave.setB(0);
                                break;
                            }
                        }
                    }
                    int temp = (s.substring(back, i + 1).length());
                    s = s.replaceFirst(Pattern.quote(s.substring(back, i + 1)), "c"); //ERROR ....... Solucionado :))
                    i = i - temp + 1; // +1 para compensar el índice 0 //Igualo a 'i' pq si pongo i-= temp+1 el +1 se hace negativo, aunq igual jala con i-= temp-1 para compensar
                    //TERMINA DE LEER COMPLEJO
                    if(isConjugate)
                        complexStack.push(zSave.conjugate());
                    else
                        complexStack.push(zSave);

                }
            }

            if(isNotComplex){
                int back = i;

                while(s.charAt(back) != '('){
                    back--;
                    if(back < 0){
                        throw new IllegalArgumentException("Syntax Error: Check parenthesis");
                    }
                }
                for(int j = back + 1; j < i; j++) {
                    if (s.charAt(j) == 'c' && s.charAt(j + 1) == 'c')
                        throw new IllegalArgumentException("Syntax Error: Missing operators");

                    if (s.charAt(j) == '+'){
                        result = complexStack.pop().addition(complexStack.pop());
                        complexStack.push(result);
                    }
                    if (s.charAt(j) == '-'){
                        result = complexStack.pop();
                        result = complexStack.pop().subtraction(result);
                        complexStack.push(result);
                    }
                    if(s.charAt(j) == '*'){
                        result = complexStack.pop().multiplication(complexStack.pop());
                        complexStack.push(result);
                    }
                    if(s.charAt(j) == '/') {
                        result = complexStack.pop();
                        result = complexStack.pop().division(result);
                        complexStack.push(result);
                    }
                }
                //s = s.replace(s.substring(back, i + 1), "c");
                int temp = (s.substring(back, i + 1).length());
                s = s.replaceFirst(Pattern.quote(s.substring(back, i + 1)), "c");//ERROR ....... Solucionado :))
                i = i - temp + 1;
            }

        }

        return complexStack.peek();
    }
}
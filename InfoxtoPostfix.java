import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// //Universidad del Valle de Guatemala
// //Algoritmos y Estructura de Datos
// //Catedrático Douglas Barrios
// //Primer Semestre 2022
// //José Daniel Gómez Cabrera 21429
// //Jorge Fernando Adrino Menéndez 21616
// //Juan Pablo Cordón Cotero 21458
// //Sección 41
// //Actividad: HT4

public class InfoxtoPostfix {

    private static int preced(String ch){
        if(ch.equals("+") || ch.equals("-")){
            return 1;
        }else if(ch.equals("*") || ch.equals("/")){
            return 2;
        }else if( ch.equals("^")){
            return 3;
        }else{
            return 0;
        }
    }

    public String translate(String infix) {
        int type = 1;
        FactoryStack<String> factory = new FactoryStack<String>();
        iStack<String> stack = factory.returnStackType(type);
        
        stack.add("#");
        String[] arr = infix.split(" ");
        String postfix = "";
        for (String ch : arr) {
            if((Character.isLetterOrDigit(ch.charAt(0)))){
                postfix += ch+" ";      //agrega digitos o letras al string
            }
            else if(ch.equals(" ")){
            }
            else if(ch.equals("(")){
                stack.add(ch);      //agrega parentesis al stack
            }
            else if(ch.equals("^")){
                stack.add(ch);
            }
            else if(ch.equals(")")){
                while(!stack.peek().equals("#") && !stack.peek().equals("(")){
                    postfix += stack.remove()+" ";     //cuando encuentra ")" agrega al string hasta
                }                               //      encuentra "("
                stack.remove();        //elimina "(" del stack
            }
            else {
                if(preced(ch)>preced(stack.peek())){
                    stack.add(ch);     //lo guarda en el stack si es mayor la                                        
                }                       //      precedencia del operador
                else{
                    while(!stack.peek().equals("#") && (preced(ch) <= preced(stack.peek()))){
                        postfix += stack.remove()+" ";
                    }
                    stack.add(ch);
                }
            }       
        }

            while(!stack.peek().equals("#")){
                postfix += stack.remove()+" ";
            }
        return postfix;
    }

    @Test
    //Prueba para demostrar que la calculadora funciona correctamente
    public void testCalculate(){
        assertEquals("3 4 + 8 * ", translate("( 3 + 4 ) * 8"));
        assertEquals("7 6 + 9 + 7 2 ^ - ", translate("7 + 6 + 9 - 7 ^ 2"));
        assertEquals("4 8 / 9 x ^ 6 * + ", translate("4 / 8 + 9 ^ x * 6 "));
        assertEquals("4 x * 8 + 2 * ", translate("( 4 * x + 8 ) * 2"));
        assertEquals("A B + C D + * ", translate("( A + B ) * ( C + D )"));
    }
    
}

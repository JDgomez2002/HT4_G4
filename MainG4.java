// //Universidad del Valle de Guatemala
// //Algoritmos y Estructura de Datos
// //Catedrático Douglas Barrios
// //Primer Semestre 2022
// //José Daniel Gómez Cabrera 21429
// //Jorge Fernando Adrino Menéndez 21616
// //Juan Pablo Cordón Cotero 21458
// //Sección 41
// //Actividad: HT4

import java.io.File;
import java.util.*;

import javax.naming.spi.InitialContextFactoryBuilder;

import java.time.LocalTime;

/**
 * Main del grupo 4
 */

public class MainG4{
    public static void main(String[] args) {   

        Vista v = new Vista();

        v.bienvenida();
        int stacktype = v.getStackType();

        PostfixCalculator calculadora = new PostfixCalculator();
        InfoxtoPostfix convertor = new InfoxtoPostfix();

        // String infix = "( 2 + 3 ) * ( 5 + 1 )";
        // String postfix = convertor.translate(infix);

        String infix;
        String postfix;
        double resultado;

        boolean continuar = true;
        while(continuar){
            infix = v.getInfixExpression();
            postfix = convertor.translate(infix);
            System.out.println("Infix: "+infix);
            System.out.println("Postfix: "+postfix);

            resultado = calculadora.calculate(postfix, stacktype);

            System.out.println("Resultado: "+resultado);
            System.out.println("---------------------------------------------");

            continuar = v.seguir_covirtiendo();
        }

        // System.out.println("Infix: "+infix);
        // System.out.println("Postfix: "+postfix);
        
        // double resultado = calculadora.calculate(postfix, stacktype);

        // System.out.println();
        // System.out.println("Resultado: "+resultado);
        
        v.despedida();
    }
}

//---------------------------------------------------------------------------------------------------------------------
//
//VISTA
//
//---------------------------------------------------------------------------------------------------------------------

class Vista{

    private Scanner scan = new Scanner(System.in);
    private int numero_de_resultados = 0;

    private int solicitar_int(String s, int inferior, int superior){
        inferior -= 1;
        superior += 1;
        int entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if((numero>inferior)&&(numero<superior)){
                    entero = numero;
                    System.out.println("---------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un entero valido.");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero valido.");
                    System.out.println();
                }
            }
        
        return entero;
    }

    private String solicitar_string(String s){
        String txt = "";
        boolean continuar = true;
        try{
            System.out.println(s);
            while(continuar){
                this.scan = new Scanner(System.in);
                String texto = scan.nextLine();
                if(texto.equals("")){
                    System.out.println("\t Error: debe de ingresar un texto valido.");
                }
                else{
                    txt = texto;
                    System.out.println("---------------------------------------------");
                    continuar = false;                   
                }
            }
        }
        catch(Exception e){
            System.out.println("\t Error: debe de ingresar un texto valido.");
        }
        return txt;
    }

    public int getStackType(){
        int type = 0;
        System.out.println("Primero dinos con cual instancia de Stack deseas iniciar...");
        System.out.println("1. VectorStack");
        System.out.println("2. ArrayListStack");
        System.out.println("3. Single Linked List Stack");
        System.out.println("4. Double Linked List Stack");
        String s  = "Ingresa la implementacion de Stack que desees: ";
        type = solicitar_int(s, 1, 4);
        return type;
    }

    public String getInfixExpression(){
        String s = "";
        System.out.println();
        System.out.println("Ingresa tu expresion Infix para traducirla a Postfix y posteriormente obtener el resultado!");
        System.out.println("Debes ingresar la expresion con espacios entre cada caracter...");
        System.out.println("Si no, la conversion no funcionara...");
        System.out.println("- Sigue las instrucciones por favor.");
        System.out.println();
        System.out.println("Ejemplo: ( 2 + 3 ) * ( 5 + 1 )");
        System.out.println("Conversion: 2 3 + 5 1 + *");
        System.out.println("Resultado: 30");
        String s2 = "- Ingresa tu expresion Infix: ";
        s = solicitar_string(s2);
        return s;
    }

    /**
     * Bienvenida al usuario.
     * 
     * @author Grupo 4
     * @version bienvenida 1.0
     */
    public void bienvenida(){
        System.out.println();
        System.out.println();
        System.out.println("------------ Calculadora Infix to Postfix ------------");
        System.out.println();
        System.out.println("------------ BIENVENIDO ------------");
        System.out.println("- Hora de Entrada: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        System.out.println("---------------------------------------------");
        System.out.println("- Esta es la Calculadora del Grupo 4!");
        System.out.println("- Primero ingresa la instancia que deseas correr...");
        System.out.println("- Luego ingresa tu expresion Infix para ser transformada a Postfix.");
        System.out.println("\tDiviertete calculando!!!");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    public boolean seguir_covirtiendo(){
        boolean seguir = true;
        System.out.println();
        System.out.println("Desea salir del programa?");
        System.out.println("Presione 1 si desea seguir conviertiendo.");
        System.out.println("Presione 2 para abandonar el programa.");
        String s = "Desea seguir en el conviertiendo??? ";
        int desicion = solicitar_int(s, 1, 2);
        if(desicion==2){
            seguir = false;
        }
        return seguir;
    }

    /**
     * Metodo para mostrar un resultado al usuario
     * 
     * @author Grupo 4
     * @version bienvenida 1.1
     */
    public void imprimir_resultados(double result){
        this.numero_de_resultados += 1;
        System.out.println("\t---- Resultado No."+this.numero_de_resultados+" ----");
        System.out.println("\t R// "+result);
        System.out.println();
    }

    /**
     * Metodo de despedida para el usuario.
     */
    public void despedida(){
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println(" Gracias por usar la Calculadora!");
        System.out.println("- Hora de Salida: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        System.out.println("---------------------------------------------");
        System.out.println("- Vuelve pronto!");
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println();
    }

}


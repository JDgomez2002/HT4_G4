//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT4

import java.util.ArrayList;

public class ArrayListStack<E> implements iStack<E>{
    ArrayList<E> myStack = new ArrayList<E>();
    ArrayList<E> myStack2 = new ArrayList<E>();
    private int espacios;
    private int recorrido;

    /**
     * Constructor.
     */
    public ArrayListStack(){
        this.espacios = 0;
        this.recorrido = 0;
    }

    /**
     * add an item to the stack. Will be popped next.
     * @param String
     */
    public void add(E item){
        this.myStack.add(item);
        this.myStack2.add(item);
        this.espacios += 1;
        this.recorrido += 1;
    }

    /**
     * If the Stack is not empty, the most recent item will be removed and returned.
     * @return String
     */
    public E remove(){
        E s = null;
        int last = this.espacios-1;

        if((!this.myStack.isEmpty()&&(this.espacios>0))){
            s = this.myStack.get(last);
            myStack.remove(last);
            myStack2.remove(last);
            this.espacios -= 1;
            this.recorrido -= 1;
        }

        return s;
    }

    /**
     * Get the current Item on the Stack (without popping it).
     * @return String
     */
    public E peek(){
        E s = null;
        int last = this.espacios-1;

        if((!this.myStack.isEmpty()&&(this.espacios>0))){
            s = this.myStack.get(last);
        }

        return s;
    }

    /**
     * Check if the Stack is empty.
     * @return Boolean indicating if the Stack is empty
     */
    public boolean empty(){
        boolean vacio = false;
        
        if(this.espacios<=0){
            vacio = true;
        }

        return vacio;
    }

    /**
     * Get the size of the Stack.
     * @return Integer indicating the size of the Stack
     */
    public int size(){
        return this.espacios;
    }
}
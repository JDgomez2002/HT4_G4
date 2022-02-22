//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT4

public class ListStack<E> implements iStack<E>{
    private iList<E> listStack;
    private boolean sll;

    public ListStack(boolean singleLinkedList){
        if(singleLinkedList){
            this.listStack = new SLL<E>();
            this.sll = true;
        }
        else{
            this.listStack = new DLL<E>();
            this.sll = false;

        }
    }

    public void add(E item){
        this.listStack.addItem(item);
    }

    public E remove(){
        E e = this.listStack.get_head();
        this.listStack.remove_cabeza();
        return e;
    }

    public E peek(){
        return this.listStack.get_head();
    }

    public boolean empty(){
        if(this.listStack.get_size()==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return this.listStack.get_size();
    }

}
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

public class DLL<E> implements iList<E>{
    private ArrayList<E> doubleLinkList;
    private ArrayList<E> doubleLinkList2;
    private E head;
    private E tail;

    public DLL(){
        this.doubleLinkList = new ArrayList<E>();
        this.doubleLinkList2 = new ArrayList<E>();
    }
    
    public void addItem(E item){

        this.head = item;
        if(this.doubleLinkList.size()>0){
            this.tail = this.doubleLinkList.get(this.doubleLinkList.size()-1);
        }
        else{
            this.tail = this.head;
        }
        this.doubleLinkList2.add(item);

        int lenght = doubleLinkList.size();
        for(int i = 0; i<lenght; i++){
            this.doubleLinkList2.add(this.doubleLinkList.get(i));
        }

        this.doubleLinkList = new ArrayList<E>(this.doubleLinkList2);
        this.doubleLinkList2.clear();
    }

    public E get_head(){
        return this.head;
    }

    public E get_tail(){
        return this.tail;
    }

    public int get_size(){
        return this.doubleLinkList.size();
    }

    public E iterator(int b){
        return this.doubleLinkList.get(b);
    }

    public void remove_cabeza(){
        this.doubleLinkList.remove(0);
        this.head = this.doubleLinkList.get(0);
    }

    public void remove_tail(){
        this.doubleLinkList.remove(this.doubleLinkList.size()-1);
        this.tail = this.doubleLinkList.get(this.doubleLinkList.size()-1);
    }
    
    public void remove_item(int c){
        if(c==0){
            remove_cabeza();
        }
        else if((c==-1)||(c==(this.doubleLinkList.size()-1))){
            remove_tail();
        }
        else{
            this.doubleLinkList.remove(c);
        }
    }

    // public static void main(String[] args) {

    //     DLL<String> single = new DLL<String>();

    //     System.out.println();
    //     single.addItem("cabeza1");
    //     single.addItem("cabeza2");
    //     single.addItem("cabeza3");
    //     System.out.println("CABEZA: "+single.get_head());

    //     System.out.println();

    //     for(int k = 0; k<single.get_size() ;k++){
    //         System.out.println(single.iterator(k));
    //     }

    //     System.out.println();
    //     single.addItem("ultima cabeza");
    //     System.out.println("COLA: "+single.get_tail());
    //     single.remove_tail();
    //     System.out.println("COLA: "+single.get_tail());
    //     System.out.println();

    //     for(int k = 0; k<single.get_size() ;k++){
    //         System.out.println(single.iterator(k));
    //     }
    //     System.out.println();

    // }

}
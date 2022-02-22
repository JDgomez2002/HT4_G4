//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT4

public interface iList<E>{
    
    public void addItem(E item);

    public E get_head();

    public int get_size();

    public E iterator(int b);

    public void remove_cabeza();

    public void remove_item(int c);

}
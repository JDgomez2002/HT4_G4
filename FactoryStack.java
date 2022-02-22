//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT4

public class FactoryStack<E>{
    private iStack<E> MyStack;
    
    public iStack<E> returnStackType(int type){
        switch (type) {

            //Vector Stack
            case 1:
                this.MyStack = new VectorStack<E>();
                break;

            //ArrayList Stack
            case 2:
                this.MyStack = new ArrayListStack<E>();
                break;

            //Single Linked List Stack
            case 3:
                this.MyStack = new ListStack<E>(true);
                break;
        
            //Double Linked List
            default:
                this.MyStack = new ListStack<E>(false);
                break;
        }
        return this.MyStack;
    }


}

package lista;

public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private int dato;

    public Nodo (int dat, Nodo ant, Nodo sig){
        siguiente = sig;
        anterior = ant;
        dato= dat;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public int getDato() {
        return dato;
    }
}

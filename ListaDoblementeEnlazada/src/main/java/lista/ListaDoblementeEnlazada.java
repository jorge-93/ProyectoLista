package lista;

public class ListaDoblementeEnlazada{
    private Nodo inicio;
    private Nodo fin;

    public ListaDoblementeEnlazada(){
        inicio=null;
        fin=null;
        }

    public ListaDoblementeEnlazada(Nodo primero, Nodo ultimo) {
        inicio = primero;
        fin = ultimo;
        }
    public Nodo getPrimero(){
        return inicio;
        }
    public Nodo getUltimo(){
        return fin;
        }
    public void insertarInicio(ListaDoblementeEnlazada dato, Nodo actual, Nodo nuevo){
        nuevo.setAnterior(actual);
        nuevo.setSiguiente(actual.getSiguiente());
        if(actual.getSiguiente()==null){
            dato.fin=actual;
            }else{
                actual.getSiguiente().setAnterior(nuevo);
                actual.setSiguiente(nuevo);
                }
        }
    public void insertarFin(ListaDoblementeEnlazada dato, Nodo actual, Nodo nuevo){
        nuevo.setAnterior(actual.getAnterior());
        nuevo.setSiguiente(actual);
        if(actual.getAnterior()==null){
            dato.inicio=nuevo;
            }else{    
                actual.getAnterior().setSiguiente(nuevo);
                actual.setAnterior(nuevo);
                }
        }
    public void insertarAlInicio(ListaDoblementeEnlazada dato, Nodo nodo) {
        if (dato.inicio == null) {
            dato.inicio = nodo;
            dato.fin = nodo;
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
            } else {
                insertarFin(dato, dato.inicio, nodo);
                }
        }
    public void insertarAlFin(ListaDoblementeEnlazada dato, Nodo nodo) {
        if (dato.fin == null) {
            dato.insertarAlInicio(dato, nodo);
            } else {
                dato.insertarInicio(dato, dato.fin, nodo);
                }
        }
    public void borrarNodo(ListaDoblementeEnlazada dato, Nodo nodo) {
        if (nodo.getAnterior() == null) {
            dato.inicio = nodo.getSiguiente();
            } else {
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                }
        if (nodo.getSiguiente() == null) {
            dato.fin = nodo.getAnterior();
            } else {
                nodo.getSiguiente().setAnterior(nodo.getAnterior());
                }
    }
}
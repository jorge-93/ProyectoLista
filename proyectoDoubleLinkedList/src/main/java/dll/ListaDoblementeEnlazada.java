package dll;

public class ListaDoblementeEnlazada {

    private NodoDoblementeEnlazado primerNodo;
    private NodoDoblementeEnlazado ultimoNodo;

    public ListaDoblementeEnlazada() {
        primerNodo = null;
        ultimoNodo = null;
    }

    public ListaDoblementeEnlazada(NodoDoblementeEnlazado primero,
            NodoDoblementeEnlazado ultimo) {
        primerNodo = primero;
        ultimoNodo = ultimo;
    }

    public NodoDoblementeEnlazado getPrimero(){
        return primerNodo;
    }
    
    public NodoDoblementeEnlazado getUltimo(){
        return ultimoNodo;
    }
    public void insertarAdelante(ListaDoblementeEnlazada lista,
            NodoDoblementeEnlazado nodo, NodoDoblementeEnlazado nuevonodo) {
        nuevonodo.setAnterior(nodo);
        nuevonodo.setSiguiente(nodo.siguiente());
        if (nodo.siguiente() == null) {
            lista.ultimoNodo = nuevonodo;
        } else {
            nodo.siguiente().setAnterior(nuevonodo);
            nodo.setSiguiente(nuevonodo);
        }
    }

    public void insertarAtras(ListaDoblementeEnlazada lista,
            NodoDoblementeEnlazado nodo, NodoDoblementeEnlazado nuevonodo) {
        nuevonodo.setAnterior(nodo.anterior());
        nuevonodo.setSiguiente(nodo);
        if (nodo.anterior() == null) {
            lista.primerNodo = nuevonodo;
        } else {
            nodo.anterior().setSiguiente(nuevonodo);
            nodo.setAnterior(nuevonodo);

        }
    }

    public void insertarAlPrincipio(ListaDoblementeEnlazada lista,
            NodoDoblementeEnlazado nodo) {

        if (lista.primerNodo == null) {
            lista.primerNodo = nodo;
            lista.ultimoNodo = nodo;
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
         } else {
            insertarAtras(lista, lista.primerNodo, nodo);
        }
    }

    public void insertarAlFinal(ListaDoblementeEnlazada lista,
        NodoDoblementeEnlazado nodo) {
        if (lista.ultimoNodo == null) {
            lista.insertarAlPrincipio(lista, nodo);
        } else {
            lista.insertarAdelante(lista, lista.ultimoNodo, nodo);
        }
    }

    public void eliminarNodo(ListaDoblementeEnlazada lista,
            NodoDoblementeEnlazado nodo) {

        if (nodo.anterior() == null) {
            lista.primerNodo = nodo.siguiente();
        } else {
            nodo.anterior().setSiguiente(nodo.siguiente());
        }
        if (nodo.siguiente() == null) {
            lista.ultimoNodo = nodo.anterior();
        } else {
            nodo.siguiente().setAnterior(nodo.anterior());
        }

    }


}

class NodoDoblementeEnlazado {

    private NodoDoblementeEnlazado anterior, siguiente;
    private int dato;

    public NodoDoblementeEnlazado(NodoDoblementeEnlazado anterior, int dato,
            NodoDoblementeEnlazado siguiente) {

        this.anterior = anterior;
        this.dato = dato;
        this.siguiente = siguiente;

    }

    public NodoDoblementeEnlazado siguiente() {
        return this.siguiente;
    }

    public NodoDoblementeEnlazado anterior() {
        return this.anterior;
    }

    public int dato() {
        return dato;
    }

    public void setSiguiente(NodoDoblementeEnlazado nuevo) {
        this.siguiente = nuevo;
    }

    public void setAnterior(NodoDoblementeEnlazado nuevo) {
        this.anterior = nuevo;
    }
}

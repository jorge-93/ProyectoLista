package dll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class PruebasjUnit {
    
    private static final int INDICE = 1;
    private static final int INDICE2 = 2;
    private static final int INDICE3 = 3;
    private static final int INDICE4 = 4;
    NodoDoblementeEnlazado nodo1 = new NodoDoblementeEnlazado(null,INDICE,null);
    NodoDoblementeEnlazado nodo2 = new NodoDoblementeEnlazado(null,INDICE2,null);
    NodoDoblementeEnlazado nodo3 = new NodoDoblementeEnlazado(null,INDICE3,null);
    NodoDoblementeEnlazado nodo4 = new NodoDoblementeEnlazado(null,INDICE4,null);
    ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
    
    @Before
    public void init(){
        lista.insertarAlPrincipio(lista, nodo1);
        lista.insertarAlFinal(lista, nodo4);
        lista.insertarAlFinal(lista, nodo3);
        lista.insertarAlPrincipio(lista, nodo2);
    }
    
    @Test
    public void testAlPrincipioSimple() {
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo3);
        lista2.insertarAlPrincipio(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlPrincipio(lista2, nodo2);
        assertEquals(lista.getPrimero(),lista2.getPrimero());
    }

    @Test
    public void testAlFinalSimple() {
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlFinal(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlFinal(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo3);
        assertEquals(lista.getUltimo(),lista2.getUltimo());
    }
    
    @Test
    public void testAlPrincipioMezcla(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        assertEquals(lista.getPrimero(),lista2.getPrimero());
    }
    @Test
    public void testAlFinalMezcla(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        assertEquals(lista.getUltimo(),lista2.getUltimo());
    }
    
    @Test
    public void eliminarNodoFinal(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        lista2.eliminarNodo(lista2, nodo3);
        lista.eliminarNodo(lista, nodo3);
        assertEquals(lista.getUltimo(),lista2.getUltimo());
    }
    
    @Test
    public void eliminarNodoInicial(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        lista2.eliminarNodo(lista2, nodo2);
        lista.eliminarNodo(lista, nodo2);
        assertEquals(lista.getPrimero(),lista2.getPrimero());
    }
    
    @Test
    public void eliminarNodoIntermedio(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        lista2.eliminarNodo(lista2, nodo1);
        lista.eliminarNodo(lista, nodo1);
        assertEquals(lista.getUltimo(),lista2.getUltimo());
    }
    
    @Test
    public void eliminarNodoIntermedioV2(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();
        lista2.insertarAlPrincipio(lista2, nodo1);
        lista2.insertarAlFinal(lista2, nodo4);
        lista2.insertarAlPrincipio(lista2, nodo2);
        lista2.insertarAlFinal(lista2, nodo3);
        lista2.eliminarNodo(lista2, nodo1);
        lista.eliminarNodo(lista, nodo1);
        assertEquals(lista.getPrimero(),lista2.getPrimero());
    }
    
    @Test
    public void creacionDeLista(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada(lista.getPrimero(),lista.getUltimo());
        assertEquals(lista.getPrimero(),lista2.getPrimero());
    }
    
    @Test
    public void comprobacionDato(){
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada(lista.getPrimero(),lista.getUltimo());
        assertEquals(lista.getPrimero().dato(),lista2.getPrimero().dato());
    }
    
    
    @After
    public void fin() {
        lista.eliminarNodo(lista, nodo1);
        lista.eliminarNodo(lista, nodo2);
        lista.eliminarNodo(lista, nodo3);
        lista.eliminarNodo(lista, nodo4);
    }
    
}

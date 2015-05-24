package lista;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaDoblementeEnlazadaTest {
    private static final int DATO1 = 1;
    private static final int DATO2 = 2;
    private static final int DATO3 = 3;
    private static final int DATO4 = 4;
    Nodo nodo1 = new Nodo(DATO1,null,null);
    Nodo nodo2 = new Nodo(DATO2,null,null);
    Nodo nodo3 = new Nodo(DATO3,null,null);
    Nodo nodo4 = new Nodo(DATO4,null,null);
    ListaDoblementeEnlazada ld = new ListaDoblementeEnlazada();

    @Before
    public void init(){
        ld.insertarAlInicio(ld, nodo1);
        ld.insertarAlFin(ld, nodo2);
        ld.insertarAlFin(ld, nodo3);
        ld.insertarAlFin(ld, nodo4);
        }
    
    @Test
    public void testInicio() {
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada();
        ld2.insertarAlInicio(ld2, nodo4);
        ld2.insertarAlInicio(ld2, nodo3);
        ld2.insertarAlInicio(ld2, nodo2);
        ld2.insertarAlInicio(ld2, nodo1);
        assertEquals(ld.getPrimero(),ld2.getPrimero());
     }
    @Test
    public void testFin() {
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada();
        ld2.insertarAlFin(ld2, nodo1);
        ld2.insertarAlFin(ld2, nodo2);
        ld2.insertarAlFin(ld2, nodo3);
        ld2.insertarAlFin(ld2, nodo4);
        assertEquals(ld.getUltimo(),ld2.getUltimo());
    }
    @Test
    public void testListaCambiada(){
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada();
        ld2.insertarAlInicio(ld2, nodo2);
        ld2.insertarAlFin(ld2, nodo3);
        ld2.insertarAlInicio(ld2, nodo1);
        ld2.insertarAlFin(ld2, nodo4);
        assertEquals(ld.getPrimero(),ld2.getPrimero());
    }
    
    @Test
    public void eliminarNodo(){
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada();
        ld2.insertarAlInicio(ld2, nodo1);
        ld2.insertarAlFin(ld2, nodo4);
        ld2.insertarAlInicio(ld2, nodo2);
        ld2.insertarAlFin(ld2, nodo3);
        ld2.borrarNodo(ld2, nodo3);
        ld.borrarNodo(ld, nodo3);
        assertEquals(ld.getUltimo(),ld2.getUltimo());
    }
    @Test
    public void eliminarOtroNodo(){
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada();
        ld2.insertarAlInicio(ld2, nodo1);
        ld2.insertarAlFin(ld2, nodo4);
        ld2.insertarAlInicio(ld2, nodo2);
        ld2.insertarAlFin(ld2, nodo3);
        ld2.borrarNodo(ld2, nodo2);
        ld.borrarNodo(ld, nodo2);
        assertEquals(ld.getPrimero(),ld2.getPrimero());
    }

    @Test
    public void crearLista(){
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada(ld.getPrimero(),ld.getUltimo());
        assertEquals(ld.getPrimero(),ld2.getPrimero());
    }
    
    @Test
    public void comprobarDato(){
        ListaDoblementeEnlazada ld2 = new ListaDoblementeEnlazada(ld.getPrimero(),ld.getUltimo());
        assertEquals(ld.getPrimero().getDato(),ld2.getPrimero().getDato());
    }
    
    @After
    public void fin() {
        ld.borrarNodo(ld, nodo1);
        ld.borrarNodo(ld, nodo2);
        ld.borrarNodo(ld, nodo3);
        ld.borrarNodo(ld, nodo4);
    }
}

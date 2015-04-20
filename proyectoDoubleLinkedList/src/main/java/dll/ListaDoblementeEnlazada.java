package dll;

public class ListaDoblementeEnlazada {

	private NodoDoblementeEnlazado PrimerNodo;
	private NodoDoblementeEnlazado UltimoNodo;
	
	public ListaDoblementeEnlazada(){
		PrimerNodo = null;
		UltimoNodo = null;
	}
	
	public ListaDoblementeEnlazada(NodoDoblementeEnlazado primero, NodoDoblementeEnlazado ultimo){
		PrimerNodo = primero;
		UltimoNodo = ultimo;
	}
	
	public void InsertarAdelante(ListaDoblementeEnlazada lista, NodoDoblementeEnlazado nodo, NodoDoblementeEnlazado nuevonodo){
		nuevonodo.SetAnterior(nodo);
		nuevonodo.SetSiguiente(nodo.Siguiente());
		if(nodo.Siguiente() == null){
			lista.UltimoNodo = nuevonodo;
		}
		else{
			nodo.Siguiente().SetAnterior(nuevonodo);
			nodo.SetSiguiente(nuevonodo);
		}
	}
	
	public void InsertarAtras(ListaDoblementeEnlazada lista, NodoDoblementeEnlazado nodo, NodoDoblementeEnlazado nuevonodo){
		nuevonodo.SetAnterior(nodo.Anterior());
		nuevonodo.SetSiguiente(nodo);
		if(nodo.Anterior() == null){
			lista.PrimerNodo = nuevonodo;
		}
		else{
			nodo.Anterior().SetSiguiente(nuevonodo);
			nodo.SetAnterior(nuevonodo);
			
		}
	}
	
	public void InsertarAlPrincipio(ListaDoblementeEnlazada lista, NodoDoblementeEnlazado nodo){
		
	if (lista.PrimerNodo == null){
		lista.PrimerNodo = nodo;
		lista.UltimoNodo = nodo;
		nodo.SetSiguiente(null);
		nodo.SetAnterior(null);		
		}
	else{
		InsertarAtras(lista, lista.PrimerNodo, nodo);
		}
	}
	
	public void InsertarAlFinal(ListaDoblementeEnlazada lista, NodoDoblementeEnlazado nodo){
		if(lista.UltimoNodo == null){
			lista.InsertarAlPrincipio(lista,nodo);
		}
		else{
			lista.InsertarAdelante(lista, lista.UltimoNodo, nodo);
		}
	}
	
	public void EliminarNodo(ListaDoblementeEnlazada lista, NodoDoblementeEnlazado nodo){
	
		if(nodo.Anterior() == null){
			lista.PrimerNodo = nodo.Siguiente();
		}
		else{
			nodo.Anterior().SetSiguiente(nodo.Siguiente());
		}
		if(nodo.Siguiente() == null){
			lista.UltimoNodo = nodo.Anterior();
		}
		else{
			nodo.Siguiente().SetAnterior(nodo.Anterior());
		}
		
	}
	
}

 class NodoDoblementeEnlazado{
	
	 private NodoDoblementeEnlazado anterior,siguiente;
	 private int dato;
	 
	 public NodoDoblementeEnlazado(NodoDoblementeEnlazado anterior,int dato, NodoDoblementeEnlazado siguiente){
		 
		 this.anterior = anterior;
		 this.dato = dato;
		 this.siguiente = siguiente;
		 
	 }
	 
	 public NodoDoblementeEnlazado Siguiente(){
		 return this.siguiente;
	 }
	 
	 public NodoDoblementeEnlazado Anterior(){
		 return this.anterior;
	 }
	 
	 public int Dato(){
		 return this.dato;
	 }
	 
	 public void SetSiguiente(NodoDoblementeEnlazado nuevo){
		 this.siguiente = nuevo;
	 }
	 
	 public void SetAnterior(NodoDoblementeEnlazado nuevo){
		 this.anterior = nuevo;
	 }
}

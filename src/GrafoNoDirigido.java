import java.util.HashSet;
import java.util.Hashtable;


public class GrafoNoDirigido extends Grafo {
	
	
	public GrafoNoDirigido(){
		super();
	};
	

	public void agregarArista(GrafoNoDirigido g, Arista a){
		
		g.CjtoLados.put(a.idLado, a);
		
	};
	
	public void eliminarArista(GrafoNoDirigido g, String idArista){
		
		g.CjtoLados.remove(idArista);
		
		
	};
	
	

	
}

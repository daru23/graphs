import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import java.io.*;
import java.lang.Object;
import java.lang.String;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.*;

class GrafoDirigido extends Grafo {


	public GrafoDirigido(){
		super();
	};
			
		
	public void agregarArco(GrafoDirigido g, Arco a){
		
		g.CjtoLados.put(a.idLado,a);		
	};
	
	public void eliminarArco(GrafoDirigido g, String idArco){
		
		g.CjtoLados.remove(idArco);
	};
	
	public void gradoInterior (GrafoDirigido g, String idVer){
		int grado=0;
		System.out.println("El grado del vertice "+ idVer+ " es:");
		HashSet aux=new HashSet();			
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerFin.equals(idVer)==true){
				grado++;
			};
							
		};
		System.out.println(grado);
	};	
	public void gradoExterior (GrafoDirigido g, String idVer){
		int grado=0;
		System.out.println("El grado del vertice "+ idVer+ " es:");
		HashSet aux=new HashSet();			
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(idVer)==true){
				grado++;
			};
						
		};
		System.out.println(grado);
	};
	public HashSet sucesores (GrafoDirigido g, String idVer){
		HashSet aux=new HashSet();			
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(idVer)==true){
				aux.add(l.idVerFin);
			}
							
		};
		return aux;
		
	};
	public HashSet predecesores (GrafoDirigido g, String idVer){
		HashSet aux=new HashSet();			
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerFin.equals(idVer)==true){
				aux.add(l.idVerInic);
			}
							
		};
		return aux;
		
	};
	
	
			
	
	
}

import java.util.*;
import java.lang.*;
import java.io.*;

  class Camino{
	
	
	public static void main (String args[]) throws IOException{
	
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g=new GrafoDirigido();
	g=g.Grafo(Archivo);
	//HashSet visitados=(HashSet)g.CjtoVertice.keySet();
	int nV=g.CjtoVertice.size();
	boolean valido=true;
	
	Enumeration e2=g.CjtoVertice.keys();
	while(e2.hasMoreElements() && valido==true){
		String x=(String)e2.nextElement();
		int grade=(int)g.grado(x);
		if   (((grade)%(2))!=0){valido=false;}
	};
	
	if (valido==false){System.out.println("No es posible crear camino Euleriano");}
	else{
	
	
	LinkedList C=new LinkedList();
	LinkedList rojos=new LinkedList();		
	LinkedList amarillos=new LinkedList();
	LinkedList adyacencias=new LinkedList();
	LinkedList pendientes=new LinkedList();
	LinkedList pasado=new LinkedList();
	

	
	
	
	for(Enumeration e=g.CjtoVertice.keys(); e.hasMoreElements();){
		String s=(String)e.nextElement();
		pendientes.add(s);	
		System.out.println("pendientes"+s);
	};
	
	while(pendientes.size()!=0){
		String v;
		v=(String)pendientes.getFirst();
		System.out.println("v"+v);
		amarillos.add(v);
		pendientes.remove(v);
	
		
	
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(v) && rojos.contains(l.idVerFin)==false && C.contains(l.idLado)==false ){
				adyacencias.add(l.idVerFin);
			}
			else if ( l.idVerFin.equals(v) && rojos.contains(l.idVerInic)==false && C.contains(l.idLado)==false){
				adyacencias.add(l.idVerInic);
			}
						
						
							
		};
	
		
		
			
			while(rojos.size()!=nV){
				System.out.println("amarillos"+amarillos.size());
				System.out.println("rojos"+rojos.size());
				if (C.size()!=0){ 
					String primero=(String)C.getFirst();
					C.remove(primero);
					System.out.println("hola2");
					
					Lado prim=(Lado)g.CjtoLados.get(primero);
					String ultimo=(String)C.getLast();
					Lado ult=(Lado)g.CjtoLados.get(ultimo);
				

					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						System.out.println(l.idLado);
						System.out.println(l.idVerInic);
						System.out.println(l.idVerFin);
						System.out.println((l.idVerFin).equals(prim.idVerInic) && (l.idVerInic).equals(ult.idVerFin));
						if ((l.idVerFin).equals(prim.idVerInic) && (l.idVerInic).equals(ult.idVerFin)){
							C.addLast(l.idLado);
							String lad=l.idLado;
							
						};
					
					};
					C.addLast(primero);
					System.out.println(C);
					
					
					String first=(String)C.getFirst();
					Lado lf=(Lado)g.CjtoLados.get(first);
					v=lf.idVerInic;
					adyacencias.clear();
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						if(l.idVerInic.equals(v) && rojos.contains(l.idVerFin)==false && C.contains(l.idLado)==false ){
							adyacencias.add(l.idVerFin);
						}
						else if ( l.idVerFin.equals(v) && rojos.contains(l.idVerInic)==false && C.contains(l.idLado)==false){
							adyacencias.add(l.idVerInic);
						}
						
						
							
					};
					
				};
				
				
	
				while (adyacencias.size()!=0){
					System.out.println("adyacencias"+adyacencias.size());
					String w=(String)adyacencias.getFirst();
					System.out.println("w "+w);
		
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						System.out.println(l.idLado);
						System.out.println(l.idVerInic);
						System.out.println(l.idVerFin);
						System.out.println(((l.idVerInic).equals(v) && (l.idVerFin).equals(w)) || ((l.idVerInic).equals(w) && (l.idVerFin).equals(v)));
						
						if (((l.idVerInic).equals(v) && (l.idVerFin).equals(w)) || ((l.idVerInic).equals(w) && (l.idVerFin).equals(v))){
							
							
							
							System.out.println(C.size());
							C.add(l.idLado);
							System.out.println(C.size());
							
							System.out.println("hola");
							
							
							
						};
					};
					
					
					
					
					adyacencias.clear();
					
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						if(l.idVerInic.equals(w) && rojos.contains(l.idVerFin)==false && C.contains(l.idLado)==false ){
							adyacencias.add(l.idVerFin);
						}
						else if ( l.idVerFin.equals(w) && rojos.contains(l.idVerInic)==false && C.contains(l.idLado)==false){
							adyacencias.add(l.idVerInic);
						}
						
						
							
					};
					
					if (adyacencias.size()<=1){
						rojos.add(w);
						amarillos.remove(w);
					}
					else{amarillos.add(w);};
					System.out.println(adyacencias);
					System.out.println(C);
					v=w;
					pendientes.remove(v);

					
		
				};
				
				
	
			}; 
		
		
		
					
	};
	};
	
	
	
	};
	
	
	
	
}
	
	
	
	
	


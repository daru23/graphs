import java.util.*;
import java.lang.*;
import java.io.*;

  class Camino2{
	
	
	public static void main (String args[]) throws IOException{
	
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g=new GrafoDirigido();
	g=g.Grafo(Archivo);
	int nV=(int)g.CjtoVertice.size();
	
	
	LinkedList C=new LinkedList();

	LinkedList coloreados=new LinkedList();
	LinkedList adyacencias=new LinkedList();
	LinkedList pendientes=new LinkedList();
	
	

	
	
	
	for(Enumeration e=g.CjtoVertice.keys(); e.hasMoreElements();){
		String s=(String)e.nextElement();
		pendientes.add(s);	
		System.out.println("pendientes"+s);
	};
	
	while(pendientes!=null){
		String v;
		v=(String)pendientes.getFirst();
		System.out.println("v"+v);
		coloreados.add(v);
		
		
	
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
				Lado l=(Lado)e.nextElement();
				if(l.idVerInic.equals(v)==true && coloreados.contains(l.idVerFin)==false){
					adyacencias.add(l.idVerFin);
					System.out.println(l.idVerFin);
				}
				else if(l.idVerFin.equals(v)==true && coloreados.contains(l.idVerInic)==false){
					adyacencias.add(l.idVerInic);
					System.out.println(l.idVerInic);
				};
							
		};
	
		
		
			
			while(coloreados.size()!=0){
				System.out.println("coloreados"+coloreados.size());
				/*if (C.size()!=0){ 
					String primero=(String)C.removeFirst();
					System.out.println("hola2");
					
					Lado prim=(Lado)g.CjtoLados.get(primero);
					String ultimo=(String)C.getLast();
					Lado ult=(Lado)g.CjtoLados.get(ultimo);
				

					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						System.out.println(l.idLado);
						System.out.println(l.idVerInic);
						System.out.println(l.idVerFin);
						System.out.println((l.idVerInic).equals(prim.idVerFin) && (l.idVerFin).equals(ult.idVerInic));
						if ((l.idVerInic).equals(prim.idVerFin) && (l.idVerFin).equals(ult.idVerInic)){
							System.out.println(l.idLado);
							C.addLast(l.idLado);
							C.addLast(primero);
						
						};
					
					};
					String first=(String)C.getFirst();
					Lado lf=(Lado)g.CjtoLados.get(first);
					v=lf.idVerInic;
					adyacencias.clear();
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						if(l.idVerInic.equals(v) && rojos.contains(l.idVerFin)==false ){
							adyacencias.add(l.idVerFin);
						}
						else if(l.idVerFin.equals(v) && rojos.contains(l.idVerInic)==false ){
							adyacencias.add(l.idVerInic);
						};
							
					};
					
				};*/
				
				//LinkedList C2=new LinkedList();
	
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
						
						if (((l.idVerInic).equals(v) && (l.idVerFin).equals(w))|| ((l.idVerInic).equals(w) && (l.idVerFin).equals(v))){
							
							
							
							//System.out.println(C.size());
							C.add(l.idLado);
							//System.out.println(C.size());
							
							System.out.println("hola");
							
							
						};
					};
					
					
					
					v=w;
					coloreados.add(w);
					//adyacencias.clear();
					
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						if(l.idVerInic.equals(w) && coloreados.contains(l.idVerFin)==false ){
							adyacencias.add(l.idVerFin);
						}
						else if(l.idVerFin.equals(w) && coloreados.contains(l.idVerInic)==false ){
							adyacencias.add(l.idVerInic);
						};
							
					};
					
					/*if (adyacencias.size()<=1){
						rojos.add(w);
						amarillos.remove(w);
					}
					else{amarillos.add(w);};*/
					
					

					/*for(Iterator it=C.iterator();it.hasNext();){
						String t=(String)it.next();
						System.out.println(t);	
					};*/
					
		
				};
				
				
	
			}; 
		
		
		
					
	};
	};
	
	
	
	
	
}
	
	
	
	
	


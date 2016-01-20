import java.util.*;
import java.lang.*;
import java.io.*;

class GradoPar{


	
 public GrafoNoDirigido GPar (GrafoNoDirigido g){
 
	
 
  HashSet I=new HashSet();
  
  for(Enumeration e=g.CjtoVertice.keys(); e.hasMoreElements();){
		String s=(String)e.nextElement();
		
		//if (((g.grado(s)) mod(2))!=0){I.add(s);}
	};
  
  HashSet D=new HashSet();
  
  while(I!=null){
  
  
  
  String i=(String)I.getLast();
  I.remove(i);
  HashSet A=new HashSet();
  
  
  
  
	  for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
				Lado l=(Lado)e.nextElement();
				if(l.idVerInic.equals(v)){
					A.add(l.idVerFin);
					
				}
				else if(l.idVerFin.equals(v)){
					A.add(l.idVerInic);
					
				};
							
		};
		
		
		HashSet interseccion=new HashSet();
		
		while (disjuntos==true){
			for(Iterator it=A.iterator();it.hasNext;);{
			String a=(String)it.next();
		 
				for(Iterator it2=I.iterator();it2.hasNext;){
				String u=(String)it2.next();
			
			
				if (u.equals(a)){interseccion.add(a);};
			
		 
				};
		 
			};
		
		
		};
		
		if (interseccion.size()!=0){
		String x=(String)interseccion.getFirst();
		String ix="ix";
		Lado l=new Lado(0,ix,"i","x");
		g.CjtoLados.put(l.idLado,l);
		I.remove(x);
		D.add(l);
		
		}
		else {
		HashSet Inc=new HashSet();
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
				Lado l=(Lado)e.nextElement();
				if(l.idVerInic.equals(i) || l.idVerFin.equals(i)){
					Inc.add(l.idLado);
					
				};
				
							
		};
		
		HashSet IncD=new HashSet();
		IncD=Inc;
		
		for(Iterator it=D.iterator();it.HasNext();){
			String d=(String)it.next();
			if (Inc.contains(d)){
				IncD.remove(d);
			};
		};
		
		boolean ya=false;
		
		Iterator it=Inc-D.iterator();
		
		while(it.HasNext && ya==false){
		Lado f=(Lado)it.next;
			if (f.idVerInic.equals(i)){
			g.CjtoLados.put(i,f);
			I.add(f.idVerFin);
			D.add(f);
			ya=true;
			}
		};
		
		
		
		
		g.CjtoLados.put(lo.idLado,l);
		I.add(lo.idVerFin);
		D.add(lo);
		
		};
	
};

return(g);
};

public static void main (String args[])  {

System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g=new GrafoNoDirigido();
	g=g.Grafo(Archivo);
	GPar(g);
};
}
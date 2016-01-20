import java.util.*;
import java.lang.*;
import java.io.*;

class Dijkstra {

public class LinkedList Dijstra (Grafo g, Vertice s ){
int costo = 0;
HashSet suc=new HashSet();
LinkedList Caminos = new LinkedList();	
Caminos.addFisrt(s);
	//lleno el HashSet suc con sucesores de s
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l1=(Lado)e.nextElement();
			if(l1.idVerInic.equals(s.idVertice)){
				Vertice w=(Vertice)g.CjtoVertice.get(l1.idVerFin);
				suc.add(w);
			};
	};
	
	Vertice n = null
	for(Iterator it=suc.iterator();it.hasNext();){
		Vertice v = (Vertice)it.next();
		for(Iterator i=suc.iterator();i.hasNext();){
			Vertice w = (Vertcie)i.next();
			if (v.peso <= w.peso){n = (Vertice) v;}
			else {n = (Vertice) w;};
		};
	};

int c = 0;
	//lleno el HashSet suc con sucesores de n
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l1=(Lado)e.nextElement();
			if(l1.idVerInic.equals(n.idVertice)){
				Vertice m = (Vertice)g.CjtoVertice.get(l1.idVerFin);
				c = ll.peso + n.peso;
				if (c < m.peso){m.peso = c; Caminos.addLast(m);}
			};
	};


//CUASI FIN
}
//FIN
}
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.Enumeration;

class Biconexas {
 
 public static void Biconexas (Grafo g)   {
 
		///////////////////////////////////
		LinkedList visitados = new LinkedList();
		/////////////////////////////////Algoritmo de componentes biconexas y puntos de articulacion
		int Contador=0;
		HashSet B = new HashSet();
		HashSet P = new HashSet();
		for (Enumeration e = g.CjtoVertice.elements();e.hasMoreElements();){
		Vertice vertice = (Vertice)e.nextElement();
		  if (visitados.contains(vertice)==false ){
			vertice.Pred=null;
			visitados = DFS1(g,visitados,vertice, Contador, P, B);
			///////////////
			HashSet sucAux = new HashSet();
			for(Enumeration enu=g.CjtoLados.elements();enu.hasMoreElements();){
			Lado l=(Lado)enu.nextElement();
				if(l.idVerInic.equals(vertice.idVertice)){
					Vertice w=(Vertice)g.CjtoVertice.get(l.idVerFin);
					sucAux.add(w);
				};
				if (l.idVerFin.equals(vertice.idVertice)){
					Vertice w=(Vertice)g.CjtoVertice.get(l.idVerInic);
					sucAux.add(w);
				};
			};
			//////////////
			if (sucAux.size()>2){P.add(vertice);}
		  }
		}
		System.out.println("Lados Biconexos:");
		for(Iterator it = B.iterator(); it.hasNext();){
		String imp = (String)it.next();
		System.out.println(imp);
		}
		System.out.println("Puntos de Articulacion:");
		for(Iterator it = P.iterator(); it.hasNext();){
		Vertice imp = (Vertice)it.next();
		System.out.println(imp.idVertice);
		}
		
 
 }
 /////////////DFS

public static LinkedList DFS1(Grafo g, LinkedList visitados, Vertice v, int Contador, HashSet P, HashSet B){
	//Grafo g1=g;
	HashSet suc=new HashSet();
	LinkedList Aristas = new LinkedList();
	////////////////////////lleno el HashSet suc con sucesores de v
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado lad=(Lado)e.nextElement();
			//System.out.println(l1.idVerInic.equals(v.idVertice)==true);
			if(lad.idVerInic.equals(v.idVertice)){
				Vertice w=(Vertice)g.CjtoVertice.get(lad.idVerFin);
				suc.add(w);
			};
			if (lad.idVerFin.equals(v.idVertice)){
				Vertice w=(Vertice)g.CjtoVertice.get(lad.idVerInic);
				suc.add(w);
			};
	};
	//////////// Iniciando las variables
	visitados.add(v);
	Contador = Contador +1;
	v.NumBusq = Contador;
	v.MasBajo = v.NumBusq;	
	//Itero sobre el conjunto de sucesores
	for(Iterator it=suc.iterator();it.hasNext();){
	
	Vertice w=(Vertice)it.next();
		
	//Si al vertice w todavia no se le ha asignado un predecesor, entonces se le asigna v
		w.Pred=v;
		if (visitados.contains(w)==false ){//si u no ha sido visitado
			
			for (Enumeration e = g.CjtoLados.elements();e.hasMoreElements();){
			Lado ladito = (Lado)e.nextElement();
				if ((v.idVertice.equals(ladito.idVerInic)==true && w.idVertice.equals(ladito.idVerFin)) ){
					Aristas.add(ladito.idLado); System.out.println("aristas "+ladito.idLado);
				}
			}
			
			DFS1(g,visitados, w ,Contador,P,B);//Vuelvo a llamar al metodo con el vertice u
			if (((w.MasBajo >= v.NumBusq) && !(w.Pred==null)) || ((v.Pred==null) && (suc.size()>2) )){
				System.out.println(suc.size());
				if (v.Pred!=null && (suc.size()>2)){P.add(v);}
				if (v.Pred==null && suc.size()>2){
				for (Iterator i = suc.iterator();i.hasNext();){
				Vertice k = (Vertice)i.next();
				if (visitados.contains(k)==false){P.add(v);}
				}
				
				}
				for (Iterator i = Aristas.iterator(); i.hasNext();){
					String aB = (String)i.next();
					System.out.println("aristas a B "+aB);
					B.add(aB);
				}
			}
			int MasBajoV = v.MasBajo;
			int MasBajoW = w.MasBajo;
			if (MasBajoV<MasBajoW){v.MasBajo = MasBajoV;}
			if (MasBajoW<MasBajoV){v.MasBajo = MasBajoW;}
		}
		else {
			HashSet sucAux = new HashSet();
			for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado la=(Lado)e.nextElement();
				if(la.idVerInic.equals(w.idVertice)){
					Vertice u = (Vertice)g.CjtoVertice.get(la.idVerFin);
					sucAux.add(u);
				};
				if (la.idVerFin.equals(w.idVertice)){
					Vertice u = (Vertice)g.CjtoVertice.get(la.idVerInic);
					sucAux.add(u);
				};
			};
			
			if (sucAux.contains(v)){
					if (v.NumBusq > w.NumBusq && (v.Pred !=w)){
						for (Enumeration E = g.CjtoLados.elements();E.hasMoreElements();){
						Lado ladito = (Lado)E.nextElement();
						if ((v.idVertice.equals(ladito.idVerInic)==true && w.idVertice.equals(ladito.idVerFin)) ||(v.idVertice.equals(ladito.idVerFin) && w.idVertice.equals(ladito.idVerInic))){
						Aristas.add(ladito.idLado);
						}
						}
					}

			int MasBajoV = v.MasBajo;
			int NumBusqW = w.NumBusq;
			if (MasBajoV<NumBusqW){v.MasBajo = MasBajoV;}
			if (NumBusqW<MasBajoV){v.MasBajo = NumBusqW;}
			
			}
		
		}
		
		
	};
	return visitados;
};


///////////////////////////////////////////////////////////////////////////////////////
//FIN	
}

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
		HashSet visitados = new HashSet();
		/////////////////////////////////Algoritmo de componentes biconexas y puntos de articulacion
		int Contador=0;
		Stack Aristas = new Stack();
		HashSet B = new HashSet();
		HashSet P = new HashSet();
		for (Enumeration e = g.CjtoVertice.elements();e.hasMoreElements();){
		Vertice vertice = (Vertice)e.nextElement();
		  if (visitados.contains(vertice)==false ){
		  System.out.println("v"+vertice.idVertice);
			vertice.Pred=vertice;
			visitados = DFS1(g,visitados,vertice, Aristas, Contador, P, B);
			///////////////
			HashSet sucAux = new HashSet();
			for(Enumeration e1=g.CjtoLados.elements();e1.hasMoreElements();){
			Lado la=(Lado)e1.nextElement();
				if(la.idVerInic.equals(vertice.idVertice)){
					Vertice u = (Vertice)g.CjtoVertice.get(la.idVerFin);
					sucAux.add(u);
				};
				if (la.idVerFin.equals(vertice.idVertice)){
					Vertice u = (Vertice)g.CjtoVertice.get(la.idVerInic);
					sucAux.add(u);
				};
			};
			
			//////////////
			if (sucAux.size()>1){P.add(vertice);}
		  };
		};
		System.out.println("Lados Biconexos:");
		for(Iterator it = B.iterator(); it.hasNext();){
			String imp = (String)it.next();
			System.out.println(imp);
		}
		System.out.println("Puntos de Articulacion:");
		for(Iterator it = P.iterator(); it.hasNext();){
			Vertice imp = (Vertice)it.next();
			System.out.println(imp.idVertice);
		};
		
 
 };
 /////////////DFS

public static HashSet DFS1(Grafo g, HashSet visitados, Vertice v, Stack Aristas, int Contador, HashSet P, HashSet B){
	//Grafo g1=g;
	HashSet suc=new HashSet();
	////////////////////////lleno el HashSet suc con sucesores de v
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
		Lado la=(Lado)e.nextElement();
		if(la.idVerInic.equals(v.idVertice)){
			Vertice u = (Vertice)g.CjtoVertice.get(la.idVerFin);
			suc.add(u);
			System.out.print("suc de "+v.idVertice+"="+u.idVertice );
		};
		if (la.idVerFin.equals(v.idVertice)){
			Vertice u = (Vertice)g.CjtoVertice.get(la.idVerInic);
			suc.add(u);
			System.out.print("suc de "+v.idVertice+"="+u.idVertice );
		};
	};
	//////////// Iniciando las variables
	System.out.println("v"+v.idVertice);
	visitados.add(v);
	System.out.println("visitados");
	for(Iterator it2=visitados.iterator();it2.hasNext();){
		Vertice vg=(Vertice)it2.next();
		System.out.print(vg.idVertice+" ");
	};
	Contador = Contador +1;
	v.NumBusq = Contador;
	v.MasBajo = v.NumBusq;	
	//Itero sobre el conjunto de sucesores
	for(Iterator it=suc.iterator();it.hasNext();){
		Vertice w=(Vertice)it.next();
		System.out.println("w="+w.idVertice);
		//Si al vertice u todavia no se le ha asignado un predecesor, entonces se le asigna v
			//w.Pred=v;
		
		if (visitados.contains(w)==false ){//si u no ha sido visitado
			System.out.println(w.idVertice+".pred="+v.idVertice);
			w.Pred=v;
			for (Enumeration e = g.CjtoLados.elements();e.hasMoreElements();){
			Lado ladito = (Lado)e.nextElement();
				if ((v.idVertice.equals(ladito.idVerInic)==true && w.idVertice.equals(ladito.idVerFin)) ||(v.idVertice.equals(ladito.idVerFin) && w.idVertice.equals(ladito.idVerInic))){
					Aristas.push(ladito.idLado);
					System.out.println("Aristas.push"+ladito.idLado);
				}
			}
			
			DFS1(g,visitados, w, Aristas ,Contador,P,B);//Vuelvo a llamar al metodo con el vertice u
			for(Iterator itera=visitados.iterator();itera.hasNext();){
				Vertice verti=(Vertice)itera.next();
				System.out.println(verti.idVertice+"pre="+verti.Pred.idVertice);
			}
			
			HashSet sucArbol=new HashSet();
			int cont=0;
			for(Iterator iter=visitados.iterator();iter.hasNext();){
				Vertice vi=(Vertice)iter.next();
				if(vi.Pred.equals(v)){cont++;};
			};
			
			///////////////////////////////AQUI ESTA EL PROBLEMA!!!!! 
			if (((w.MasBajo >= v.NumBusq) && !(v.Pred==null)) || ((v.Pred==null) && (cont>1) )){
				if (v.Pred!=null){P.add(v);}
				for (Iterator i = Aristas.iterator(); i.hasNext();){
					String aB = (String)i.next();
					Lado ldo=(Lado)g.CjtoLados.get(aB);
					System.out.println(ldo.idLado);
					for(Enumeration e3=g.CjtoLados.elements();e3.hasMoreElements();){
						Lado loda=(Lado)e3.nextElement();
						if((v.idVertice.equals(loda.idVerInic)==true && w.idVertice.equals(loda.idVerFin)) ||(v.idVertice.equals(loda.idVerFin) && w.idVertice.equals(loda.idVerInic))){
							while(ldo.equals(loda)==false){
								String idl=(String)Aristas.peek();
								Aristas.pop();
								B.add(aB);
								System.out.println("B.add"+aB);
							};

						};
					};
					
				};
			};
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
			System.out.println(v.idVertice+".pred"+v.Pred.idVertice);
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

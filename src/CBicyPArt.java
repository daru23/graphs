import java.util.*;
import java.io.*;


class CBicyPArt{

	public static SalidaDFSM DFSM(Grafo g, HashSet P, HashSet B, Stack Aristas, int Contador, HashSet visitados, Vertice v){
		
		visitados.add(v);
		Contador++;
		v.NumBusq=Contador;
		Vertice w;
		v.MasBajo=v.NumBusq;
		HashSet ady=(HashSet)g.adyacentes(v.idVertice);
		for(Iterator it=ady.iterator();it.hasNext();){
			String s=(String)it.next();
			w=(Vertice)g.CjtoVertice.get(s);
			if (visitados.contains(w)==false){
				boolean ya=false;
				Enumeration e=g.CjtoLados.elements();
				while (ya==false && e.hasMoreElements()){
					Lado l=(Lado)e.nextElement();
					if(l.idVerInic.equals(v) && l.idVerFin.equals(w)){
						Aristas.push(l);
						w.Pred=v;
						SalidaDFSM x1=DFSM(g,P,B,Aristas,Contador,visitados,w);
						ya=true;
					};
					
				};
				Lado l=(Lado)Aristas.peek();
				if (w.MasBajo>=v.NumBusq){
					if(v.Pred!=null){
						P.add(v);
						Lado a=(Lado)Aristas.peek();
						while(a!=l){
							Aristas.pop();
							B.add(a);
							a=(Lado)Aristas.peek();
						};
						a=(Lado)Aristas.peek();
						Aristas.pop();
						B.add(a);
					};
				
				
				};
				if (w.MasBajo<v.MasBajo){
					v.MasBajo=w.MasBajo;
				};
			}
			else{
				if(v.NumBusq>w.NumBusq && v.Pred!=w){
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
						Lado l=(Lado)e.nextElement();
						if(l.idVerInic.equals(v) && l.idVerFin.equals(w)){
							Aristas.push(l);
						};
					};
					if (w.NumBusq<v.MasBajo){
						v.MasBajo=w.NumBusq;
					};
				};
			};
			
		};
		SalidaDFSM ult=new SalidaDFSM(P,B,visitados);
		
		return ult;
		

	};
	
	public static void DFSMAux(Grafo g){
		HashSet P=new HashSet();
		HashSet B=new HashSet();
		Stack Aristas=new Stack();
		HashSet visitados=new HashSet();
		int Contador=0;
		SalidaDFSM k=new SalidaDFSM(P,B,visitados);
		HashSet vertice=g.vertices(g);
		int nsuc=0;
		Vertice v;
		
		
		for(Iterator it=vertice.iterator();it.hasNext();){
			String s=(String)it.next();
			Vertice v1=(Vertice)g.CjtoVertice.get(s);
			if(visitados.contains(v1)==false){
				k=DFSM(g,P,B, Aristas,Contador,visitados,v1);
				visitados=(HashSet)SalidaDFSM.visitados;
				
			};
		};

	};




}
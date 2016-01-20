import java.util.*;
import java.lang.*;
import java.io.*;


class CtaCam{




/////*****************************************************************************************************************************************************************************************

public static HashSet DFS(Grafo g, Vertice partida, Vertice destino, Vertice v, HashSet Caminos){
	Grafo g1=g;
	LinkedList list=new LinkedList();
	
	
	
	//System.out.println("visitados"+visitados);
	HashSet suc=new HashSet();
	
	//lleno el HashSet suc con sucesores de v
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l1=(Lado)e.nextElement();
			
			if(l1.idVerInic.equals(v.idVertice)){
				
				Vertice w=(Vertice)g.CjtoVertice.get(l1.idVerFin);
				
					suc.add(w);
				
				
				
			};
	};
	
	
	
	//Itero sobre el conjunto de sucesores
	
	for(Iterator it=suc.iterator();it.hasNext();){
	Vertice w=(Vertice)it.next();
	//System.out.println("suc "+w.idVertice);
				
		w.Pred=v;
		//System.out.println(w.idVertice+".Pred="+v.idVertice);
		
		if(w.equals(destino)){
					
			
			list.addFirst(w.idVertice);
			while(w.Pred!=partida){
				list.addFirst(w.Pred.idVertice);
				w=w.Pred;
			};
			list.addFirst(partida.idVertice);
			//System.out.println("Camino"+list);
			Caminos.add(list);
					
			
			
		}
		else {
			for(Enumeration eaux=g.CjtoLados.elements();eaux.hasMoreElements();){
				Lado laux=(Lado)eaux.nextElement();
				//System.out.println("W"+w.idVertice);
				if (laux.idVerInic.equals(w.Pred.idVertice) && laux.idVerFin.equals(w.idVertice)){
					
				
						DFS(g1,partida,destino,w,Caminos);
						
					
				};
			};
			
		
		};
		
		
			
		
	};
	return Caminos;
	
};

//*********************************************************************************************************************************************************************************************
public static void DFSAux(Grafo g, String partida){
	
	LinkedList lista=new LinkedList();
	
	Vertice v1=(Vertice)g.CjtoVertice.get(partida);
	int costo=0;
	Grafo g1=g;
	v1.Pred=v1;
	Vertice v3=v1;
	HashSet vert=new HashSet();
	
	for(Enumeration enu=g.CjtoVertice.elements();enu.hasMoreElements();){
		HashSet Caminos=new HashSet();
		Vertice vet=(Vertice)enu.nextElement();
		if(!(vet.equals(v1))){
			System.out.print(partida+" " +vet.idVertice+" ");
			Caminos=DFS(g1,v1,vet,v3,Caminos);
			System.out.print(Caminos.size());
			System.out.println("");
		};
	};
	

	
		
	
};

//************************************************************************************************************************************************************************************************



public static Grafo Multiples(Grafo g,String v, String Dir) {
	
		////////////////////////////////////Es Dirigido o no Dirigido
				
	int cont3 = 0;									
	HashSet LadosM = new HashSet();
	if (Dir.equals("n")){
		/////////////////////////////////Determinar si tiene arcos multiples NO DIRIGIDO
		int m = 0;
		m = g.CjtoLados.size();
		int i=0;
		int j=0;
		int Mult = 0;
		String Lados [] = new String [m];
		i=0;
		for(Enumeration e= g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			Lados[i]=l.idLado;
			i=i+1;
		};
		//////////////////Existe mas de un lado con los mismos Extremos?
		
		for (i=0;i<m;i++){
		Lado First = (Lado)g.CjtoLados.get(Lados[i]);
		int cont=0;			
			for (j=0;j<m;j++){
			Lado Second = (Lado)g.CjtoLados.get(Lados[j]);
			if( (First.idVerInic.equals(Second.idVerInic)==true || First.idVerInic.equals(Second.idVerFin)==true) && (First.idVerFin.equals(Second.idVerInic)==true || First.idVerFin.equals(Second.idVerFin)==true)  ){
			cont=cont+1;	
			}
			}
		if (cont !=1) {LadosM.add(Lados[i]);}
		}
		///////////////Creando Nodos y Lados Ficcticios para que pueda aplicar el DFS
		for (Iterator it = LadosM.iterator();it.hasNext();){
		String ladM = (String)it.next();
		Lado ladito = (Lado) g.CjtoLados.get(ladM);
		String idI = (String) ladito.idVerInic;
		String idF = (String) ladito.idVerFin;
		Vertice iV = new Vertice (0,"f"+cont3+"");
		Arista lad1 = new Arista(0,"ef"+cont3+"",idI,iV.idVertice);
		Arista lad2 = new Arista(0,"lf"+cont3+"",iV.idVertice,idF);
		cont3 = cont3+1;
		g.agregarVertice(g,iV);
		((GrafoNoDirigido)g).agregarArista((GrafoNoDirigido)g,lad1);
		((GrafoNoDirigido)g).agregarArista((GrafoNoDirigido)g,lad2);
		((GrafoNoDirigido)g).eliminarArista((GrafoNoDirigido)g,ladM);
		}
	g.vertices(g);
	g.lados(g);
	
	DFSAux(g,v);
	
	//////////////Eliminando los Nodos y Lados Ficticios
	String LadosViejos [] = new String [cont3];
		i=0;
		for (Iterator it = LadosM.iterator(); it.hasNext();){
		String Ver = (String)it.next();
		LadosViejos [i]=Ver;
		i=i+1;
		} 
	for(i=0;i<cont3;i++){
		if (g.CjtoVertice.containsKey("f"+i+"")){
		//System.out.println("Si lo contiene");
		int jj =i+1;
		String nomb = LadosViejos[i];
		String vIni = "";
		String vFin = "";
			for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
				if(l.idLado.equals("ef"+i+"")==true){
				vIni = l.idVerInic;
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
					Lado ll=(Lado)e.nextElement();
						if(l.idLado.equals("lf"+jj+"")==true){
						vFin = ll.idVerFin;
						((GrafoNoDirigido)g).eliminarArista((GrafoNoDirigido)g,ll.idLado);
						}
						
					}
				((GrafoNoDirigido)g).eliminarArista((GrafoNoDirigido)g,l.idLado);
				}
			}
		((GrafoNoDirigido)g).eliminarVertice((GrafoNoDirigido)g,"f"+i+"");
		Arista Arc1 = new Arista (0,nomb,vIni,vFin);
		((GrafoNoDirigido)g).agregarArista((GrafoNoDirigido)g,Arc1);	
		
		}
	}
	g.vertices(g);
	g.lados(g);											
	}
	else if (Dir.equals("d")){
		/////////////////////////////////Determinar si tiene arcos multiples
		int m = 0;
		m = g.CjtoLados.size();
		int i=0;
		int j=0;
		int Mult = 0;
		String Lados [] = new String [m];
		i=0;
		for(Enumeration e= g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			Lados[i]=l.idLado;
			i=i+1;
		};
		//////////////////Existe mas de un lado con los mismos Extremos?
		for (i=0;i<m;i++){
		Lado First = (Lado)g.CjtoLados.get(Lados[i]);
		int cont=0;			
			for (j=0;j<m;j++){
			Lado Second = (Lado)g.CjtoLados.get(Lados[j]);
			if( (First.idVerInic.equals(Second.idVerInic)==true || First.idVerInic.equals(Second.idVerFin)==true) && (First.idVerFin.equals(Second.idVerInic)==true || First.idVerFin.equals(Second.idVerFin)==true)  ){
			cont=cont+1;	
			}
			}
		if (cont !=1) {LadosM.add(Lados[i]);}
		}
		///////////////Creando Nodos y Lados Ficcticios para que pueda aplicar el DFS
		for (Iterator it = LadosM.iterator();it.hasNext();){
		String ladM = (String)it.next();
		Lado ladito = (Lado) g.CjtoLados.get(ladM);
		String idI = (String) ladito.idVerInic;
		String idF = (String) ladito.idVerFin;
		Vertice iV = new Vertice (0,"f"+cont3+"");
		Arco lad1 = new Arco(0,"ef"+cont3+"",idI,iV.idVertice);
		Arco lad2 = new Arco(0,"lf"+cont3+"",iV.idVertice,idF);
		cont3 = cont3+1;
		g.agregarVertice(g,iV);
		((GrafoDirigido)g).agregarArco((GrafoDirigido)g,lad1);
		((GrafoDirigido)g).agregarArco((GrafoDirigido)g,lad2);
		((GrafoDirigido)g).eliminarArco((GrafoDirigido)g,ladM);
		}	
	g.vertices(g);
	g.lados(g);
	
	DFSAux(g,v);
	
	//////////////Eliminando los Nodos y Lados Ficticios
	String LadosViejos [] = new String [cont3];
		i=0;
		for (Iterator it = LadosM.iterator(); it.hasNext();){
		String Ver = (String)it.next();
		LadosViejos [i]=Ver;
		i=i+1;
		} 
	for(i=0;i<cont3;i++){
		if (g.CjtoVertice.containsKey("f"+i+"")){
		//System.out.println("Si lo contiene");
		int jj =i+1;
		String nomb = LadosViejos[i];
		String vIni = "";
		String vFin = "";
			for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
				if(l.idLado.equals("ef"+i+"")==true){
				vIni = l.idVerInic;
					for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
					Lado ll=(Lado)e.nextElement();
						if(l.idLado.equals("lf"+jj+"")==true){
						vFin = ll.idVerFin;
						((GrafoDirigido)g).eliminarArco((GrafoDirigido)g,ll.idLado);
						}
						
					}
				((GrafoDirigido)g).eliminarArco((GrafoDirigido)g,l.idLado);
				}
			}
		((GrafoDirigido)g).eliminarVertice((GrafoDirigido)g,"f"+i+"");
		Arco Arc1 = new Arco (0,nomb,vIni,vFin);
		((GrafoDirigido)g).agregarArco((GrafoDirigido)g,Arc1);	
		
		}
	}
	g.vertices(g);
	g.lados(g);
	
	};
	return g;
		
	
		
		
		
		
	//FIN
	}; 





}
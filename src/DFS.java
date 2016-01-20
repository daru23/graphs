import java.util.*;
import java.lang.*;
import java.io.*;


class DFS{




/////*****************************************************************************************************************************************************************************************


public static LinkedList DFS(Grafo g, Vertice partida, Vertice destino, Vertice v, double costo, double presupuesto,double maximo,LinkedList visitados){
	Grafo g1=g;
	LinkedList list=new LinkedList();
	
	//agrego a visitados el vertice v
	visitados.add(v); 
	//System.out.println("v "+v.idVertice);
	costo=costo+v.peso;
	//System.out.println("vpeso "+v.peso);
	for(Enumeration e1=g.CjtoLados.elements();e1.hasMoreElements();){
		Lado l1=(Lado)e1.nextElement();
		if(l1.idVerInic.equals(v.Pred.idVertice) && l1.idVerFin.equals(v.idVertice)){
			//System.out.println("lpeso "+l1.peso);
			costo=costo+l1.peso;
		};
	};
	
	
	
	//System.out.println("visitados"+visitados);
	HashSet suc=new HashSet();
	
	//lleno el HashSet suc con sucesores de v
	for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l1=(Lado)e.nextElement();
			Vertice w=(Vertice)g.CjtoVertice.get(l1.idVerFin);
			
			if(l1.idVerInic.equals(v.idVertice) && l1.idVerFin.equals(w.idVertice) && costo+w.peso+l1.peso<presupuesto && l1.peso<=maximo){
			
				suc.add(w);
				
						
			};
			
			
	};

	
	for(Iterator it=suc.iterator();it.hasNext();){
	Vertice u=(Vertice)it.next();
		//System.out.println("suce "+u);
		//System.out.println("v "+v.idVertice);
		
		//Si al vertice u todavia no se le ha asignado un predecesor, entonces se le asigna v
		if (visitados.contains(u)==false){//si u no ha sido visitado
			u.Pred=v;
			//System.out.println(u.idVertice+".Pred="+v.idVertice);
			//System.out.println("hola");
			
			//Vuelvo a llamar al metodo con el vertice u
			DFS(g,partida, destino, u, costo,presupuesto, maximo,visitados);
			
		};
		
	};
	
	
	return visitados;
	
	
};

//*********************************************************************************************************************************************************************************************

public static void DFSAux(Grafo g, String v, String destino,double presupuesto,double maximo){
	
	LinkedList visitados=new LinkedList();
	Vertice v1=(Vertice)g.CjtoVertice.get(v);
	double costo=0;
	//System.out.println(v1+" "+v1.idVertice);
	//System.out.println(v1.idVertice);
	Grafo g1=g;
	v1.Pred=v1;
	Vertice v3=(Vertice)g.CjtoVertice.get(destino);
	Vertice v4=v1;
	LinkedList list=new LinkedList();
	visitados=DFS(g,v1,v3,v4, costo,presupuesto, maximo, visitados);
	
	System.out.println(" ");
	System.out.println("El camino es:");
	
	Vertice r=(Vertice)g.CjtoVertice.get(destino);
		
		while(r.Pred!=v1){
			for(Enumeration enu=g.CjtoLados.elements();enu.hasMoreElements();){
				Lado aux=(Lado)enu.nextElement();
				if(aux.idVerInic.equals(r.Pred.idVertice) && aux.idVerFin.equals(r.idVertice)){
					System.out.print(aux.idLado);
					System.out.print(" ");
					costo=costo+aux.peso;
					
				};
				
			};
			list.addLast(r.Pred);
			System.out.println(r.idVertice);
			costo=costo+r.peso;
			r=r.Pred;
		};
	
	list.addLast(v1);
	
	for(Enumeration enu=g.CjtoLados.elements();enu.hasMoreElements();){
				Lado aux=(Lado)enu.nextElement();
				if(aux.idVerInic.equals(r.Pred.idVertice) && aux.idVerFin.equals(r.idVertice)){
					System.out.print(aux.idLado);
					System.out.print(" ");
					costo=costo+aux.peso;
					
				};
				
	};
	costo=costo+r.peso;
	System.out.println(r.idVertice);
	
	System.out.println(v1.idVertice);
	costo=costo+v1.peso;
	presupuesto=presupuesto-costo;
	System.out.println("El presupuesto restante es "+presupuesto);
	
	
	
	
	
};


//************************************************************************************************************************************************************************************************



public static Grafo Multiples(Grafo g,String v, String u, String Dir, double presupuesto, double maximo) {
	
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
	
	DFSAux(g,v,u,presupuesto,maximo);
	
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
	
	DFSAux(g,v,u,presupuesto,maximo);
	
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
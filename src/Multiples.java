import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.HashSet;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Iterator;

class Multiples {
	public static void main (String args[]) throws IOException  {
	
		////////////////////////////////// Ingresa la ruta del archivo		
		System.out.println("Ingrese el nombre y la ubicacion del archivo");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String Archivo = br.readLine();
		Grafo g=new GrafoDirigido();
		g=g.Grafo(Archivo);
		////////////////////////////////////Es Dirigido o no Dirigido
				File file = new File(Archivo);
				String line;
				FileReader filer= new FileReader(file);
				BufferedReader buf=new BufferedReader(filer);
				String linea=buf.readLine().trim();
				
				StringTokenizer token = new StringTokenizer(linea);
				String Dir = token.nextToken();
				linea=buf.readLine().trim();
				token = new StringTokenizer(linea);
				int nL = Integer.parseInt(token.nextToken());
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
		System.out.println("Si lo contiene");
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
		System.out.println("Si lo contiene");
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
	
	}
		
	
		
		
		
		
	//FIN
	}

}
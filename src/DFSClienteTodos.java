import java.util.*;
import java.lang.*;
import java.io.*;


class CuentaCaminos extends CtaCam {

public static void main (String args[]) throws IOException{
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g = new GrafoNoDirigido();
	g=g.Grafo(Archivo);
	System.out.println("Indique el vertice inicial");
	String partida=br.readLine();
	
	File file = new File(Archivo);
	String line;
	FileReader filer= new FileReader(file);
	BufferedReader buf=new BufferedReader(filer);
	String linea=buf.readLine().trim();
	StringTokenizer token = new StringTokenizer(linea);
	String Dir = token.nextToken();
	

	Grafo gaux=Multiples(g,partida,Dir);
	//Caminos=Multiplies(g,partida,destino,presupuesto,maximo);
	
	//Falta..... como el DFS devuelve un solo camino por cada nodo alcanzable, no conseguimos mas de una llegada de partida a destino, debemos modificar el DFS, pero nos dimos cuenta tarde!!!! lo traeremos listo el proximo martes  xD!
	
	
		/*for(Iterator it1=visitados.iterator();it1.hasNext();){
			Vertice r=(Vertice)it1.next();
			list=new LinkedList();
			list.add(r);
			double costo=0.0;
			while( r.Pred.idVertice!=partida && valido){/////<-----malo
				costo=costo+r.peso;
				System.out.println("hola1");
				for(Enumeration e1=g.CjtoLados.elements();e1.hasMoreElements();){
					Lado l=(Lado)e1.nextElement();
					System.out.println("hola2");
					System.out.println("r "+r.idVertice+"r.Pre "+r.Pred.idVertice);
					if (l.idVerInic.equals(r.Pred.idVertice) && l.idVerFin.equals(r.idVertice)){
						System.out.println("hola3");
						if (l.peso<=maximo){
							costo=costo+l.peso;
							list.add(r.Pred);
							System.out.println("hola4");
						}
						else{valido=false;};
					}
				};
				Double c = new Double(costo);
				caminos.put(list,c);
				r=r.Pred;
			};*/
	
			
			/*Vertice primero=(Vertice)list.getFirst();
			System.out.println("Camino hasta el vertice "+primero.idVertice+":");
			for(Iterator it=list.iterator();it.hasNext();){
				Vertice r2=(Vertice)it.next();
				System.out.print(r2.idVertice);
			
			};
			Vertice ultimo=(Vertice)list.getLast();
			if(ultimo.equals(v1)==false){
				System.out.print(v1.idVertice);
			};*/
		
		}
	}

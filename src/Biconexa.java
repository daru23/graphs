import java.util.*;
import java.io.*;

class Biconexa extends CBicyPArt {

	public static void main (String args[]) throws IOException{
		System.out.println("Ingrese el nombre y la ubicacion del archivo");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String Archivo = br.readLine();
		Grafo g=new GrafoDirigido();
		g=g.Grafo(Archivo);
		Vertice v1=new Vertice(0.0,"b");
		boolean ya=false;
		Enumeration e=g.CjtoVertice.elements();
		while(ya=false && e.hasMoreElements()){
			Vertice v=(Vertice)e.nextElement();
			ya=true;
			v1=v;
		}
		System.out.println(v1);
		Vertice ver=(Vertice)g.CjtoVertice.get(v1);
		
		 DFSMAux(g);
	}

}
import java.util.*;
import java.lang.*;
import java.io.*;


class DFSCliente extends DFS {

public static void main (String args[]) throws IOException{
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g=new GrafoDirigido();
	g=g.Grafo(Archivo);
	System.out.println("Ingrese el identificador del vertice");
	String v = br.readLine();
	
	DFSAux(g,v);
	
	
};

}
import java.util.*;
import java.lang.*;
import java.io.*;


class DFSCliente1 extends DFS1 {

public static void main (String args[]) throws IOException{
	
	//Leoeel archivo
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g=new GrafoDirigido();
	g=g.Grafo(Archivo);
	
	//Lee el archivo para determinar si es dirigido o no
	File file = new File(Archivo);
	String line;
	FileReader filer= new FileReader(file);
	BufferedReader buf=new BufferedReader(filer);
	String linea=buf.readLine().trim();
	StringTokenizer token = new StringTokenizer(linea);
	String Dir = token.nextToken();
	
	
	System.out.println("Ingrese el identificador del vertice");
	String v = br.readLine();
	
	//Llama al metodo Multiples
	Grafo gaux=Multiples(g,v,Dir);
	
	
};

}
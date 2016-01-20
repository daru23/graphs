import java.util.*;
import java.lang.*;
import java.io.*;


class TuristaDFS extends DFS {

public static void main (String args[]) throws IOException{
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g = new GrafoNoDirigido();
	g=g.Grafo(Archivo);
	System.out.println("Indique la ciudad de donde comenzará el viaje");
	String partida=br.readLine();
	System.out.println("Indique la ciudad de destino");
	String destino=br.readLine();
	System.out.println("Indique su presupuesto");
	double presupuesto=Double.parseDouble(br.readLine());
	System.out.println("Indique la cantidad máxima que está dispuesto a pagar por viaje");
	double maximo=Double.parseDouble(br.readLine());
	
	
	File file = new File(Archivo);
	String line;
	FileReader filer= new FileReader(file);
	BufferedReader buf=new BufferedReader(filer);
	String linea=buf.readLine().trim();
	StringTokenizer token = new StringTokenizer(linea);
	String Dir = token.nextToken();
	

	Grafo gaux=Multiples(g,partida,destino,Dir,presupuesto,maximo);
	
		
		}
	}

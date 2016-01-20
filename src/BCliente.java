import java.util.*;
import java.lang.*;
import java.io.*;

class BCliente extends Biconexas {

public static void main (String args[]) throws IOException{
	System.out.println("Ingrese el nombre y la ubicacion del archivo");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String Archivo = br.readLine();
	Grafo g = new GrafoNoDirigido();
	g=g.Grafo(Archivo);
	
	Biconexas(g);
	
	
};
}
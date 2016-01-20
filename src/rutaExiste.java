import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Iterator;

class rutaExiste{
				
		public static void main (String args[]) throws IOException  {
		////////////////////////////////// Ingresa la ruta del archivo		
		System.out.println("Ingrese el nombre y la ubicacion del archivo");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String Archivo = br.readLine();
		Grafo g=new GrafoDirigido();
		g=g.Grafo(Archivo);
		
		
		////////////////////////////////////////Ingresa Ciudad 1
		System.out.println("Ingrese el nombre de la ciudad 1");
		InputStreamReader isr1=new InputStreamReader(System.in);
		BufferedReader br1=new BufferedReader(isr1);
		String Ciudad = br1.readLine();
		
		////////////////////////////////////////Ingresa Ciudad 2
		System.out.println("Ingrese el nombre de la ciudad 2");
		InputStreamReader isr2=new InputStreamReader(System.in);
		BufferedReader br2=new BufferedReader(isr2);
		String Ciudad2 = br2.readLine();
		
		////////////////////////////////////////Creando la Matriz de Adyacencia
		int n = 0;
		n = g.CjtoVertice.size();
		int adyac [][] = new int [n][n];
		int count = 0;
		Hashtable ahah = new Hashtable();
		/////////Enumerando los Nodos
		for( Enumeration e = g.CjtoVertice.elements(); e.hasMoreElements();) { 
		Vertice Ver = (Vertice)e.nextElement();
		String idVer= Ver.idVertice;
		String countS = count+"";
		ahah.put(Ver.idVertice, countS);
		count=count +1;
		}
		////////Creando la Matriz de Adyacencia
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
				Lado l=(Lado)e.nextElement();
				String Obt1 = (String) ahah.get(l.idVerInic);
				int num1 = Integer.parseInt(Obt1);
				String Obt = (String)ahah.get(l.idVerFin);
				int num = Integer.parseInt(Obt);
				adyac [num1][num]= 1;
		}
		
		int i,j,k=0;
		// for (i=0;i<n;i++){
			// for(j=0;j<n;j++)
				// System.out.print(adyac[i][j]+" ");
				// System.out.println("");
		// }
	
		
		int alcance [][] = new int [n][n];
		int identidad [][] = new int [n][n];	
			for (i=0;i<n;i++){
				for(j=0;j<n;j++)
				if (i==j){identidad[i][j]=1;}
			}
			// for (i=0;i<n;i++){
			// for(j=0;j<n;j++)
				// System.out.print(identidad[i][j]+" ");
				// System.out.println("");
			// }
		for (i=0;i<n;i++){
				for(j=0;j<n;j++)
				alcance[i][j]= adyac[i][j]+identidad[i][j];
		}
		
		
		
		// System.out.println("Matriz de Adyacencia + Identidad");
			// for (i=0;i<n;i++){
			// for(j=0;j<n;j++)
				// System.out.print(alcance[i][j]+" ");
				// System.out.println("");
				   // }
	////////////// Creando Matriz de alcance
		for (k=0;k<n;k++){
			for(i=0;i<n;i++){
				if ((i!=k) & (alcance[i][k]==1)) { 
					for(j=0;j<n;j++){
					alcance[i][j]=alcance[i][j]+alcance[k][j];
					}
				}
		
			}
		}
		//Imprimiendo Matriz de Alcance
		// System.out.println("Matriz de Adyacencia Final");
			// for (i=0;i<n;i++){
				// for(j=0;j<n;j++)
					// System.out.print(alcance[i][j]+" ");
					// System.out.println("");
			// }
		
		////////////////////Ver si existe camino de Ciudad a Ciudad 2 /////////////////////////
		String City = (String) ahah.get(Ciudad);
		int numC = Integer.parseInt(City);
		String City2 = (String) ahah.get(Ciudad2);
		int numC2 = Integer.parseInt(City2);
		if (alcance[numC][numC2]!=0) {System.out.println("SI");}
		else System.out.println("NO");
		};
		
		
		
		
		
		
	
}
		
		
		
		
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Iterator;

class rutasMaximas{
		public static void main (String args[]) throws IOException  {
		////////////////////////////////// Ingresa la ruta del archivo		
		System.out.println("Ingrese el nombre y la ubicacion del archivo");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String Archivo = br.readLine();
		Grafo g=new GrafoDirigido();
		g=g.Grafo(Archivo);
		
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
		int alcance [][] = new int [n][n];
		int identidad [][] = new int [n][n];	
			for (i=0;i<n;i++){
				for(j=0;j<n;j++)
				if (i==j){identidad[i][j]=1;}
			}
		////////////// Creando Matriz de alcance
		for (i=0;i<n;i++){
				for(j=0;j<n;j++)
				alcance[i][j]= adyac[i][j]+identidad[i][j];
		}

	
		for (k=0;k<n;k++){
			for(i=0;i<n;i++){
				if ((i!=k) & (alcance[i][k]==1)) { 
					for(j=0;j<n;j++){
					alcance[i][j]=alcance[i][j]+alcance[k][j];
					}
				}
		
			}
		}
////////////////////////Rutas Cerradas Disjuntas//////////////////////////////
		HashSet CompCon = new HashSet();
		String compare;
		String compares;
		
		for( Enumeration e = g.CjtoVertice.keys(); e.hasMoreElements();) { 
					String idVer = (String)e.nextElement();
					Vertice v = new Vertice(0,idVer);
					String Alc = (String) ahah.get(v.idVertice);
					int numA = Integer.parseInt(Alc);
					HashSet Comp = new HashSet();
					for(j=0; j<n;j++){
						if (alcance[numA][j]!=0 ){
							compare = j+"";
								for( Enumeration e = ahah.keys(); e.hasMoreElements();) { 
									String Ver = (String)e.nextElement();
									compares = (String) ahah.get(Ver);
									if (compares.equals(compare)){
										Comp.add(Ver);
									
									}
								}
								
						}
					}
			CompCon.add(Comp);
			}
		///////////Haciendo las Rutas Disjuntas//////////////
		String Nodos [] = new String [n];
		i=0;
		for (Enumeration e = g.CjtoVertice.keys(); e.hasMoreElements();){
		String Ver = (String)e.nextElement();
		Nodos [i]=Ver;
		i=i+1;
		} 
		HashSet CjtoD = new HashSet();		
		for (i=0;i<n;i++){
		HashSet Hset = new HashSet();
		for (Iterator it = CompCon.iterator(); it.hasNext();){
			HashSet set = (HashSet)it.next();
			if (set.contains(Nodos[i])){
				for(Iterator jt = set.iterator();jt.hasNext();){
				String nomb = (String)jt.next();
				Hset.add(nomb);
				}
			}
		}
		CjtoD.add(Hset);
		}
		Hashtable CjtoD2 = new Hashtable();	
		for (i=0;i<n;i++){
		HashSet Hset = new HashSet();
		for (Iterator it = CjtoD.iterator(); it.hasNext();){
			HashSet set = (HashSet)it.next();
			if (set.contains(Nodos[i])){
				for(Iterator jt = set.iterator();jt.hasNext();){
				String nomb = (String)jt.next();
				Hset.add(nomb);
				}
			}
		}
		CjtoD2.put(Hset,"");
		}
		//////////////////Imprimir los conjuntos Disjuntos//////////////
		int R =1;
		for( Enumeration e = CjtoD2.keys(); e.hasMoreElements();) { 
		HashSet v1 = (HashSet)e.nextElement();
		System.out.println("Ruta "+R+": "+v1);
		R=R+1;
		 };	
		
		
	
}



}
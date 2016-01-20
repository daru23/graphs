
import java.io.*;
import java.util.*;



public abstract class Grafo {

		
	public Grafo(){};
	
	
	Hashtable CjtoVertice=new Hashtable();
	Hashtable CjtoLados=new Hashtable();
	
	
	
	/////////////////////////////////////////////////////////Crear grafo a partir de un archivo ///////////////////////////////////////////////
	public Grafo Grafo(String n) {
	
				Grafo g = null;
				
				
				
				File file = new File(n);
				
				try{ 
						
							
						String line;
						
						FileReader filer= new FileReader(file);
						BufferedReader buf=new BufferedReader(filer);
						String linea=buf.readLine().trim();
						
						boolean seguir = true;
						
						
						
								if(linea!= null){
								
									if(!linea.equals("d") && !linea.equals("n")){
									System.out.println("El archivo está mal escrito" );
									
									}
									else{
										StringTokenizer token = new StringTokenizer(linea);
										String Dir = token.nextToken();
										
										linea=buf.readLine().trim();
										token = new StringTokenizer(linea);
										int nV = Integer.parseInt(token.nextToken());
										token = new StringTokenizer(linea);
										linea=buf.readLine().trim();
										token = new StringTokenizer(linea);
										int nL = Integer.parseInt(token.nextToken());
										boolean dirigido=false;
										
										
										if(Dir.equals("d")){ 
											System.out.println("Dirigido");
											g = new GrafoDirigido();
											dirigido=true;
										}
										else if (Dir.equals("n")) {
											System.out.println("NoDirigido");
											g = new GrafoNoDirigido();
											dirigido=false;
										}
										
											int i=0;
											while(i<nV && (linea=buf.readLine().trim())!= null){
												
												token = new StringTokenizer(linea);
												String idVer = token.nextToken();
												double peso = Double.parseDouble(token.nextToken());
												Vertice ver=new Vertice(peso,idVer);
												g.agregarVertice(g,ver);
												i++;
					
											}
											
											i=0;
											while(i<nL && (linea=buf.readLine().trim())!= null){
												
												token = new StringTokenizer(linea);
												String idL = token.nextToken();
												String idv1= token.nextToken();
												String idv2= token.nextToken();
												double peso2 = Double.parseDouble(token.nextToken());
												
												if(dirigido==true){
													Arco ac = new Arco(peso2,idL,idv1,idv2);
													((GrafoDirigido)g).agregarArco(((GrafoDirigido)g),ac);
												}
												else {
													Arista at = new Arista(peso2,idL,idv1,idv2);
													((GrafoNoDirigido)g).agregarArista(((GrafoNoDirigido)g),at);
												}
												;i++;
												
											}
											;System.out.println("El grafo se creo exitosamente!!");
											g.vertices(g);
											g.lados(g);
										
										
								    }
									
								}	
					buf.close(); 	
				
					}
	
					
			
			
			catch (FileNotFoundException e) {System.out.println("El archivo no existe"); g = new GrafoDirigido();}
			
			catch (IOException e) {System.out.println("Excepcion, intente de nuevo");}		
					
	return g;						
	}

	/////////////////////////////////////////////////////////Agregar Vertice  ///////////////////////////////////////////////
	public void agregarVertice(Grafo g, Vertice v){
		
		CjtoVertice.put(v.idVertice,v);
			
			
	};
	
	/////////////////////////////////////////////////////////Eliminar vertice ///////////////////////////////////////////////
	public void eliminarVertice(Grafo g, String idVertice){
		g.CjtoVertice.remove(idVertice);
		
		for(Enumeration e=g.CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
		
			if(l.idVerInic.equals(idVertice) || l.idVerFin.equals(idVertice)){
			g.CjtoLados.remove(l.idLado);
			}
		};
		
	};
	
	/////////////////////////////////////////////////////////Mostrar vertices ///////////////////////////////////////////////
	public HashSet vertices(Grafo g){
		
		HashSet aux=new HashSet();
		for( Enumeration e = g.CjtoVertice.elements(); e.hasMoreElements();) { 
			Vertice v1 = (Vertice)e.nextElement();
			aux.add(v1.idVertice);
			
		};	
		return aux;

	};
	
	/////////////////////////////////////////////////////////Mostrar lados ///////////////////////////////////////////////
	public HashSet lados(Grafo g){
		
		HashSet aux=new HashSet();
		for( Enumeration e = g.CjtoLados.keys(); e.hasMoreElements();) { 
			String l = (String)e.nextElement();
			aux.add(l);
			
		};
		return aux;
	}
	
	/////////////////////////////////////////////////////////Grado de un vertice ///////////////////////////////////////////////
	public int grado(String idVer){
		int grado=0;
		//System.out.println("El grado del vertice "+ idVer+ " es:");
		HashSet aux=new HashSet();			
		for(Enumeration e=CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(idVer)==true || l.idVerFin.equals(idVer)==true){
				grado++;
			};
							
		};
		return grado;
	}
	/////////////////////////////////////////////////////////Lista de Adyacencias ///////////////////////////////////////////////
	public  HashSet adyacentes(String idVer){
	 		
		System.out.println("El conjunto de adyacencias de "+ idVer+ " es:");
		HashSet aux=new HashSet();			
		for(Enumeration e=CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(idVer)==true){
				aux.add(l.idVerFin);
			}
			else if(l.idVerFin.equals(idVer)==true){
				aux.add(l.idVerInic);
			};
					
		};
		return aux;
						
						
	 };
	 
	 /////////////////////////////////////////////////////////Lista de Incidencias ///////////////////////////////////////////////
	 public HashSet incidentes(String idVer){
	 		
		System.out.println("El conjunto de incidencias de "+ idVer+ " es:");
		HashSet aux=new HashSet();			
		for(Enumeration e=CjtoLados.elements();e.hasMoreElements();){
			Lado l=(Lado)e.nextElement();
			if(l.idVerInic.equals(idVer)==true || l.idVerFin.equals(idVer)==true ){
				aux.add(l);
			};
							
		};
		return aux;
						
						
	 };
			
	
	/////////////////////////////////////////////////////////Crear un archivo de un grafo  ///////////////////////////////////////////////
	public void guardar (Grafo g, String n) throws IOException{
		File archivo = new File ("C:/Documents and Settings/Administrator/Desktop/Proyecto1 06-40476,06-40273/bin/doc/Guardado.txt");
		int count;
		int tamL;
		int tamV;
		FileWriter txt = new FileWriter(archivo);
		PrintWriter out = new PrintWriter(txt);
		tamL=CjtoLados.size();
		tamV=CjtoVertice.size();
		out.println("Grafo g\n");
		out.println("Numero de Vertices: "+tamV);
		out.println("Numeros de Lados: "+tamL);
		out.println("Vértices:");
			
		for (Enumeration e=CjtoVertice.keys();e.hasMoreElements();){
			String X = (String)e.nextElement();
			Vertice y = (Vertice)CjtoVertice.get(X);
			out.println(X);
		}
		out.println("Lados:");
		for (Enumeration e=CjtoLados.keys();e.hasMoreElements();){
			String v = (String) e.nextElement();
			Lado w = (Lado)CjtoLados.get(v);
			out.println(v);
	
		}
		out.close();

	};	
	
	
	
	
	
	

}


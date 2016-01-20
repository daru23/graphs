import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.HashSet;
import java.util.HashMap;
import org.jmlspecs.models.JMLValueSequence;
import org.jmlspecs.models.JMLString;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import java.io.*;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.*;
import java.util.Hashtable;


class Cliente{

	
	
	
	//************************************************************************************************************************************************************************************
	//////////////////////////////////////////////////////////////////////////////////////////Menu Principal/////////////////////////////////////////////////////////////////////////////////
	//*************************************************************************************************************************************************************************************
	public static void main (String args[]) throws IOException  {
	
	
	boolean seguir=true;
	
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	while(seguir){
	
	System.out.println(" ");
	System.out.println("************************* Menu principal **************************");
	System.out.println(" ");
	System.out.println("Qué desea hacer:");
	System.out.println(" ");
	System.out.println("1. Construir un grafo dirigido");
	System.out.println("2. Construir un grafo no dirigido");
	System.out.println("3. Construir un grafo a partir de un archivo existente");
	System.out.println("4. Salir");
	try{
	int s=Integer.parseInt(br.readLine());
	
	
		/////////////////////////////////////////////////////////////////// Menu GrafoDirigido/////////////////////////////////////////////////////////
		if (s==1){
		
		InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			Grafo g= new GrafoDirigido();
			boolean seguir1=true;
		
			while(seguir1){
			
			System.out.println(" ");
			System.out.println("******************* Menu para grafos dirigidos ****************************");
			System.out.println(" ");
			System.out.println("Qué desea hacer:");
			System.out.println(" ");
			System.out.println("1. Agregar vértice");
			System.out.println("2. Eliminar vértice");
			System.out.println("3. Agregar arco");
			System.out.println("4. Eliminar arco");
			System.out.println("5. Mostrar vértices del grafo");
			System.out.println("6. Mostrar lados del grafo");
			System.out.println("7. Grado de un vértice");
			System.out.println("8. Grado interior de un vértice");
			System.out.println("9. Grado exterior de un vértice");
			System.out.println("10. Sucesores de un vértice");
			System.out.println("11. Predecesores de un vértice");
			System.out.println("12. Conjunto de adyacencias de un vértice");
			System.out.println("13. Cojunto de incidencias de un vértice");
			System.out.println("14. Guardar");
			System.out.println("15. Regresar al menu anterior");
			
			try {
			int s1=Integer.parseInt(br.readLine());
			
		
				if (s1==1) {//agregar vertice
					boolean agrego=false;

					while (agrego==false){
						System.out.println("Ingrese el identidificador del vértice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==false){
						System.out.println("Ingrese el peso");
						int peso=Integer.parseInt(br.readLine());
						Vertice v=new Vertice(peso,idVer);
						g.agregarVertice(g,v);
						agrego=true;}
						else{System.out.println("El vertice introducido ya existe. Intente nuevamente");};
						
						};
				
				} 
				
				else if (s1==2){//eliminar vertice		
				boolean eliminado=false;
					while(eliminado==false){
						System.out.println("Indique el identificador del vertice que quiere eliminar");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							g.eliminarVertice(g,idVer);
							eliminado=true;
						}
						else{System.out.println("El vertice"+idVer+" no existe.Intente nuevamente");};
					};
				}
				
				else if (s1==3) {//agregar arco
					boolean agregado=false;
					while(agregado==false){
						
						System.out.println("Ingrese el identidificador del arco");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idAr = br1.readLine();
						if (g.CjtoLados.containsKey(idAr)==false){
							System.out.println("Ingrese el peso");
							int peso=Integer.parseInt(br.readLine());
							boolean valido=false;
							while (valido==false){
								System.out.println("Indique el identificador del vertice inicial");
								String idv1 = br1.readLine();
								System.out.println("Indique el identificador del vertice final");
								String idv2 = br1.readLine();
								if (g.CjtoVertice.containsKey(idv1)==true && g.CjtoVertice.containsKey(idv2)==true){
									Arco a=new Arco(peso,idAr,idv1,idv2);
									((GrafoDirigido)g).agregarArco(((GrafoDirigido)g),a);
									System.out.println("El arco "+idAr+ " se ha agregado");
									valido=true;
									agregado=true;
								}
							
								else{
									System.out.println("Uno o ambos vértices no existen en el grafo. Intente nuevamente");
									System.out.println(" ");
								};
							};
						}
						else{System.out.println("Ese arco ya existe. Intente nuevamente");};	
					};
				}				
				
				
				else if (s1==4) {//eliminar arco
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identidificador del arco a eliminar");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idAr = br1.readLine();
					
						if(g.CjtoLados.containsKey(idAr)==true){
							((GrafoDirigido)g).eliminarArco(((GrafoDirigido)g),idAr);
							System.out.println("El arco "+idAr+" se ha eliminado");
							esta=true;
						}
						else{
						System.out.println("El arco "+ idAr+ "no se encuentra en el grafo. Intente nuevamente2");
						};
					};	
				}
				
				else if (s1==5) {//mostrar vertices
					if(g.CjtoVertice.isEmpty()==true){
					System.out.println("No hay vertices en el grafo");
					}
					else{
						System.out.println("Los vértices del Grafo son:");
						HashSet aux=g.vertices(g);
						for(Iterator it=aux.iterator();it.hasNext();){
							String t=(String)it.next();
							System.out.println(t);
						}
					};
							
				}	
				
				
				else if (s1==6) {//mostrar lados
					if (g.CjtoLados.isEmpty()==true){
					System.out.println("No hay lados en el grafo");
					}
					else {
						System.out.println("Los lados del Grafo son:");
						HashSet aux=g.lados(g);
						for(Iterator it=aux.iterator();it.hasNext();){
							String t=(String)it.next();
							System.out.println(t);
						}
					};
				}
				
				else if (s1==7) {//grado de un vertice
				
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							int grade=g.grado(idVer);
							System.out.println("El grado del vertice "+ idVer+ " es:");
							System.out.println(grade);
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
				
				}
				
				else if (s1==8) {//grado  interior de un vertice
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							((GrafoDirigido)g).gradoInterior(((GrafoDirigido)g),idVer);
							esta=true;
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
						
				}
				
				else if (s1==9) {//grado  exterior de un vertice
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							((GrafoDirigido)g).gradoExterior(((GrafoDirigido)g),idVer);
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
						
				}
				
				else if (s1==10) {//sucesores de un vertice
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							System.out.println("Los sucesores de "+ idVer+ " son:");
							HashSet aux=((GrafoDirigido)g).sucesores(((GrafoDirigido)g),idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								String l1=(String)it.next();
								System.out.println(l1);
							};
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
						
				}
				
				else if (s1==11) {//predecesores de un vertice
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							System.out.println("Los sucesores de "+ idVer+ " son:");
							HashSet aux=((GrafoDirigido)g).predecesores(((GrafoDirigido)g),idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								String l1=(String)it.next();
								System.out.println(l1);
							};
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
						
				}
				
				else if (s1==12){//mostrar vertices adyacentes
					boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							HashSet aux=g.adyacentes(idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								String l1=(String)it.next();
								System.out.println(l1);
							};	
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
				
				}		
				
				else if (s1==13){//mostrar lados incidentes
				
				boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							HashSet aux=g.incidentes(idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								Lado l1=(Lado)it.next();
								System.out.println(l1.idLado);
							};
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
				
				}		
				
				
				else if (s1==14) {
				System.out.println("Se ha creado el Archivo");
		
				((Grafo)g).guardar(g, "text");

				}

				else if(s1==15){seguir1=false;}	
			
				else{System.out.println("Por favor indique una opcion de la lista");}
			}catch (NumberFormatException ex){System.out.println("Se ha introducido un caracter no numerico");}
			};
		}
		
		
		
			
		/////////////////////////////////////////////////////////////////// Menu GrafoNoDirigido////////////////////////////////////////////////////////
		else if (s==2){ 
			

			boolean seguir2=true;
			Grafo g=new GrafoNoDirigido();
			
			while(seguir2){
	
			System.out.println(" ");
			System.out.println("******************* Menu para grafos no dirigidos **************************");
			System.out.println(" ");
			System.out.println("Qué desea hacer:");
			System.out.println(" ");
			System.out.println("1. Agregar vértice");
			System.out.println("2. Eliminar vértice");
			System.out.println("3. Agregar arista");
			System.out.println("4. Eliminar arista");
			System.out.println("5. Mostrar vértices del grafo");
			System.out.println("6. Mostrar lados del grafo");
			System.out.println("7. Grado de un vértice");
			System.out.println("8. Nodos adyacentes a un vértice");
			System.out.println("9. Lados incidentes a un vértice");
			System.out.println("10. Guardar");
			System.out.println("11. Regresar al menu inicial");
			
			try{
				int s2=Integer.parseInt(br.readLine());
			
				if (s2==1) {//agregar vertice
			
				boolean agrego=false;

				while (agrego==false){
					System.out.println("Ingrese el identidificador del vértice");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String idVer = br1.readLine();
					if (g.CjtoVertice.containsKey(idVer)==false){
					System.out.println("Ingrese el peso");
					int peso=Integer.parseInt(br.readLine());
					Vertice v=new Vertice(peso,idVer);
					g.agregarVertice(g,v);
					agrego=true;}
					else{System.out.println("El vertice introducido ya existe. Intente nuevamente");};
						
				};
				
			}
			else if (s2==2){//eliminar vertice		
				boolean eliminado=false;
				while(eliminado==false){
					System.out.println("Indique el identificador del vertice que quiere eliminar");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String idVer = br1.readLine();
					if (g.CjtoVertice.containsKey(idVer)==true){
						g.eliminarVertice(g,idVer);
						eliminado=true;
					}
					else{System.out.println("El vertice"+idVer+" no existe.Intente nuevamente");};
				};
			}
			
			else if (s2==3) {//agregar arista
				boolean agregado=false;
				while(agregado==false){
						
					System.out.println("Ingrese el identidificador de la arista");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String idAr = br1.readLine();
					if (g.CjtoLados.containsKey(idAr)==false){
						System.out.println("Ingrese el peso");
						int peso=Integer.parseInt(br.readLine());
						boolean valido=false;
						while (valido==false){
							System.out.println("Indique el identificador del vertice inicial");
							String idv1 = br1.readLine();
							System.out.println("Indique el identificador del vertice final");
							String idv2 = br1.readLine();
							if (g.CjtoVertice.containsKey(idv1)==true && g.CjtoVertice.containsKey(idv2)==true){
								Arista a=new Arista(peso,idAr,idv1,idv2);
								((GrafoNoDirigido)g).agregarArista(((GrafoNoDirigido)g),a);
								System.out.println("La arista "+idAr+ " se ha agregado");
								valido=true;
								agregado=true;
							}
						
							else{
								System.out.println("Uno o ambos vértices no existen en el grafo. Intente nuevamente");
								System.out.println(" ");
							};
						};
					}
					else{System.out.println("La arista ya existe. Intente nuevamente");
					};	
				};
			}
			
			else if (s2==4) {//eliminar arista
				boolean esta=false;
				while(esta==false){
					System.out.println("Ingrese el identidificador de la arista a eliminar");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String idAr = br1.readLine();
				
					if(g.CjtoLados.containsKey(idAr)==true){
						((GrafoNoDirigido)g).eliminarArista(((GrafoNoDirigido)g),idAr);
						System.out.println("La arista "+idAr+" se ha eliminado");
						esta=true;
					}
					else{
					System.out.println("La arista "+ idAr+ "no se encuentra en el grafo. Intente nuevamente2");
					};
				};	
			
			}
			else if (s2==5) {//mostrar vertices
				if(g.CjtoVertice.isEmpty()==true){
					System.out.println("No hay vertices en el grafo");
				}
				else{
					System.out.println("Los vértices del Grafo son:");
					HashSet aux=g.vertices(g);
					for(Iterator it=aux.iterator();it.hasNext();){
						String t=(String)it.next();
						System.out.println(t);
					}
				};
				
			}
			
			else if (s2==6) {//mostrar lados
				if (g.CjtoLados.isEmpty()==true){
					System.out.println("No hay lados en el grafo");
				}
				else {
					System.out.println("Los lados del Grafo son:");
					HashSet aux=g.lados(g);
					for(Iterator it=aux.iterator();it.hasNext();){
						String t=(String)it.next();
						System.out.println(t);
					}
				};
			}
			
			else if (s2==7){//grado de un vertice
				boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							int grade=g.grado(idVer);
							System.out.println("El grado del vertice "+ idVer+ " es:");
							System.out.println(grade);
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
			
			}
			
			else if (s2==8){//adyacentes
				boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							HashSet aux=g.adyacentes(idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								String l1=(String)it.next();
								System.out.println(l1);
							};	
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
			}
			
			else if (s2==9){// incidentes
				boolean esta=false;
					while(esta==false){
						System.out.println("Ingrese el identificador del vertice");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String idVer = br1.readLine();
						if (g.CjtoVertice.containsKey(idVer)==true){
							HashSet aux=g.incidentes(idVer);
							for(Iterator it=aux.iterator();it.hasNext();){
								Lado l1=(Lado)it.next();
								System.out.println(l1.idLado);
							};
							esta=true;
						
						}
						else{
						System.out.println("El vertice "+ idVer+" no se encuentra en el grafo. Intente de nuevo");
						};
					};
				
			}
			
			else if(s2==10){
				System.out.println("Se ha creado el Archivo");
		
				((Grafo)g).guardar(g, "text");
			}
			
			else if(s2==11){seguir2=false;}
			
			else {System.out.println("Indique algunas de las opciones del menu");}
			}catch (NumberFormatException ex){System.out.println("Se ha introducido un caracter no numerico");}
			}
		}
		
	
				
		///////////////////////////////////////////////////////////////////////// Crear grafo a partir de un archivo /////////////////////////////////////////
		else if (s==3) {
				System.out.println("Ingrese el nombre y la ubicacion del archivo");
				
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);
				String Archivo = br.readLine();
				Grafo g=new GrafoDirigido();
				g=g.Grafo(Archivo);
				
				

		}
				
		////////////////////////////////////////////// Salir////////////////////////////////////////
		else if (s==4){ seguir=false;}
		else{System.out.println("Indique algunas de las opciones del menu");}
		}catch (NumberFormatException ex){System.out.println("Se ha introducido un caracter no numerico");}
			
		
	
	

	};
	};
	
}


	


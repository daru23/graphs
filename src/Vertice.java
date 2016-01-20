
class Vertice {
	double peso;
	String idVertice;
	int NumBusq=0;
	Vertice Pred=null;
	int MasBajo=0;
	
	public Vertice(double x, String ident){
		this.peso=x;
		this.idVertice=ident;
	}


}

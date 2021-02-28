package controller;

public class Operacoes {
	
	public Operacoes(){
		super();
	}
	
	public Struct[] limpaMemoria(Struct[]v) {
		
		for(int i = 0; i < 14; i++) {
			v [ i ] = new Struct();
		}
		
		return v;
	}
	public Struct [] sortStruct(Struct[]v) {
		
		for(int i = 0; i < 13; i++) {
			for(int j = 0; j < 13 - i; j++) {
				
				if(v[ j ].tempo > v [ j + 1 ].tempo) {
					Struct temp = v[ j ];
					v[ j ]= v[ j + 1 ];
					v[ j + 1 ]= temp;
				}
			}
		}
		return v;
	}
	
	public void exibe(Struct[]vetor) {
		System.out.println("\n\nCLASSIFICAÇÃO:");
		System.out.println("========================================================");
		for(int  i = 0; i < 14; i++) {
			System.out.printf("piloto: %d || tempo: %f || volta: %d || escudaria: %d\n", 
					vetor[i].piloto, vetor[i].tempo, vetor[i].volta, vetor[i].id);
		}
		System.out.println("========================================================");
	}
}

package eda.grafos;


import sierranevada.modelo.Zona;
import eda.auxiliar.extendedJGraphT.EdgeFactoryExtended;
import eda.grafos.modelo.EnlaceConPeso;

public class FabricaAristaEnlaceConPeso  implements EdgeFactoryExtended<Zona, EnlaceConPeso>{

	@Override
	public EnlaceConPeso createEdge(String formato) {
		//TODO
		throw new RuntimeException("Método aún no implementado");		
		 
	}

	@Override
	public EnlaceConPeso createEdge(Zona arg0, Zona arg1) {
		//Alumno, no tiene que implementar este método
		throw new RuntimeException("Constructor no soportado.");
		
	}
	
	
}

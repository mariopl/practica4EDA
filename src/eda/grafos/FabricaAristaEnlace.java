package eda.grafos;

import sierranevada.modelo.Enlace;
import sierranevada.modelo.Zona;
import eda.auxiliar.extendedJGraphT.EdgeFactoryExtended;

public class FabricaAristaEnlace implements EdgeFactoryExtended<Zona, Enlace>{
	
	@Override
	public Enlace createEdge(Zona arg0, Zona arg1) {
		//Alumno, no tiene que implementar este método
		throw new RuntimeException("Constructor no soportado.");
		
	}
	
	@Override
	public Enlace createEdge(String formato) {
		String[] parametros=formato.split(",");
		if(parametros.length!=2){
			throw new IllegalArgumentException("Cadena incorrecta en "+formato);
		}
		return new Enlace(parametros[0], new Integer(parametros[1]));		
		 
	}
	
	
	

}

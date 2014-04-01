package eda.grafos;


import sierranevada.modelo.Zona;
import eda.auxiliar.extendedJGraphT.VertexFactoryExtended;

public class FabricaVerticeZona implements VertexFactoryExtended<Zona> {
	
	public Zona createVertex() {
		//Alumno, no tiene que implementar este método
		throw new RuntimeException("Constructor no soportado.");
		
	}	
	
	public Zona createVertex(String formato) {
		String[] parametros = formato.split(",");
		if(parametros.length!=3){
			throw new IllegalArgumentException("Numero incorrecto de parametros, deberían ser 3 y son "+parametros.length);
		}
		return new Zona(parametros[0],Integer.parseInt(parametros[1]), parametros[2]);		
	}

}

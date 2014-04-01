package eda.grafos;

import java.util.Map;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import eda.auxiliar.Iterables2;
import eda.auxiliar.extendedJGraphT.EdgeFactoryExtended;
import eda.auxiliar.extendedJGraphT.VertexFactoryExtended;

public class Grafos {
	
	
	public static Graph<String, String> newStringGraph(String file_vertex, String file_adyacencia){
		Graph<String, String> ret= new SimpleGraph<String, String>(String.class);
		
		for(String v:  Iterables2.from(file_vertex)){
			ret.addVertex(v);
		}
		
		for(String ady: Iterables2.from(file_adyacencia)){
			String[] adyacencia=ady.split(";");
			if(adyacencia.length!=2 && adyacencia.length!=3){
				throw new IllegalArgumentException("Fichero de lados incorrecto, linea: "+ady);
			}
			
			ret.addEdge(adyacencia[0], adyacencia[1], adyacencia[2]);
						
		}
		
		
		return ret;
	}
	
	public static Graph<String, String> newStringGraph(String file_ady){
		Graph<String, String> ret= new SimpleGraph<String, String>(String.class);
		
		for(String ady: Iterables2.from(file_ady)){
			String[] params= ady.split(";");
			if(params.length!=2 && params.length!=3){
				throw new IllegalArgumentException("Fichero de lados incorrecto, linea: "+ady);
			}
			ret.addVertex(params[0]);
			ret.addVertex(params[1]);
			ret.addEdge(params[0], params[1], params[2]);
			
		}
		
	
		
		return ret;
	}		
	
	
	public static <V,E> Graph<V, E> newGraph(String file_vertex, String file_edges, String file_ady, VertexFactoryExtended<V> vf, EdgeFactoryExtended<V, E> ef){
		Map<String, V> idVertices= Maps.newHashMap();
		Map<String, E> idAristas= Maps.newHashMap();
		Graph<V, E> ret=new SimpleGraph<V, E>(ef);
		
		Function<String, Void> funcionVertices= new FuncionVerticesWithFactory<V,E>(ret, vf, idVertices);
		for(Void v: Iterables.transform(Iterables2.from(file_vertex), funcionVertices)){
			System.out.println(v);
		}
		Function<String, Void> funcionAristas= new FuncionAristasWithFactory<V,E>(ef, idAristas);
		for(Void v: Iterables.transform(Iterables2.from(file_edges), funcionAristas)){
			System.out.println(v);
		}
		
		Function<String, Void> funcionAdyacencia= new FuncionAdyacencia<V,E>(ret, idVertices, idAristas);
		for(Void v: Iterables.transform(Iterables2.from(file_ady), funcionAdyacencia)){
			System.out.println(v);
		}		
				
		return ret;
		
	}	
	
	
	
	public static <V,E> DirectedGraph<V, E> newDirectedGraph(String file_vertex, String file_edges, String file_ady, VertexFactoryExtended<V> vf, EdgeFactoryExtended<V, E> ef){
		//TODO
		throw new RuntimeException("Metodo aún no implementado");
		
	}	
	
	public static <V,E> WeightedGraph<V, E> newWeightedGraph(String file_vertex, String file_edges, String file_ady, VertexFactoryExtended<V> vf, EdgeFactoryExtended<V, E> ef){
		//TODO
		throw new RuntimeException("Metodo aún no implementado");
		
	}	
	
	
	
	private static class FuncionVerticesWithFactory<V,E> implements Function<String, Void>{
		Graph<V, E> grafo;
		VertexFactoryExtended<V> fabricaVertices;
		Map<String, V> idVertices;
		public FuncionVerticesWithFactory(Graph<V, E> grafo, VertexFactoryExtended<V> vf,Map<String, V> idVertices) {		
			this.grafo = grafo;
			this.fabricaVertices = vf;
			this.idVertices=idVertices;
		}
		@Override
		public Void apply(String arg0) {
			String[] vertice= arg0.split(";");
			
			if(vertice.length!=2){
				throw new IllegalArgumentException("El fichero de entrada de vertices no es correcto. Linea: "+arg0);
			}
			V vertex=fabricaVertices.createVertex(vertice[1]);
			grafo.addVertex(vertex);
			idVertices.put(vertice[0], vertex);
			return null;
		}
		
	}
	private static class FuncionAristasWithFactory<V,E> implements Function<String, Void>{		
		EdgeFactoryExtended<V,E> fabricaAristas;
		Map<String, E> idAristas;
		public FuncionAristasWithFactory(EdgeFactoryExtended<V,E> fa,Map<String, E> idAristas) {	
			this.fabricaAristas= fa;
			this.idAristas=idAristas;
		}
		@Override
		public Void apply(String arg0) {
			String[] arista= arg0.split(";");			
			if(arista.length!=2){
				throw new IllegalArgumentException("El fichero de entrada de aristas no es correcto. Linea: "+arg0);
			}
			E edge=fabricaAristas.createEdge(arista[1]);
			idAristas.put(arista[0], edge);
			return null;
		}
		
	}
	private static class FuncionAdyacencia<V,E> implements Function<String, Void>{
		Graph<V, E> grafo;		
		Map<String, V> idVertices;
		Map<String, E> idAristas;
		public FuncionAdyacencia(Graph<V, E> grafo, Map<String, V> idVertices, Map<String, E> idAristas) {			
			this.grafo=grafo;		
			this.idVertices=idVertices;
			this.idAristas=idAristas;
		}
		
		@Override
		public Void apply(String arg0) {
			String[] adyacencia= arg0.split(";");
			
			if(adyacencia.length!=3){
				throw new IllegalArgumentException("El fichero de entrada de lados no es correcto. Linea: "+arg0);
			}
						
			grafo.addEdge(idVertices.get(adyacencia[0]), idVertices.get(adyacencia[1]),idAristas.get(adyacencia[2]));
			
			return null;			
		}
	}

	

	
}

package eda.grafos.test;

import static org.junit.Assert.*;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sierranevada.modelo.Enlace;
import sierranevada.modelo.Zona;

import eda.grafos.FabricaAristaEnlaceConPeso;
import eda.grafos.FabricaVerticeZona;
import eda.grafos.FabricaAristaEnlace;
import eda.grafos.Grafos;
import eda.grafos.modelo.EnlaceConPeso;

public class GrafosTest {

	String stringFileVertex, stringFileEdges, stringFileAdy;
	String classFileVertex, classFileEdges, classFileAdy;
	String classFileVertexBig, classFileEdgesBig, classFileAdyBig;
	String directedFileVertex, directedFileEdges, directedFileAdy;
	@Before
	public void setUp() throws Exception {
		stringFileVertex="StringVertices.txt";
		stringFileEdges="StringAristas.txt";
		stringFileAdy="StringAdyacencia.txt";
		
		classFileVertex="ClaseVertices.txt";
		classFileEdges="ClaseAristas.txt";
		classFileAdy="ClaseAdyacencia.txt";
		
		classFileVertexBig="ClaseVerticesBig.txt";
		classFileEdgesBig="ClaseAristasBig.txt";
		classFileAdyBig="ClaseAdyacenciaBig.txt";
		
		directedFileVertex="DirectedVertices.txt";
		directedFileEdges="DirectedAristas.txt";
		directedFileAdy="DirectedAdyacencia.txt";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testNewStringGraph() {
		Graph<String, String> gr= Grafos.newStringGraph(stringFileVertex, stringFileAdy);
		assertTrue("El grafo tiene "+ gr.vertexSet().size() +" vertices, cuando debería de tener 5.",gr.vertexSet().size()==5);
		assertTrue("El grafo tiene "+ gr.edgeSet().size() +" lados, cuando debería de tener 6.",gr.edgeSet().size()==6);		
		assertTrue("La Zona5 solo debería tener un lado, Pista 1, pero tiene "+gr.edgesOf("Zona5").size()+" lados",gr.edgesOf("Zona5").size()==1 && gr.edgesOf("Zona5").contains("Pista1"));
	}
	
	@Test
	public void testNewStringGraphAdy() {
		Graph<String, String> gr= Grafos.newStringGraph(stringFileAdy);
		assertTrue("El grafo tiene "+ gr.vertexSet().size() +" vertices, cuando debería de tener 5.",gr.vertexSet().size()==5);
		assertTrue("El grafo tiene "+ gr.edgeSet().size() +" lados, cuando debería de tener 6.",gr.edgeSet().size()==6);		
		assertTrue("La Zona5 solo debería tener un lado, Pista 1, pero tiene "+gr.edgesOf("Zona5").size()+" lados",gr.edgesOf("Zona5").size()==1 && gr.edgesOf("Zona5").contains("Pista1"));
	}

	@Test
	public void testNewGraph() {
		Graph<Zona, Enlace> gr= Grafos.newGraph(classFileVertex, classFileEdges, classFileAdy,new FabricaVerticeZona(), new FabricaAristaEnlace());
		assertTrue("El grafo tiene "+ gr.vertexSet().size() +" vertices, cuando debería de tener 5.",gr.vertexSet().size()==5);
		assertTrue("El grafo tiene "+ gr.edgeSet().size() +" lados, cuando debería de tener 6.",gr.edgeSet().size()==6);		
		
		assertTrue("La Zona5 solo debería tener un lado, Pista 1, pero tiene "+gr.edgesOf(new Zona("Zona5",0,"")).size()+" lados",gr.edgesOf(new Zona("Zona5",0,"")).size()==1 && gr.edgesOf(new Zona("Zona5",0,"")).contains(new Enlace("Pista1",0)));
				
	}
	
	@Test
	public void testConectividad(){
		//TODO: de practica 3
		Graph<Zona, Enlace> gr= Grafos.newGraph(classFileVertexBig, classFileEdgesBig, classFileAdyBig,new FabricaVerticeZona(), new FabricaAristaEnlace());
		throw new RuntimeException("Test DE PRACTICA 3 aún no implementado");
	}
	
	@Test
	public void testAdyacencia(){
		//TODO: de practica 3
		Graph<Zona, Enlace> gr= Grafos.newGraph(classFileVertexBig, classFileEdgesBig, classFileAdyBig,new FabricaVerticeZona(), new FabricaAristaEnlace());
		throw new RuntimeException("Test DE PRACTICA 3 aún no implementado");
	}
	

	@Test
	public void testNewDirectedGraph() {
		//TODO
		throw new RuntimeException("Test aún no implementado");		
		
	}
	
	@Test
	public void testNewWeightedGraph(){
		throw new RuntimeException("Test aún no implementado");
		//TODO
	}
	
	
	

}


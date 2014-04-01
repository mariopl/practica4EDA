package eda.grafos.test;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JApplet;

import org.jgraph.JGraph;


import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphModelAdapter;

import sierranevada.modelo.Enlace;
import sierranevada.modelo.Zona;

import eda.grafos.FabricaVerticeZona;
import eda.grafos.FabricaAristaEnlace;
import eda.grafos.Grafos;



public class TestGrafico<V,E> extends JApplet {

	private static final long serialVersionUID = -6402263715575496113L;
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
	
	//private JGraphModelAdapter<String, String> m_jgAdapter;
	private JGraphModelAdapter<Zona, Enlace> m_jgAdapter;
	
	/**
	 * @see java.applet.Applet#init().
	 */
	public void init() {		
	
		/*
		String fileVertex="c:/ClaseVerticesBig.txt";
		String fileEdges="c:/ClaseAristasBig.txt";
		String fileAdj = "c:/ClaseAdyacenciaBig.txt";
		*/
		
		String fileVertex="c:/DirectedVertices.txt";
		String fileEdges="c:/DirectedAristas.txt";
		String fileAdj = "c:/DirectedAdyacencia.txt";
		
		//Graph<String, String> grafo= Grafos.newStringGraph(stringFileAdj);
		Graph<Zona, Enlace> grafo= Grafos.newDirectedGraph(fileVertex,fileEdges, fileAdj,new FabricaVerticeZona(), new FabricaAristaEnlace());
		
		
		//m_jgAdapter = new JGraphModelAdapter<String,String>(grafo);
		m_jgAdapter = new JGraphModelAdapter<Zona,Enlace>(grafo);
		
		
		JGraph jgraph = new JGraph(m_jgAdapter);
		jgraph.setAntiAliased(true);
		jgraph.setAutoResizeGraph(true);
		
		adjustDisplaySettings(jgraph);
		getContentPane().add(jgraph);
		resize(DEFAULT_SIZE);
		
		
	}
	
	private void adjustDisplaySettings(JGraph jg) {
		jg.setPreferredSize(DEFAULT_SIZE);

		Color c = Color.LIGHT_GRAY;
		String colorStr = null;

		try {
			colorStr = getParameter("bgcolor");
		} catch (Exception e) {
		}

		if (colorStr != null) {
			c = Color.decode(colorStr);
		}

		jg.setBackground(c);
	}
	

}

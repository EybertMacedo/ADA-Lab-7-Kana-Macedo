package Algoritmos;

import java.util.ArrayList;
import java.util.Stack;

import Graph.Node;

public class BellmanFord<E> {
	Graph.Graph<E> grafo;

	public BellmanFord(Graph.Graph<E> g) {
		grafo = g;
	}

	public void BellmanFord(Node<E> n) {
		int inicio = grafo.indexOf(n);
		int[] distancias = new int[grafo.size()];
		int[] anteriores = new int[grafo.size()];

		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
			anteriores[i] = -1;
		}
		distancias[inicio] = 0;

		for (int i = 1; i < grafo.size(); i++) {
			for (int j = 0; j < grafo.size(); j++) {
				Node<E> inicioNodo = grafo.getNode(j);
				int numVecinos = inicioNodo.vecinos.size();
				int startPoint = grafo.indexOf(inicioNodo);

				for (int k = 0; k < numVecinos; k++) {
					int endPoint = grafo.indexOf(inicioNodo.vecinos.get(k));
					int weight = inicioNodo.getDistanciaDelVecinoI(k);

					if (distancias[startPoint] + weight < distancias[endPoint]) {
						distancias[endPoint] = distancias[startPoint] + weight;
						anteriores[endPoint] = startPoint;
					}
				}
			}
		}

	}
	public void setGrafo(Graph.Graph<E> g) {
		grafo = g;
	}
}

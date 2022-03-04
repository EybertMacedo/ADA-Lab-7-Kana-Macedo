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
	public String[][] Bellman_Ford_2(Graph.Node<E> nodoInicial) {
		// Otra Implementacion
		Stack<Graph.Node<E>> nodosCapaN = new Stack<Graph.Node<E>>();
		int[] distancias = new int[grafo.size()];
		Object[] nodeAnterior = new Object[grafo.size()];
		nodeAnterior[0] = nodoInicial;
		nodosCapaN.add(nodoInicial);

		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}
		distancias[0] = 0;

		for (int N_Iteraciones = 1; N_Iteraciones < grafo.size(); N_Iteraciones++) {
//			System.out.println("\nPaso " + (N_Iteraciones));
			Stack<Graph.Node<E>> nodosCapaSiguiente = new Stack<Graph.Node<E>>();
			ArrayList<Graph.Node<E>> temp = new ArrayList<Graph.Node<E>>();
			while (!nodosCapaN.isEmpty()) {
				Graph.Node<E> nodoActual = nodosCapaN.pop();

				for (int i = 0; i < nodoActual.getNumeroDeVecinos(); i++) {
					int indexVecino = grafo.indexOf(nodoActual.getVecino(i));
					int indexNodoActual = grafo.indexOf(nodoActual);
					if (distancias[indexVecino] > distancias[indexNodoActual] + nodoActual.getDistanciaDelVecinoI(i)) {
						distancias[indexVecino] = distancias[indexNodoActual] + nodoActual.getDistanciaDelVecinoI(i);
						nodeAnterior[indexVecino] = nodoActual;
					}
					nodoActual.getVecino(i);
					if (!nodosCapaSiguiente.contains(nodoActual.getVecino(i))) {
						nodosCapaSiguiente.push(nodoActual.getVecino(i));
					}
				}
			}

			nodosCapaN = nodosCapaSiguiente;
		}

		String[][] array = new String[2][nodeAnterior.length];

		for (int i = 0; i < nodeAnterior.length; i++) {
			array[0][i] = Integer.toString(distancias[i]);
			array[1][i] = ((Graph.Node<E>) nodeAnterior[i]).getValue().toString();

		}
		return array;
	}
	public void setGrafo(Graph.Graph<E> g) {
		grafo = g;
	}
}

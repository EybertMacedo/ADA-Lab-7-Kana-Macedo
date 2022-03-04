package Algoritmos;

import java.util.LinkedList;

public class Dijkstra<E> {

	Graph.Graph<E> grafo;

	public Dijkstra(Graph.Graph<E> g) {
		grafo = g;
	}

	static double[] distancias = null;

	public double[] Dijkstra(Graph.Node<E> source) {
		distancias = new double[grafo.size()];
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Double.POSITIVE_INFINITY;
		}

		distancias[grafo.indexOf(source)] = 0;

		LinkedList<Graph.Node<E>> queue = new LinkedList<Graph.Node<E>>();
		queue.add(source);

		while (!queue.isEmpty()) {
			Graph.Node<E> u = queue.poll();
			for (Graph.Node<E> e : u.vecinos) {

				Graph.Node<E> v = e;
				double weight = u.getDistanciaHacia(e);

				double distanceFromU = distancias[grafo.indexOf(u)] + weight;
//				System.out.println(distanceFromU);
				if (distanceFromU < distancias[grafo.indexOf(v)]) {

					//System.out.println("Anterior distancia hasta " + v.getValue() + ": " + distancias[grafo.indexOf(v)]
							//+ ",  nueva: " + distanceFromU);

					queue.remove(v);
					distancias[grafo.indexOf(v)] = distanceFromU;
//					v.parent = u;
					int i = 0;
					for (; i < queue.size(); i++) {
						if (distancias[grafo.indexOf(e)] < distancias[i]) {
							break;
						}
					}
					queue.add(i, v);
					//System.out.println(queue);
//					System.out.println("e " + e.weight);
				}
			}
		}
		return distancias;
	}
	public void setGrafo(Graph.Graph<E> g) {
		grafo = g;
	}
}

package MainTest;

import java.util.Arrays;
import java.util.Random;

import Algoritmos.BellmanFord;
import Algoritmos.Dijkstra;
import Algoritmos.FloydWarshall;
import Graph.Graph;
import Graph.Node;

public class Ejemplos {
	private static final int V = 10;
	private static final int E = V/2;

	public static void main(String[] args) {

		// EJEMPLO
		Graph<String> g = new Graph<String>();

		Node<String> A = g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");

		g.addUndirectedEdge("A", 1, "B");
		g.addUndirectedEdge("A", 3, "F");
		g.addUndirectedEdge("B", 1, "F");
		g.addUndirectedEdge("B", 3, "C");
		g.addUndirectedEdge("B", 5, "E");
		g.addUndirectedEdge("C", 2, "D");
		g.addUndirectedEdge("F", 6, "D");
		g.addUndirectedEdge("F", 2, "E");
		g.addUndirectedEdge("E", 1, "D");
		
		Graph<Integer> generatedGraph= generatorGraph(10);
		
		BellmanFord<Integer> a = new BellmanFord<Integer>(generatedGraph);
		Dijkstra<Integer> d = new Dijkstra<Integer>(generatedGraph);
		FloydWarshall<Integer> f = new FloydWarshall<Integer>(generatedGraph);

		print(f.Floyd_Warshall());

		// FIN del EJEMPLO
		////////////////////////////

		System.out.println("Comienzo");

//		print(g.getMatrizDeDistancias());
//		for (Node<String> i : g.listNodes) {
//			System.out.println(i.value);
//		}

		Graph<String> g2 = new Graph<String>();

		Node<String> A2 = g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addVertex("D");
		g2.addVertex("E");
		g2.addVertex("F");

		g2.addDirectedEdge("A", 6, "B");
		g2.addDirectedEdge("A", 4, "C");
		g2.addDirectedEdge("A", 5, "D");
		g2.addDirectedEdge("B", -1, "E");
		g2.addDirectedEdge("C", -2, "B");
		g2.addDirectedEdge("C", 3, "E");
		g2.addDirectedEdge("D", -2, "C");
		g2.addDirectedEdge("D", -1, "F");
		g2.addDirectedEdge("E", 3, "F");

		System.out.println("Comienzo");

//		for (Node<String> i : g.listNodes) {
//			System.out.println(i.value);
//		}
		print(g2.getMatrizDeDistancias());

		System.out.println("Fin");

	}
	
	static Graph<Integer> generatorGraph(int n) {
		Random rand = new Random();
		Graph<Integer> g = new Graph<Integer>();
//		int u = 0;
		for (int i = 0; i < n; i++)
			g.addVertex(i);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int value = rand.nextInt(100);
				if (i > j) {
					if (i == (j - 1)) {
						g.addUndirectedEdge(i, value, j);
					} else if (value < 30) {
						//System.out.println(value + " i: " + i + " j: " + j);
						g.addUndirectedEdge(i, value, j);
//						u++;
					}
//					System.out.println(Arrays.deepToString(g.getMatrizDeDistancias()));
				}
			}
		}
		return g;
	}


	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	static void print(String[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	static void print(double[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + "  ");
		}
		System.out.println();
	}
}
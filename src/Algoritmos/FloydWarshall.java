package Algoritmos;

public class FloydWarshall<E> {
	Graph.Graph<E> grafo;

	public FloydWarshall(Graph.Graph<E> g) {
		grafo = g;
	}

	public int[][] distanciaMinima;
	Object[][] nodoAnterior;

	public int[][] Floyd_Warshall() {
		int n = grafo.size();
		distanciaMinima = new int[n][n];
		nodoAnterior = new Object[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distanciaMinima[i][j] = grafo.getNode(i).getDistanciaHacia(grafo.getNode(j));
				if (i != j) {
					nodoAnterior[j][i] = grafo.getNode(i);
				}
			}
		}
		//print_Floyd_Warshall();

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (distanciaMinima[i][k] + distanciaMinima[k][j] < distanciaMinima[i][j]) {
						distanciaMinima[i][j] = distanciaMinima[i][k] + distanciaMinima[k][j];
						nodoAnterior[i][j] = grafo.getNode(k);

//						System.out.println("Nueva distancia minima : " + grafo.getNode(i) + " - " + grafo.getNode(k)
//								+ " - " + grafo.getNode(j) + "\n  Distancia anterior :" + distanciaMinima[i][j]
//								+ "\n    Nuevas distancia: " + distanciaMinima[i][k] + " + " + distanciaMinima[k][j]
//								+ " = " + (distanciaMinima[i][k] + distanciaMinima[k][j]));
					}
				}
			}
		}
		//print_Floyd_Warshall();
		return distanciaMinima;
	}

	public void print_Floyd_Warshall() {
		//System.out.println("\nMatriz de Distancias:");
		for (int i = 0; i < distanciaMinima.length; i++) {
			for (int j = 0; j < distanciaMinima.length; j++) {
				if (distanciaMinima[i][j] == Integer.MAX_VALUE / 3) {
					//System.out.print("INF" + " , ");
				} else {
					System.out.print(distanciaMinima[i][j] + " , ");
				}

			}
			//System.out.println();
		}

		//System.out.println("\nMatriz de Recorridos:");
		for (int i = 0; i < grafo.size(); i++) {
			for (int j = 0; j < grafo.size(); j++) {
				//System.out.print(((E) nodoAnterior[i][j]) + " , ");
			}
			//System.out.println();
		}
	}
	public void setGrafo(Graph.Graph<E> g) {
		grafo = g;
	}

}

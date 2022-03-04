package Graph;

import java.util.ArrayList;

public class Graph<E> {
	public ArrayList<Node<E>> listNodes = new ArrayList<Node<E>>();

//	public HashMap<Node<E>, Integer> indexOf = new HashMap<Node<E>, Integer>();
	public Graph() {
	}

	public Node<E> addVertex(E e) {
		Node<E> node = new Node<E>(e);
//		indexOf.put(node, listNodes.size());
		listNodes.add(node);
		return node;
	}

	public void addUndirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		node2.addVecino(node1, distancia);
	}

	public void addDirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
	}

	public int size() {
		return listNodes.size();
	}

	public Node<E> getNode(int i) {
		return listNodes.get(i);
	}

//	private int indexOf(Node<E> n) {
//		int index=0;
//		for (; index < listNodes.size(); index++) {
//			if(listNodes.get(index).value.equals(n.value)) {
//				break;
//			}
//		}
//		return index;
//	}
//	public int indexOf(Node<E> node) {
//		return indexOf.get(node);
//	}
	public int indexOf(Node<E> node) {
		return listNodes.indexOf(node);
	}

//	private int getDistancia(Node<E> n1, Node<E> n2) {
//		return 
//	}
	public int[][] getMatrizDeDistancias() {
		int[][] m = new int[listNodes.size()][listNodes.size()];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = listNodes.get(i).getDistanciaHacia(listNodes.get(j));
			}
		}
		return m;
	}
}

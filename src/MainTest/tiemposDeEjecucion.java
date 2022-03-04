package MainTest;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.panayotis.gnuplot.JavaPlot;

import Algoritmos.BellmanFord;
import Algoritmos.Dijkstra;
import Algoritmos.FloydWarshall;
import Graph.Graph;

public class tiemposDeEjecucion {

	public static void main(String[] args) throws IOException {
		ObtenerTiemposDeEjecucion();

graficar();

	}

	static void ObtenerTiemposDeEjecucion() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese numero: ");
		int num = scan.nextInt();

		tiemposDeEjecucion(num);
	}

	static void tiemposDeEjecucion(int n) throws IOException {
		String a1 = "BellmanFord.txt";
		File file1 = new File(a1);
		BufferedWriter bwA1 = new BufferedWriter(new FileWriter(file1));

		String a2 = "Dijkstra.txt";
		File file2 = new File(a2);
		BufferedWriter bwA2 = new BufferedWriter(new FileWriter(file2));

		String a3 = "FloydWarshall.txt";
		File file3 = new File(a3);
		BufferedWriter bwA3 = new BufferedWriter(new FileWriter(file3));

		BellmanFord<Integer> b = new BellmanFord<Integer>(Ejemplos.generatorGraph(0));
		Dijkstra<Integer> d = new Dijkstra<Integer>(Ejemplos.generatorGraph(0));
		FloydWarshall<Integer> f = new FloydWarshall<Integer>(Ejemplos.generatorGraph(0));
		
		for (int i = 5; i <= n; i++) {
			System.out.println(i);
			
			int cantidad=3;
			long fin1=0,fin2=0,fin3=0;
			long temp1=0,temp2=0,temp3=0;
			
			for(int j=0;j<cantidad;j++) {
				Graph<Integer> g = Ejemplos.generatorGraph(i);
				
				b.setGrafo(g);
				d.setGrafo(g);
				f.setGrafo(g);
				
			long inicio1 = System.nanoTime();
			b.BellmanFord(g.getNode(0));
			fin1 += (temp1+System.nanoTime() - inicio1)/2;
			temp1 = fin1;
			
			long inicio2 = System.nanoTime();
			d.Dijkstra(g.getNode(0));
			fin2 += (temp2+System.nanoTime() - inicio2)/2;
			temp2 = fin2;

			long inicio3 = System.nanoTime();
			f.Floyd_Warshall();
			fin3 += (temp3+System.nanoTime() - inicio3)/2;
			temp3 = fin3;
			}
			bwA1.write(i + "\t" + (fin1)/cantidad + "\n");
			bwA2.write(i + "\t" + (fin2)/cantidad + "\n");			
			bwA3.write(i + "\t" + (fin3*3)/cantidad + "\n");
			

		}
		bwA1.close();
		bwA2.close();
		bwA3.close();
		Desktop.getDesktop().edit(file1);
		Desktop.getDesktop().edit(file2);
		Desktop.getDesktop().edit(file3);
	}

//	static Graph<Integer> generatorGraph(int n) {
//		Random rand = new Random();
//		Graph<Integer> g = new Graph<Integer>();
////		int u = 0;
//		for (int i = 0; i < n; i++)
//			g.addVertex(i);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				int value = rand.nextInt(50);
//				if (i > j) {
//					if (i == (j - 1)) {
//						g.addDirectedEdge(i, value, j);
//					} else if (value < 30) {
//						//System.out.println(value + " i: " + i + " j: " + j);
//						g.addDirectedEdge(i, value, j);
////						u++;
//					}
////					System.out.println(Arrays.deepToString(g.getMatrizDeDistancias()));
//				}
//			}
//		}
//		return g;
//	}

	static void graficar() {
		JavaPlot p = new JavaPlot("D:/Programas/gnuplot/bin/gnuplot.exe");
		
		p.addPlot("\"./BellmanFord.txt\" with lines");
		p.addPlot("\"./Dijkstra.txt\" with lines");
		p.addPlot("\"./FloydWarshall.txt\" with lines");
		p.plot();
	}
}

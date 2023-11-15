import java.util.Scanner;

import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int num;
		
		do {
			System.out.print("Insira um número inteiro (de 3 a 11) para criar uma matriz quadrática cuja "
							+ "ordem seja igual ao número informado: ");
			num = entrada.nextInt();
		} while(num < 3 || num > 11);
		
		int[][] matriz = new int[num][num];
		
		int soma = 0;
		
		int maior = 0;
		int menor = 0;
		
		int contPar = 0;
		int contImpar = 0;
		
		int diag1 = 0;
		int diag2 = 0;
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				System.out.print("\nInsira o valor da posição " + (i + 1) + " " + (j + 1) + " da matriz: ");
				matriz[i][j] = entrada.nextInt();
				
				soma += matriz[i][j];
				
				if(i == 0 && j == 0) {
					maior = matriz[0][0];
					menor = matriz[0][0];
				} else if(matriz[i][j] > maior)
					maior = matriz[i][j];
				else if(matriz[i][j] < menor)
					menor = matriz[i][j];
				
				if(matriz[i][j] % 2 == 0)
					contPar++;
				else
					contImpar++;
				
				if(i == j)
					diag1 += matriz[i][j];
				if(i + j == num - 1)
					diag2 += matriz[i][j];
			}
		}
		
		float media = (float) soma / (num * num);
		
		System.out.print("\nSoma dos elementos: " + soma + "\n"
						+ "Média: " + new DecimalFormat("#,##0.00").format(media) + "\n"
						+ "Maior valor: " + maior + "\n"
						+ "Menor valor: " + menor + "\n"
						+ "Quantidade de pares: " + contPar + "\n"
						+ "Quantidade de ímpares: " + contImpar + "\n"
						+ "Soma da diagonal principal: " + diag1 + "\n"
						+ "Soma da diagonal secundária: " + diag2 + "\n"
						+ "Matriz: \n");
		
		for(int i = 0; i < num; i++) {
			System.out.print("| ");
			for(int j = 0; j < num; j++)
				System.out.print(matriz[i][j] + " ");
			System.out.println("|");
		}
	
		entrada.close();
	}
}
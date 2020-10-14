import java.util.Scanner;


public class HistogramEqualizationDaniel {

    public static void main(String[] args) {

        int quantidadeDeElementos = 0;
        int[] vetorEntrada = null;
        int L;

        try {
            String[] split = new Scanner(System.in).next().split(",");
            quantidadeDeElementos = split.length;
            vetorEntrada = new int[quantidadeDeElementos];
            for (int i = 0; i < quantidadeDeElementos; i++)
                vetorEntrada[i] = Integer.parseInt(split[i]);

        } catch (Exception e) {
            System.out.println("Deu errado");
            System.exit(0);
        }

        int maiorElemento = vetorEntrada[0];
        for (int i = 1; i < vetorEntrada.length; i++) {
            if (vetorEntrada[i] > maiorElemento) {
                maiorElemento = vetorEntrada[i];
            }
        }
        L = maiorElemento;

        int[] vetorHk = new int[quantidadeDeElementos];
        for (int i = 0; i < quantidadeDeElementos; i++)
            for (int j = 0; j < L; j++)
                if (vetorEntrada[i] == j)
                    vetorHk[j]++;

        int[] vetorHak = new int[quantidadeDeElementos];
        for (int i = 0; i < quantidadeDeElementos; i++)
            if (i == 0)
                vetorHak[i] = vetorHk[i];
            else
                vetorHak[i] = (vetorHk[i] + vetorHak[i - 1]);

        Double[] vetorPk = new Double[quantidadeDeElementos];
        for (int i = 0; i < quantidadeDeElementos; i++)
            vetorPk[i] = Double.valueOf(vetorHak[i]) / quantidadeDeElementos;

        int[] vetorK2 = new int[quantidadeDeElementos];
        for (int i = 0; i < quantidadeDeElementos; i++)
            vetorK2[i] = (int) Math.round(9 * vetorPk[i]);

        int[] vetorFinal = new int[quantidadeDeElementos];
        for (int i = 0; i < quantidadeDeElementos; i++)
            for (int j = 0; j < vetorK2.length; j++)
                if (vetorEntrada[i] == j)
                    vetorFinal[i] = vetorK2[j];

        System.out.println("Histograma equalizado");
        for (int i = 0; i < quantidadeDeElementos; i++) {
            if (i == quantidadeDeElementos - 1)
                System.out.println(vetorFinal[i]);
            else
                System.out.print(vetorFinal[i] + ",");
        }
        System.out.println();
    }
}

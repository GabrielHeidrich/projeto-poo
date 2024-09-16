import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Planiliha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> linhas = new ArrayList<>();

        // Receber o número de colunas e nomes das colunas
        System.out.print("Digite o número de colunas: ");
        int numeroDeColunas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String[] colunas = new String[numeroDeColunas];
        for (int i = 0; i < numeroDeColunas; i++) {
            System.out.print("Digite o nome da coluna " + (i + 1) + ": ");
            colunas[i] = scanner.nextLine();
        }
        linhas.add(colunas); // Adicionar os títulos das colunas à primeira linha

        // Receber as linhas de dados
        boolean continuar = true;
        while (continuar) {
            String[] dados = new String[numeroDeColunas];
            for (int i = 0; i < numeroDeColunas; i++) {
                System.out.print("Digite o dado para a coluna '" + colunas[i] + "': ");
                dados[i] = scanner.nextLine();
            }
            linhas.add(dados); // Adicionar a linha de dados

            System.out.print("Deseja inserir mais uma linha de dados? (s/n): ");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }

        // Nome do arquivo CSV
        System.out.print("Digite o nome do arquivo CSV (sem extensão): ");
        String nomeArquivo = scanner.nextLine() + ".csv";

        // Criar o arquivo CSV
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (String[] linha : linhas) {
                writer.write(String.join(",", linha) + "\n");
            }
            System.out.println("Arquivo CSV '" + nomeArquivo + "' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo CSV.");
            e.printStackTrace();
        }

        scanner.close();
    }
}

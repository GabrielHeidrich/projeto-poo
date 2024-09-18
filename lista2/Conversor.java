package lista2;

import java.util.Scanner;

public class Conversor {
    
    public static String intParaRomano(int numero) {
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romano = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                romano.append(simbolos[i]);
                numero -= valores[i];
            }
        }
        return romano.toString();
    }
    public static double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {
        double taxaUSDparaEUR = 0.85;
        double taxaUSDparaJPY = 110.0;
        double taxaUSDparaGBP = 0.75;
        double taxaUSDparaBRL = 5.25;

        double valorEmUSD;

        switch (moedaOrigem.toUpperCase()) {
            case "USD": valorEmUSD = valor; break;
            case "EUR": valorEmUSD = valor / taxaUSDparaEUR; break;
            case "JPY": valorEmUSD = valor / taxaUSDparaJPY; break;
            case "GBP": valorEmUSD = valor / taxaUSDparaGBP; break;
            case "BRL": valorEmUSD = valor / taxaUSDparaBRL; break;
            default:
                System.out.println("Moeda de origem inválida.");
                return 0.0;
        }

        switch (moedaDestino.toUpperCase()) {
            case "USD": return valorEmUSD;
            case "EUR": return valorEmUSD * taxaUSDparaEUR;
            case "JPY": return valorEmUSD * taxaUSDparaJPY;
            case "GBP": return valorEmUSD * taxaUSDparaGBP;
            case "BRL": return valorEmUSD * taxaUSDparaBRL;
            default:
                System.out.println("Moeda de destino inválida.");
                return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema Conversor!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Conversão de número inteiro para número romano");
        System.out.println("2. Conversão de moedas");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Digite um número inteiro: ");
                int numero = scanner.nextInt();
                if (numero <= 0 || numero > 3999) {
                    System.out.println("O número deve estar entre 1 e 3999.");
                } else {
                    String romano = intParaRomano(numero);
                    System.out.println("O número romano correspondente é: " + romano);
                }
                break;

            case 2:
                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();
                System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
                String moedaOrigem = scanner.next();
                System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
                String moedaDestino = scanner.next();
                
                double resultado = converterMoeda(valor, moedaOrigem, moedaDestino);
                if (resultado != 0.0) {
                    System.out.printf("O valor convertido é: %.2f %s\n", resultado, moedaDestino.toUpperCase());
                }
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();
    }
}

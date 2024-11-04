import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int opcao = 0;
        while (opcao != 7) {
            System.out.println("Digite uma das opções:");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - BRL para USD");
            System.out.println("3 - BRL para EUR");
            System.out.println("4 - EUR para BRL");
            System.out.println("5 - USD para EUR");
            System.out.println("6 - EUR para USD");
            System.out.println("7 - SAIR");

            try {
                opcao = scanner.nextInt();

                if (opcao == 7) {
                    System.out.println("Saindo...");
                    break;
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();

                switch (opcao) {
                    case 1 -> { // USD para BRL
                        Converte taxas = conversor.convert("USD");
                        double valorConvertido = taxas.converteMoedas("USD", "BRL", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " BRL");
                    }
                    case 2 -> { // BRL para USD
                        Converte taxas = conversor.convert("BRL");
                        double valorConvertido = taxas.converteMoedas("BRL", "USD", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " USD");
                    }
                    case 3 -> { // BRL para EUR
                        Converte taxas = conversor.convert("BRL");
                        double valorConvertido = taxas.converteMoedas("BRL", "EUR", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " EUR");
                    }
                    case 4 -> { // EUR para BRL
                        Converte taxas = conversor.convert("EUR");
                        double valorConvertido = taxas.converteMoedas("EUR", "BRL", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " BRL");
                    }
                    case 5 -> { // USD para EUR
                        Converte taxas = conversor.convert("USD");
                        double valorConvertido = taxas.converteMoedas("USD", "EUR", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " EUR");
                    }
                    case 6 -> { // EUR para USD
                        Converte taxas = conversor.convert("EUR");
                        double valorConvertido = taxas.converteMoedas("EUR", "USD", valor);
                        System.out.println("Valor convertido: " + valorConvertido + " USD");
                    }
                    default -> System.out.println("Opção inválida, por favor escolha entre 1 e 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira um número inteiro válido.");
                scanner.nextLine(); // Limpa a entrada inválida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

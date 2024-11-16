package util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o valor do Imóvel: ");
            try {
                valor = scanner.nextDouble();

                if (valor > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O valor deve ser maior que zero. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Insira um número válido.");
                scanner.next();
            }
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digitar o prazo do Financiamento: ");
            try {
                prazo = scanner.nextInt();

                if (prazo > 0 && prazo <= 1000) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O valor deve ser maior que zero e menor que 100. Tente novamente.");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Insira um número válido");
                scanner.next();
            }
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = 0;
        boolean entradaValida = false;
        System.out.println("Digitar a taxa de Juros:  ");

        while (!entradaValida) {

            try {
                taxa = scanner.nextDouble();

                if (taxa > 0 && taxa < 1000) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O valor deve ser maior que zero e menor que 100. Tente novamente.");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Insira um número válido");
                scanner.next();
            }

        }
        return taxa;
    }




}
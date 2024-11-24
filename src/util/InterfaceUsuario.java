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
            } catch (Exception e) {
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

                if (prazo > 0 && prazo <= 100) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O valor deve ser maior que zero e menor que 100. Tente novamente.");

                }
            } catch (Exception e) {
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

                if (taxa > 0 && taxa < 100) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O valor deve ser maior que zero e menor que 100. Tente novamente.");

                }
            } catch (Exception e) {
                System.out.println("Erro: Insira um número válido");
                scanner.next();
            }

        }
        return taxa;
    }

    public int pedirNumeroAndares() {
        int numeroAndares = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o número do andar: ");
            try {
                numeroAndares = scanner.nextInt();
                if (numeroAndares > 0 && numeroAndares < 170) {
                    entradaValida = true;
                } else {
                    System.out.println("O numero do andar deve ser maior que zero e menor que 170");
                }
            } catch (Exception e) {
                System.out.println("Insira um número Válido");
                scanner.next();
            }
        }
        return numeroAndares;
    }

    public int pedirNumeroVagasGaragem() {
        int vagasGaragem = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o número do andar");
        }
        try {
            vagasGaragem = scanner.nextInt();
            if (vagasGaragem > 0 && vagasGaragem < 1000) {
                entradaValida = true;
            } else {
                System.out.println("A vaga da garagem deve ser maior que zero e menor que 1000");
            }
        } catch (Exception e) {
            System.out.println("Insira um número Válido");
            scanner.next();
        }
        return vagasGaragem;
    }

    public String pedirTipoZona() {
        String tipoZona = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o tipo de zona (residencial/comercial): ");
            try {
                tipoZona = scanner.next();
                if (tipoZona.equalsIgnoreCase("residencial") || tipoZona.equalsIgnoreCase("comercial")) {
                    entradaValida = true;
                } else {
                    System.out.println("Insira 'residencial' ou 'comercial'. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido.");
                scanner.next();
            }
        }
        return tipoZona;
    }


    public double pedirAreaConstruida() {
        double areaConstruida = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o número da Área Construída: ");
            try {
                areaConstruida = scanner.nextDouble();
                if (areaConstruida > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: A área construída deve ser maior que zero.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Insira um número válido.");
                scanner.next();
            }
        }
        return areaConstruida;
    }

    public double pedirAreaTerreno() {
        double areaTerreno = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o número da Área do Terreno: ");
            try {
                areaTerreno = scanner.nextDouble();
                if (areaTerreno > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: A área do terreno deve ser maior que zero.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Insira um número válido.");
                scanner.next();
            }
        }
        return areaTerreno;
    }





}



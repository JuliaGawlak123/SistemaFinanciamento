package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaFinanciamento = new ArrayList<Financiamento>();
        Scanner scanner = new Scanner(System.in);

        boolean executar = true;

        while (executar) {
            System.out.println("----------------------------------------------");
            System.out.println("| (1) - Fazer um Simulado de Financiamento     |");
            System.out.println("| (2) - Ver Financiamentos já realizados       |");
            System.out.println("| (3) - Sair                                   |");
            System.out.println("-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao){
                case 01:
                    System.out.println("Escolha um tipo de financiamento: ");
                    System.out.println("(1) Casa");
                    System.out.println("(2) Apartamento");
                    System.out.println("(3) Terreno");
                    System.out.println("Opção: ");
                    int tipo = scanner.nextInt();

                    double valorImovel = interfaceUsuario.pedirValorImovel();
                    int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
                    double taxaJuros = interfaceUsuario.pedirTaxaJuros();

                    Financiamento novoFinanciamento = null;

                    if(tipo ==1){
                        System.out.println("Digite a área construída (em m2): ");
                        double areaConstruida = scanner.nextDouble();

                        System.out.println("Digite a área do terreno em m2: ");
                        double areaTerreno = scanner.nextDouble();

                        novoFinanciamento = new Casa(valorImovel,prazoFinanciamentoEmAnos,taxaJuros, areaConstruida, areaTerreno);
                    }
                    else if(tipo == 2){
                        System.out.print("Digite o número de vagas na garagem: ");
                        int vagasGaragem = scanner.nextInt();

                        System.out.print("Digite o número do andar: ");
                        int numerodeAndares = scanner.nextInt();

                        novoFinanciamento = new Apartamento(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, vagasGaragem, numerodeAndares);
                    }
                    else if(tipo == 3){
                        System.out.print("Digite o tipo de zona (residencial/comercial): ");
                        String tipoZona = scanner.next();
                        novoFinanciamento = new Terreno(valorImovel, prazoFinanciamentoEmAnos, taxaJuros,tipoZona);
                    } else {
                        System.out.println("Opção de Financiamento Inválida");
                    }
                    if (novoFinanciamento != null) {
                        listaFinanciamento.add(novoFinanciamento);
                        novoFinanciamento.exibirDetalhesFinanciamento();
                    }
                    break;

                case 02:// Financiamento já realizado
                    double totalValorImoveis = 0;
                    double totalValorFinanciamentos = 0;

                    System.out.println("---------LISTA DE FINANCIAMENTOS REALIZADOS---------");
                    for(Financiamento financiamento : listaFinanciamento) {
                        double valorFinanciamento = financiamento.calcularPagamentoTotal();
                        totalValorImoveis += financiamento.getValorImovel();
                        totalValorFinanciamentos += valorFinanciamento;

                        System.out.printf("Valor do Imóvel: R$ %.2f, Valor do Financiamento: R$ %.2f\n", financiamento.getValorImovel(), valorFinanciamento);

                    }
                    System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalValorImoveis);
                    System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalValorFinanciamentos);
                    break;


                case 03: // Sair

                    executar = false;
                    System.out.println("Encerrando Programa......");
                    break;


                default:
                    System.out.println("opção inválida");
            }


    }
        scanner.close();
   }
}
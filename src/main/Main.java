package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.AreaConstruidaMaiorQueTerrenoException;
import util.DescontoMaiorDoQueJurosException;
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

                    if (tipo == 1) {
                        double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                        double areaTerreno = interfaceUsuario.pedirAreaTerreno();

                        try {
                            System.out.print("Digite o valor do desconto: ");
                            double desconto = scanner.nextDouble();

                            Casa casa = new Casa(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, areaConstruida, areaTerreno);
                            casa.setDesconto(desconto);

                            // Validação do desconto com try-catch
                            try {
                                casa.validarDesconto();
                                novoFinanciamento = casa; // Só adiciona se o desconto for válido
                            } catch (DescontoMaiorDoQueJurosException e) {
                                System.out.println(e.getMessage()); // Mensagem de erro
                                break; // Sai do bloco e não continua com o financiamento
                            }
                        } catch (AreaConstruidaMaiorQueTerrenoException e) {
                            System.out.println("Erro ao criar financiamento: " + e.getMessage());
                        }
                    }

                    else if(tipo == 2){
                        int vagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
                        int numeroAndares = interfaceUsuario.pedirNumeroAndares();

                        novoFinanciamento = new Apartamento(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, vagasGaragem, numeroAndares);

                    }
                    else if(tipo == 3){
                        String tipoZona = interfaceUsuario.pedirTipoZona();

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
package modelo;

import util.AreaConstruidaMaiorQueTerrenoException;
import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;
    private double desconto;

    public Casa(double valorDesejadoImovel, int prazoFinananciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) throws AreaConstruidaMaiorQueTerrenoException {
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
        if (areaConstruida > areaTerreno) {
            throw new AreaConstruidaMaiorQueTerrenoException("A área construída não pode ser maior que a área do terreno.");
        }
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }


    public double getAreaConstruida() {

        return areaConstruida;
    }

    public double getAreaTerreno() {

        return areaTerreno;
    }

    public void setAreaConstruida(double areaConstruida) {

        this.areaConstruida = areaConstruida;
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = this.getTaxaJurosAnual() / 12 / 100;
        int prazoEmMeses = this.getPrazoFinananciamento() * 12;
        double fator = Math.pow(1 + taxaMensal, prazoEmMeses);

        return (this.getValorImovel() * fator * taxaMensal / (fator - 1)) - desconto;
    }

    public void validarDesconto() throws DescontoMaiorDoQueJurosException {
        double valorJurosTotal = this.getValorImovel() * (this.getTaxaJurosAnual() / 100) * this.getPrazoFinananciamento();
        if (desconto > valorJurosTotal) {
            throw new DescontoMaiorDoQueJurosException(
                    "Erro: O desconto de " + desconto + " é maior que os juros totais de " + valorJurosTotal + "."
            );
        }
    }

    private void validarDescontoJuros(double valorJuros) throws DescontoMaiorDoQueJurosException {
        if (desconto > valorJuros) {
            throw new DescontoMaiorDoQueJurosException(
                    "Erro: O desconto de " + desconto + " é maior que os juros de " + valorJuros + "."
            );
        }
    }

    private void validarAreaConstruida() throws AreaConstruidaMaiorQueTerrenoException {
        if (areaConstruida > areaTerreno) {
            throw new AreaConstruidaMaiorQueTerrenoException(
                    "Erro: A área construída (" + areaConstruida + " m²) não pode ser maior que a área do terreno (" + areaTerreno + " m²)."
            );
        }
    }

    @Override
    public void exibirDetalhesFinanciamento() {
        try {
            validarAreaConstruida();
            super.exibirDetalhesFinanciamento();
            System.out.println("Área Construída: " + areaConstruida + "m²");
            System.out.println("Área Terreno: " + areaTerreno + "m²");
            System.out.println("Desconto aplicado: R$ " + desconto);
        } catch (AreaConstruidaMaiorQueTerrenoException e) {
            System.out.println(e.getMessage());
        }
    }
}


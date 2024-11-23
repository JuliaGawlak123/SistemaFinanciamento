package modelo;

public class Casa extends Financiamento{

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinananciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno){
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
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
        return (this.getValorImovel() * fator * taxaMensal / (fator - 1)) + 80;
    }

    @Override
    public void exibirDetalhesFinanciamento(){
        super.exibirDetalhesFinanciamento();
        System.out.println("Área Construída: "+areaConstruida + "m2");
        System.out.println("Área Terreno: " +areaTerreno+ "m2");
    }

}


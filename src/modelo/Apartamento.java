package modelo;

public class Apartamento extends Financiamento {

    public Apartamento(double valorDesejadoImovel, int prazoFinananciamentoAnos, double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
    }
// override no terreno a taxa
    @Override
    public double calcularPagamentoMensal(){
        double taxaMensal = this.getTaxaJurosAnual()/12/100;
        int prazoEmMeses= this.getPrazoFinananciamento()*12;
        double fator = Math.pow(1+ taxaMensal,prazoEmMeses);
        return this.getValorImovel()*fator*taxaMensal / (fator-1);
    }
}

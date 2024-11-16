package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorDesejadoImovel, int prazoFinananciamentoAnos, double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalBase = super.calcularPagamentoMensal();
        return pagamentoMensalBase *1.02;
    }
}

package modelo;

public class Casa extends Financiamento{
    public Casa(double valorDesejadoImovel, int prazoFinananciamentoAnos,double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() + 80;
    }
}


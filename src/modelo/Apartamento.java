package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numerodeAndares;

    public Apartamento(double valorDesejadoImovel, int prazoFinananciamentoAnos, double taxaJurosAnual, int vagasGaragem, int numerodeAndares){
        super(valorDesejadoImovel, prazoFinananciamentoAnos, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numerodeAndares = numerodeAndares;
    }
    @Override
    public void exibirDetalhesFinanciamento() {
        super.exibirDetalhesFinanciamento();
        System.out.println("Número de vagas na garagem: " + vagasGaragem);
        System.out.println("Número do andar: " + numerodeAndares);
    }

    // override no terreno a taxa
    @Override
    public double calcularPagamentoMensal(){
        double taxaMensal = this.getTaxaJurosAnual()/12/100;
        int prazoEmMeses= this.getPrazoFinananciamento()*12;
        double fator = Math.pow(1+ taxaMensal,prazoEmMeses);
        return this.getValorImovel()*fator*taxaMensal / (fator-1);
    }

    public int getVagasGaragem() {

        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {

        this.vagasGaragem = vagasGaragem;
    }

    public int getNumerodeAndares() {

        return numerodeAndares;
    }

    public void setNumerodeAndares(int numerodeAndares) {

        this.numerodeAndares = numerodeAndares;
    }
}

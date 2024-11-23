package modelo;

public class Terreno extends Financiamento{


    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamentoEmAnos, double taxaJuros, String tipoZona) {
        super(valorImovel, prazoFinanciamentoEmAnos, taxaJuros);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (valorImovel / (prazoFinananciamento * 12)) * (1 + (taxaJurosAnual / 12)) * 1.02;

    }

    @Override

    public void exibirDetalhesFinanciamento(){
        super.exibirDetalhesFinanciamento();
        System.out.println("Tipo de Zona: "+tipoZona);
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }
}

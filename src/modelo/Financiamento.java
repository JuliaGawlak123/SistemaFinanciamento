package modelo;


public class Financiamento{
    // atributos
    protected double valorImovel;
    protected int prazoFinananciamento;
    protected double taxaJurosAnual;
    // getter
    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinananciamento(){
        return this.prazoFinananciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    // setter
    public void setValorImovel(double valorImovel){
        this.valorImovel = valorImovel;
    }

    public void setPrazoFinananciamento(int prazoFinananciamento){
        this.prazoFinananciamento = prazoFinananciamento;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual){
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Construtor
    public Financiamento(double valorDesejadoImovel, int prazoFinananciamentoAnos,double taxaJurosAnual){
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinananciamento = prazoFinananciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Metodo

    public double calcularPagamentoMensal(){
        return (this.valorImovel / (this.prazoFinananciamento *12)) * (1+(this.taxaJurosAnual/12));
    }

    public double calcularPagamentoTotal(){
        return calcularPagamentoMensal() * this.prazoFinananciamento*12;

    }

    public void exibirDetalhesFinanciamento(){
        double pagamentoMensal = calcularPagamentoMensal();
        double pagamentoTotal = calcularPagamentoTotal();
        System.out.println("---------DETALHES DO FINANCIAMENTO ---------");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.valorImovel);
        System.out.printf("Pagamento Mensal: R$ %.2f\n", pagamentoMensal);
        System.out.printf("Total do Pagamento: R$ %.2f\n", pagamentoTotal);


    }

    public void exibirEntradaMensagem(){

        System.out.println("--------- SEJA BEM-VINDO AO SISTEMA DE SIMULADOR DE FINANCIAMENTO ---------");
        System.out.println("Vamos Simular o Valor do imóvel, Preencha as informações abaixo:");
        System.out.println("-------------------------------------------");
        System.out.println("| (1) - Fazer um Simulado de Financiamento |");
        System.out.println("| (2) - Ver Financiamentos já realizados   |");
        System.out.println("-------------------------------------------");


    }



}



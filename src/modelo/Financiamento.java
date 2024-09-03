package modelo;

public abstract class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoEmMeses() {
        return prazoFinanciamento * 12;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public abstract double calcularTotalPagamento();
}
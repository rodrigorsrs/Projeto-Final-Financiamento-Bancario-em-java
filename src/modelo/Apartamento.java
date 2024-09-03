package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoEmMeses = getPrazoEmMeses();
        double taxaMensal = taxaJurosAnual / 12 / 100;
        double fator = Math.pow(1 + taxaMensal, prazoEmMeses);
        return valorImovel * (taxaMensal * fator) / (fator - 1);
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoEmMeses();
    }
}
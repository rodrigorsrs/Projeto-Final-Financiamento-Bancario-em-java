package modelo;

public class Casa extends Financiamento {
    private static final double VALOR_SEGURO = 80.0;
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoEmMeses = getPrazoEmMeses();
        double taxaMensal = taxaJurosAnual / 12 / 100;
        double fator = Math.pow(1 + taxaMensal, prazoEmMeses);
        double pagamentoMensal = valorImovel * (taxaMensal * fator) / (fator - 1);
        return pagamentoMensal + VALOR_SEGURO;
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoEmMeses();
    }
}
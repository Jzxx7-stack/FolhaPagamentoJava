public class ColaboradorPadrao extends Colaborador {

    public ColaboradorPadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();

        System.out.println("Tipo: Padrão");

        System.out.printf(
                "Salário Base: R$ %.2f%n",
                getSalarioBase());

        System.out.printf(
                "Salário Final: R$ %.2f%n",
                calcularSalarioFinal());
    }
}

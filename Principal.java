import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        int opcao;

        do {

            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {

                case 1:
                    cadastrarColaboradorPadrao(scanner, colaboradores);
                    break;

                case 2:
                    cadastrarColaboradorComissionado(scanner, colaboradores);
                    break;

                case 3:
                    cadastrarColaboradorProducao(scanner, colaboradores);
                    break;

                case 4:
                    gerarFolhaPagamento(colaboradores);
                    break;

                case 5:
                    exibirResumoFolha(colaboradores);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {

        System.out.println("===== SISTEMA DE FOLHA DE PAGAMENTO =====");
        System.out.println("1 - Cadastrar Colaborador Padrão");
        System.out.println("2 - Cadastrar Colaborador Comissionado");
        System.out.println("3 - Cadastrar Colaborador Produção");
        System.out.println("4 - Gerar Folha de Pagamento");
        System.out.println("5 - Exibir Resumo da Folha");
        System.out.println("0 - Sair do Programa");
    }

    public static int lerOpcao(Scanner scanner) {

        int opcao;

        do {

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao < 0 || opcao > 5) {
                System.out.println("Digite uma opção válida entre 0 e 5.");
            }

        } while (opcao < 0 || opcao > 5);

        return opcao;
    }

    public static void cadastrarColaboradorPadrao(
            Scanner scanner,
            ArrayList<Colaborador> colaboradores) {

        System.out.println("\n--- Cadastro de Colaborador Padrão ---");

        int matricula =
                lerInteiroPositivo(
                        scanner,
                        "Matrícula: ");

        String nome =
                lerNome(scanner);

        ColaboradorPadrao colaborador =
                new ColaboradorPadrao(
                        matricula,
                        nome);

        colaboradores.add(colaborador);

        System.out.println(
                "Colaborador padrão cadastrado com sucesso.");
    }

    public static void cadastrarColaboradorComissionado(
            Scanner scanner,
            ArrayList<Colaborador> colaboradores) {

        System.out.println("\n--- Cadastro de Colaborador Comissionado ---");

        int matricula =
                lerInteiroPositivo(
                        scanner,
                        "Matrícula: ");

        String nome =
                lerNome(scanner);

        double valorVendas =
                lerDoubleNaoNegativo(
                        scanner,
                        "Valor de vendas: R$ ");

        double percentualComissao =
                lerPercentual(scanner);

        ColaboradorComissionado colaborador =
                new ColaboradorComissionado(
                        matricula,
                        nome,
                        valorVendas,
                        percentualComissao);

        colaboradores.add(colaborador);

        System.out.println(
                "Colaborador comissionado cadastrado com sucesso.");
    }

    public static void cadastrarColaboradorProducao(
            Scanner scanner,
            ArrayList<Colaborador> colaboradores) {

        System.out.println("\n--- Cadastro de Colaborador Produção ---");

        int matricula =
                lerInteiroPositivo(
                        scanner,
                        "Matrícula: ");

        String nome =
                lerNome(scanner);

        int quantidadePecas =
                lerInteiroNaoNegativo(
                        scanner,
                        "Quantidade de peças: ");

        double valorPorPeca =
                lerDoubleNaoNegativo(
                        scanner,
                        "Valor por peça: R$ ");

        ColaboradorProducao colaborador =
                new ColaboradorProducao(
                        matricula,
                        nome,
                        quantidadePecas,
                        valorPorPeca);

        colaboradores.add(colaborador);

        System.out.println(
                "Colaborador de produção cadastrado com sucesso.");
    }

    public static void gerarFolhaPagamento(
            ArrayList<Colaborador> colaboradores) {

        System.out.println("\n===== FOLHA DE PAGAMENTO =====");

        if (colaboradores.isEmpty()) {

            System.out.println(
                    "Nenhum colaborador cadastrado.");

            return;
        }

        for (Colaborador colaborador : colaboradores) {

            colaborador.exibirDados();

            System.out.println(
                    "-----------------------------------");
        }
    }

    public static void exibirResumoFolha(
            ArrayList<Colaborador> colaboradores) {

        System.out.println("\n===== RESUMO DA FOLHA =====");

        if (colaboradores.isEmpty()) {

            System.out.println(
                    "Nenhum colaborador cadastrado.");

            return;
        }

        double totalFolha =
                calcularTotalFolha(colaboradores);

        double mediaSalarial =
                calcularMediaSalarial(colaboradores);

        System.out.println(
                "Quantidade total de colaboradores: "
                        + colaboradores.size());

        System.out.printf(
                "Soma total da folha de pagamento: R$ %.2f%n",
                totalFolha);

        System.out.printf(
                "Média salarial dos colaboradores: R$ %.2f%n",
                mediaSalarial);
    }

    public static double calcularTotalFolha(
            ArrayList<Colaborador> colaboradores) {

        double total = 0.0;

        for (Colaborador colaborador : colaboradores) {

            total += colaborador.calcularSalarioFinal();
        }

        return total;
    }

    public static double calcularMediaSalarial(
            ArrayList<Colaborador> colaboradores) {

        if (colaboradores.isEmpty()) {
            return 0.0;
        }

        return calcularTotalFolha(colaboradores)
                / colaboradores.size();
    }

    public static int lerInteiroPositivo(
            Scanner scanner,
            String mensagem) {

        int valor;

        do {

            System.out.print(mensagem);

            valor = scanner.nextInt();
            scanner.nextLine();

            if (valor <= 0) {
                System.out.println(
                        "O valor deve ser maior que zero.");
            }

        } while (valor <= 0);

        return valor;
    }

    public static int lerInteiroNaoNegativo(
            Scanner scanner,
            String mensagem) {

        int valor;

        do {

            System.out.print(mensagem);

            valor = scanner.nextInt();
            scanner.nextLine();

            if (valor < 0) {
                System.out.println(
                        "O valor não pode ser negativo.");
            }

        } while (valor < 0);

        return valor;
    }

    public static double lerDoubleNaoNegativo(
            Scanner scanner,
            String mensagem) {

        double valor;

        do {

            System.out.print(mensagem);

            valor = scanner.nextDouble();
            scanner.nextLine();

            if (valor < 0) {
                System.out.println(
                        "O valor não pode ser negativo.");
            }

        } while (valor < 0);

        return valor;
    }

    public static double lerPercentual(
            Scanner scanner) {

        double percentual;

        do {

            System.out.print(
                    "Percentual de comissão: ");

            percentual = scanner.nextDouble();
            scanner.nextLine();

            if (percentual < 0 || percentual > 100) {

                System.out.println(
                        "O percentual deve estar entre 0 e 100.");
            }

        } while (percentual < 0 || percentual > 100);

        return percentual;
    }

    public static String lerNome(
            Scanner scanner) {

        String nome;

        do {

            System.out.print("Nome: ");

            nome = scanner.nextLine().trim();

            if (nome.isEmpty()) {

                System.out.println(
                        "O nome não pode ficar vazio.");
            }

        } while (nome.isEmpty());

        return nome;
    }
}

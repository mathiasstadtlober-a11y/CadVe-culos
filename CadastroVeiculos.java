import java.util.ArrayList;

public class CadastroVeiculos {

    public static void main(String[] args) {
        ArrayList<String> veiculos = new ArrayList<String>();
        int opcao;

        do {
            exibirMenu();
            opcao = Input.readInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(veiculos);
                    break;
                case 2:
                    listarVeiculos(veiculos);
                    break;
                case 3:
                    buscarVeiculo(veiculos);
                    break;
                case 4:
                    editarVeiculo(veiculos);
                    break;
                case 5:
                    removerPorIndice(veiculos);
                    break;
                case 6:
                    removerPorNome(veiculos);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (opcao != 0);

        Input.close();
    }

    public static void exibirMenu() {
        System.out.println("===== CADASTRO DE VEÍCULOS =====");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Listar veículos");
        System.out.println("3 - Buscar veículo por nome");
        System.out.println("4 - Editar veículo");
        System.out.println("5 - Remover veículo por índice");
        System.out.println("6 - Remover veículo por nome");
        System.out.println("0 - Sair");
    }

    public static void cadastrarVeiculo(ArrayList<String> veiculos) {
        String nome = Input.readln("Digite o nome do veículo: ").trim();

        if (nome.isEmpty()) {
            System.out.println("Nome do veículo não pode ser vazio.");
            return;
        }

        if (existeVeiculo(veiculos, nome)) {
            System.out.println("Veículo já cadastrado.");
            return;
        }

        veiculos.add(nome);
        System.out.println("Veículo cadastrado com sucesso.");
    }

    public static void listarVeiculos(ArrayList<String> veiculos) {
        if (veiculos.size() == 0) {
            System.out.println("A lista de veículos está vazia.");
            return;
        }

        ordenarVeiculos(veiculos);

        System.out.println("Veículos cadastrados:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - " + veiculos.get(i));
        }
        System.out.println("Total de veículos cadastrados: " + veiculos.size());
    }

    public static void buscarVeiculo(ArrayList<String> veiculos) {
        if (veiculos.size() == 0) {
            System.out.println("A lista de veículos está vazia.");
            return;
        }

        ordenarVeiculos(veiculos);
        String nome = Input.readln("Digite o nome do veículo para busca: ").trim();
        boolean encontrado = false;

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                System.out.println("Veículo encontrado: " + veiculos.get(i));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }

        System.out.println("Total de veículos cadastrados: " + veiculos.size());
    }

    public static void editarVeiculo(ArrayList<String> veiculos) {
        if (veiculos.size() == 0) {
            System.out.println("A lista de veículos está vazia.");
            return;
        }

        listarVeiculos(veiculos);
        int indice = Input.readInt("Informe o índice do veículo que deseja editar: ");

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        String novoNome = Input.readln("Digite o novo nome do veículo: ").trim();

        if (novoNome.isEmpty()) {
            System.out.println("Nome do veículo não pode ser vazio.");
            return;
        }

        for (int i = 0; i < veiculos.size(); i++) {
            if (i != indice && veiculos.get(i).equalsIgnoreCase(novoNome)) {
                System.out.println("Já existe um veículo cadastrado com esse nome.");
                return;
            }
        }

        veiculos.set(indice, novoNome);
        System.out.println("Veículo editado com sucesso.");
    }

    public static void removerPorIndice(ArrayList<String> veiculos) {
        if (veiculos.size() == 0) {
            System.out.println("A lista de veículos está vazia.");
            return;
        }

        listarVeiculos(veiculos);
        int indice = Input.readInt("Informe o índice do veículo que deseja remover: ");

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        String removido = veiculos.remove(indice);
        System.out.println("Veículo removido: " + removido);
    }

    public static void removerPorNome(ArrayList<String> veiculos) {
        if (veiculos.size() == 0) {
            System.out.println("A lista de veículos está vazia.");
            return;
        }

        String nome = Input.readln("Digite o nome do veículo que deseja remover: ").trim();

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                String removido = veiculos.remove(i);
                System.out.println("Veículo removido: " + removido);
                return;
            }
        }

        System.out.println("Veículo não encontrado.");
    }

    public static boolean existeVeiculo(ArrayList<String> veiculos, String nome) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public static void ordenarVeiculos(ArrayList<String> veiculos) {
        String auxiliar;

        for (int i = 0; i < veiculos.size() - 1; i++) {
            for (int j = 0; j < veiculos.size() - 1 - i; j++) {
                if (veiculos.get(j).compareToIgnoreCase(veiculos.get(j + 1)) > 0) {
                    auxiliar = veiculos.get(j);
                    veiculos.set(j, veiculos.get(j + 1));
                    veiculos.set(j + 1, auxiliar);
                }
            }
        }
    }
}

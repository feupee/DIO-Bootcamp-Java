import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main {
    // private static List<Companhia_Aerea> listadeCompanhias = new ArrayList<>();

    public static void main(String[] args) {
        // Criar instâncias de Aeroporto
        Aeroporto origem = new Aeroporto("Uberlândia", "UDI");
        Aeroporto destino = new Aeroporto("Guarulhos", "GRU");

        // Criação e preenchimento da lista de voos
        List<Voo> voos = new ArrayList<>();
        voos.add(new Voo("08:00", "09:00", origem, destino, "2024-03-07", "100", "200.00", "ABC12345"));
        voos.add(new Voo("08:30", "09:30", origem, destino, "2024-03-07", "120", "180.00", "DEF45678"));

        // Encontrar o melhor voo usando o GerenciadorVoos
        Voo melhorVoo = GerenciadorVoos.encontrarMelhorVoo(voos, "Uberlândia", "Guarulhos", "2024-03-07");

        // Imprimir informações do melhor voo
        if (melhorVoo != null) {
            System.out.println("Melhor Voo: " + melhorVoo.getCodigo_voo());
            System.out.println("Horário de Saída: " + melhorVoo.getEntrada());
            System.out.println("Horário de Chegada: " + melhorVoo.getSaida());
            System.out.println("Origem: " + melhorVoo.getOrigem().getCidade());
            System.out.println("Destino: " + melhorVoo.getDestino().getCidade());
            System.out.println("Data: " + melhorVoo.getData());
            System.out.println("Quantidade de Vagas: " + melhorVoo.getQuantidadeDeVagas());
            System.out.println("Valor do Voo: " + melhorVoo.getValorDoVoo());
        } else {
            System.out.println("Não foi encontrado nenhum voo disponível para os critérios especificados.");
        }
        System.out.println("\n\n\n");
        // Criar um cliente
        Cliente cliente = new Cliente("João", "15285426650", "Rua ABC", new Date(), "joao@gmail.com", new Date());
        Voo voo = new Voo("08:00", "10:00", origem, destino, "2024-03-06", "100", "300.00", "ABC12345");

        // Realizar uma compra voo
        Compras compra_passagem = new Compras(2, "Cartão de crédito", new Date(), cliente, voo);

        // Exibir informações da compra
        System.out.println("Compra realizada com sucesso!");
        System.out.println("Detalhes da compra de quarto da passagem:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Quantidade de passagens: " + compra_passagem.getQuantidadePassagens());
        System.out.println("Valor total da compra: R$" + compra_passagem.getValorTotal());
        System.out.println("Quantidade a ser paga para a Udi-Decola: " + compra_passagem.getValorTotal_UdiDecola());
        // Realizar uma compra hotel
        System.out.println("\n\n\n");
        // Criando uma instância de Hotel
        Hotel hotel = new Hotel(
                "123456789",
                "Hotel Fictício",
                "HF",
                "Rua das Flores, 123",
                "2000",
                "14:00",
                "12:00",
                "Bem-vindo ao Hotel Fictício!",
                "Cidade Fictícia",
                5,
                100,
                true
        );

// Criando quartos para uma data específica
        Date data = new Date(); // Data atual
        List<Quarto> quartosSingle = new ArrayList<>();
        quartosSingle.add(new Quarto("Single", false, 100.0, 10.0, 90.0, true, 150));
        quartosSingle.add(new Quarto("Single", false, 100.0, 10.0, 90.0, true, 150));

        List<Quarto> quartosDuplo = new ArrayList<>();
        quartosDuplo.add(new Quarto("Duplo", false, 150.0, 15.0, 135.0, false, 300));
        quartosDuplo.add(new Quarto("Duplo", false, 150.0, 15.0, 135.0, false, 300));

        List<Quarto> quartosTriplo = new ArrayList<>();
        quartosTriplo.add(new Quarto("Triplo", true, 200.0, 20.0, 180.0, true, 500));
        quartosTriplo.add(new Quarto("Triplo", true, 200.0, 20.0, 180.0, true, 500));

// Adicionando os quartos disponíveis para a data específica
        hotel.adicionarQuartosDisponiveis(data, "Single", quartosSingle);
        hotel.adicionarQuartosDisponiveis(data, "Duplo", quartosDuplo);
        hotel.adicionarQuartosDisponiveis(data, "Triplo", quartosTriplo);

// Consultando quartos disponíveis para a data atual
        List<Quarto> quartosDisponiveisSingle = hotel.obterQuartosDisponiveis(data, "Single");
        List<Quarto> quartosDisponiveisDuplo = hotel.obterQuartosDisponiveis(data, "Duplo");
        List<Quarto> quartosDisponiveisTriplo = hotel.obterQuartosDisponiveis(data, "Triplo");

// Suponha que você deseja selecionar o primeiro quarto da lista de quartos disponíveis Single
        Quarto quartoEscolhido = quartosDisponiveisSingle.getFirst();

// Criando uma instância de Compras para a compra do quarto
        Compras compraQuartoHotel = new Compras("Cartão de Crédito", 3, new Date(), cliente, quartoEscolhido);

// Exibindo os detalhes da compra
        System.out.println("Compra realizada com sucesso!");
        System.out.println("Detalhes da compra de quarto de hotel:");
        System.out.println("Forma de Pagamento: " + compraQuartoHotel.getFormaPagamento());
        System.out.println("Quantidade de Diárias: " + compraQuartoHotel.getQuantidadeDiariasHotel());
        System.out.println("Quantidade a ser paga para a Udi-Decola: " + compraQuartoHotel.getValorTotal_UdiDecola());
        System.out.println("Valor Total: " + compraQuartoHotel.getValorTotal());
        System.out.println("Data e Hora da Compra: " + compraQuartoHotel.getDataHoraCompra());
        System.out.println("Cliente: " + compraQuartoHotel.getCliente().getNome());

    }

}



        /*
        // Criando alguns aeroportos
    Aeroporto novaYork = new Aeroporto("Nova York", "JFK");
    Aeroporto losAngeles = new Aeroporto("Los Angeles", "LAX");
    Aeroporto chicago = new Aeroporto("Chicago", "ORD");
    Aeroporto dallas = new Aeroporto("Dallas", "DFW");
    Aeroporto miami = new Aeroporto("Miami", "MIA");

    // Adicionando voos entre os aeroportos
        novaYork.adicionarVoo(new Voo("09:00", "12:00", novaYork, chicago, "2024-02-15", "200", "500"));
        novaYork.adicionarVoo(new Voo("10:00", "13:30", novaYork, miami, "2024-02-15", "200", "400"));
        chicago.adicionarVoo(new Voo("12:30", "15:00", chicago, losAngeles, "2024-02-15", "200", "300"));
        chicago.adicionarVoo(new Voo("13:00", "15:30", chicago, dallas, "2024-02-15", "200", "350"));
        dallas.adicionarVoo(new Voo("16:00", "18:30", dallas, losAngeles, "2024-02-15", "200", "450"));
        miami.adicionarVoo(new Voo("11:30", "14:00", miami, dallas, "2024-02-15", "200", "380"));

    // Criando uma companhia aérea
    Companhia_Aerea companhia = new Companhia_Aerea("123456789", "Minha Companhia", "Minha Companhia", "01/01/2023", "200", "400");

    // Adicionando os aeroportos à companhia aérea
        companhia.adicionarAeroporto(novaYork);
        companhia.adicionarAeroporto(losAngeles);
        companhia.adicionarAeroporto(chicago);
        companhia.adicionarAeroporto(dallas);
        companhia.adicionarAeroporto(miami);

    // Encontrando o caminho mais curto entre dois aeroportos
    Aeroporto origem = novaYork;
    Aeroporto destino = losAngeles;
    Companhia_Aerea.CaminhoMaisCurtoInfo info = companhia.encontrarCaminhoMaisCurto(origem, destino);

    // Exibindo o caminho encontrado
        System.out.println("Caminho mais curto entre " + origem.getCidade() + " e " + destino.getCidade() + ":");
        for (Aeroporto aeroporto : info.getCaminho()) {
        System.out.println(aeroporto.getCidade() + " (" + aeroporto.getCodigoIATA() + ")");
    }

    // Exibindo o valor acumulado das passagens e o tempo estimado do voo
        System.out.println("Valor acumulado das passagens: $" + info.getValorAcumulado());
        System.out.println("Tempo estimado do voo: " + info.getTempoEstimado() + " minutos");
}

    /*public static void Menu_Principal() {
        int opcao;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----- Menu Principal -----");
            System.out.println("1. Buscar Passagens Aéreas");
            System.out.println("2. Comprar Passagens Aéreas");
            System.out.println("3. Buscar Diárias em Hotéis");
            System.out.println("4. Comprar Diárias em Hotéis");
            System.out.println("5. Cadastrar Nova Companhia Aérea");
            System.out.println("6. Listar Companhias Aéreas Cadastradas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = 5;

            switch (opcao) {
                case 1:
                    buscarPassagensAereas();
                    break;
                case 2:
                    comprarPassagensAereas();
                    break;
                case 3:
                    buscarDiariasHoteis();
                    break;
                case 4:
                    comprarDiariasHoteis();
                    break;
                case 5:
                    cadastrarCompanhia();
                    break;
                case 6:
                    listarCompanhias();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 7);
    }

    private static void cadastrarCompanhia() {
        System.out.println("\n=== Cadastro de Nova Companhia Aérea ===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Nome Oficial: ");
        String nome_oficial = scanner.nextLine();
        System.out.print("Nome de Divulgação: ");
        String nome_de_divulgacao = scanner.nextLine();
        System.out.print("Data de Criação: ");
        String data_de_criacao = scanner.nextLine();
        Companhia_Aerea companhia = new Companhia_Aerea(cnpj, nome_oficial, nome_de_divulgacao, data_de_criacao);
        listadeCompanhias.add(companhia);
        System.out.println("Companhia aérea cadastrada com sucesso!");
    }

    private static void listarCompanhias() {
        System.out.println("\n=== Lista de Companhias Aéreas Cadastradas ===");
        for (int i = 0; i < listadeCompanhias.size(); i++) {
            Companhia_Aerea companhia = listadeCompanhias.get(i);
            System.out.println("=== Companhia Aérea " + (i + 1) + " ===");
            System.out.println("CNPJ: " + companhia.getCnpj());
            System.out.println("Nome Oficial: " + companhia.getNome_oficial());
            System.out.println("Nome de Divulgação: " + companhia.getNome_de_divulgacao());
            System.out.println("Data de Criação: " + companhia.getData_de_criacao());
        }
    }

    public static void buscarPassagensAereas() {
        System.out.println("Buscando passagens aéreas...");
    }

    public static void comprarPassagensAereas() {
        System.out.println("Comprando passagens aéreas...");
    }

    public static void buscarDiariasHoteis() {
        System.out.println("Buscando diárias em hotéis...");
    }

    public static void comprarDiariasHoteis() {
        System.out.println("Comprando diárias em hotéis...");
    }
    */



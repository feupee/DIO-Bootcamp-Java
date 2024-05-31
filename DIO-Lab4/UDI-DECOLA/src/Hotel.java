import java.util.*;

public class Hotel {
    private Map<Date, Map<String, List<Quarto>>> quartosDisponiveis; // Mapa de datas para tipos de quarto disponíveis
    static final double valorFixoPorDiariaVendida = 10.0; // Valor fixo por cada diária vendida
    private static final double quantidadeDeComprasParaSeTornarVip = 10.0;
    private String cnpj;
    private String nome_oficial;
    private String nome_de_divulgacao;
    private String endereco_completo;
    private String ano_de_criacao;
    private String check_in;
    private String check_out;
    private String mensagem_de_divulgacao;
    private String cidade;
    private int numero_de_estrelas;
    private int total_de_quartos;
    private Boolean aceita_pets;

    //Construtor
    public Hotel(String cnpj, String nome_oficial, String nome_de_divulgacao, String endereco_completo, String ano_de_criacao, String check_in, String check_out, String mensagem_de_divulgacao, String cidade, int numero_de_estrelas, int total_de_quartos, Boolean aceita_pets) {
        this.cnpj = cnpj;
        this.nome_oficial = nome_oficial;
        this.nome_de_divulgacao = nome_de_divulgacao;
        this.endereco_completo = endereco_completo;
        this.ano_de_criacao = ano_de_criacao;
        this.check_in = check_in;
        this.check_out = check_out;
        this.mensagem_de_divulgacao = mensagem_de_divulgacao;
        this.cidade = cidade;
        this.numero_de_estrelas = numero_de_estrelas;
        this.total_de_quartos = total_de_quartos;
        this.aceita_pets = aceita_pets;
        this.quartosDisponiveis = new HashMap<>();
    }

    // Adicionar quartos disponíveis para uma data específica
    public void adicionarQuartosDisponiveis(Date data, String tipoQuarto, List<Quarto> quartos) {
        Map<String, List<Quarto>> quartosPorTipo = quartosDisponiveis.getOrDefault(data, new HashMap<>());
        quartosPorTipo.put(tipoQuarto, quartos);
        quartosDisponiveis.put(data, quartosPorTipo);
    }

    // Obter quartos disponíveis para uma data e tipo de quarto específicos
    public List<Quarto> obterQuartosDisponiveis(Date data, String tipoQuarto) {
        Map<String, List<Quarto>> quartosPorTipo = quartosDisponiveis.get(data);
        if (quartosPorTipo != null) {
            return quartosPorTipo.getOrDefault(tipoQuarto, new ArrayList<>());
        } else {
            return new ArrayList<>(); // Retorna uma lista vazia se não houver quartos disponíveis para essa data
        }
    }

    // Contar número de quartos de luxo disponíveis para uma data específica
    public int contarQuartosLuxoDisponiveis(Date data) {
        int count = 0; //Contador de quartos de luxo
        Map<String, List<Quarto>> quartosPorTipo = quartosDisponiveis.get(data); // Obtém os quartos disponíveis para a data especificada
        if (quartosPorTipo != null) { // Verifica se existem quartos disponíveis para a data
            // Procura em cima dos quartos disponíveis
            for (List<Quarto> quartos : quartosPorTipo.values()) {
                // Procura em cima dos quartos de cada tipo
                for (Quarto quarto : quartos) {
                    if (quarto.isDeLuxo()) { // Verifica se o quarto é de luxo
                        count++; // Incrementa o contador se o quarto for de luxo
                    }
                }
            }
        }
        return count; // Retorna o número total de quartos de luxo disponíveis para a data especificada
    }
}

//Diagrama
/*
+------------------+
|      Hotel       |
+------------------+
| - quartosDisponiveis: HashMap<Date, HashMap<String, List<Quarto>>>
+------------------+

+------------------------+
|    HashMap<Date, ...>   |
+------------------------+
|   |                    |
|   +---[15/01/2024]-----> HashMap<String, List<Quarto>>
|   |                    |
|   +---[16/01/2024]-----> HashMap<String, List<Quarto>>
|   |                    |
|   +---[17/01/2024]-----> HashMap<String, List<Quarto>>
|   |                    |
|   ...                  |
+------------------------+

+-------------------------------+
| HashMap<String, List<Quarto>> |
+-------------------------------+
|   |                           |
|   +---["Single"]-----------> Lista de quartos Single
|   |                           |
|   +---["Duplo"]------------> Lista de quartos Duplos
|   |                           |
|   +---["Triplo"]-----------> Lista de quartos Triplos
|   |                           |
+-------------------------------+

*/
//--Exemplo--
/*Hotel hotel = new Hotel();

        // Inicializando quartos disponíveis para o mês de janeiro
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.MONTH, Calendar.JANUARY);
        calendario.set(Calendar.YEAR, 2024);

        for (int dia = 1; dia <= 31; dia++) {
            calendario.set(Calendar.DAY_OF_MONTH, dia);
            Date data = calendario.getTime();

            List<Quarto> quartosSingle = new ArrayList<>();
            quartosSingle.add(new Quarto("Single", 100.0, 10.0, true));
            quartosSingle.add(new Quarto("Single", 100.0, 10.0, true));

            List<Quarto> quartosDuplo = new ArrayList<>();
            quartosDuplo.add(new Quarto("Duplo", 150.0, 15.0, false));
            quartosDuplo.add(new Quarto("Duplo", 150.0, 15.0, false));

            List<Quarto> quartosTriplo = new ArrayList<>();
            quartosTriplo.add(new Quarto("Triplo", 200.0, 20.0, true));
            quartosTriplo.add(new Quarto("Triplo", 200.0, 20.0, true));

            hotel.adicionarQuartosDisponiveis(data, "Single", quartosSingle);
            hotel.adicionarQuartosDisponiveis(data, "Duplo", quartosDuplo);
            hotel.adicionarQuartosDisponiveis(data, "Triplo", quartosTriplo);
        }

        // Acessando quartos disponíveis para uma data específica
        Date dataConsulta = new Date(); // Supondo que estamos consultando para a data atual
        List<Quarto> quartosDisponiveisSingle = hotel.obterQuartosDisponiveis(dataConsulta, "Single");
        List<Quarto> quartosDisponiveisDuplo = hotel.obterQuartosDisponiveis(dataConsulta, "Duplo");
        List<Quarto> quartosDisponiveisTriplo = hotel.obterQuartosDisponiveis(dataConsulta, "Triplo");

        // Exibindo informações dos quartos disponíveis
        System.out.println("Quartos disponíveis para " + dataConsulta + ":");
        exibirQuartos(quartosDisponiveisSingle);
        exibirQuartos(quartosDisponiveisDuplo);
        exibirQuartos(quartosDisponiveisTriplo);
    }

    // Método para exibir informações dos quartos
    public static void exibirQuartos(List<Quarto> quartos) {
        for (Quarto quarto : quartos) {
            System.out.println("Tipo: " + quarto.getTipo() + ", Diária: " + quarto.getDiariaSemDesconto() +
                    ", Desconto: " + quarto.getDesconto() + ", Aceita Cancelamento: " + quarto.aceitaCancelamento());
        }
    }
}*/


//Exemplo de Data usando "date"

/*Criando um objeto Date com a data e hora atuais
                Date dataAtual = new Date();
                System.out.println("Data e hora atuais: " + dataAtual);

// Criando um objeto Date com uma data específica (21 de fevereiro de 2022)
                Date dataEspecifica = new Date(122, 1, 21); // Ano começa em 1900, mês é base 0
                System.out.println("Data específica: " + dataEspecifica);*/

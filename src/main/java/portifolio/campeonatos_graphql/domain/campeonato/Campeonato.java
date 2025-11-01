package portifolio.campeonatos.domain.campeonato;

/**
 * Entidade de domínio (imutável) para Campeonato.
 * Mantém o domínio independente de frameworks.
 */
public record Campeonato(long id, String nome) {

    public Campeonato {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do campeonato é obrigatório.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Id não pode ser negativo.");
        }
    }

    /** Fábrica útil quando o ID é gerado pelo adaptador de saída (Mongo). */
    public static Campeonato novo(String nome) {
        return new Campeonato(0L, nome);
    }
}

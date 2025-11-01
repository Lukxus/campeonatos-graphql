package portifolio.campeonatos_graphql.ports.in;

import portifolio.campeonatos.domain.campeonato.Campeonato;

/**
 * Caso de uso responsável pela criação de um novo campeonato.
 */
public interface CriarCampeonatoUseCase {
    Campeonato criar(String nome);
}

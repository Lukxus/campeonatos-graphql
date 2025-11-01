package portifolio.campeonatos_graphql.ports.in;

import portifolio.campeonatos.domain.campeonato.Campeonato;

/**
 * Caso de uso para buscar um campeonato específico por ID.
 */
public interface BuscarCampeonatoPorIdUseCase {
    Campeonato buscarPorId(String id);
}

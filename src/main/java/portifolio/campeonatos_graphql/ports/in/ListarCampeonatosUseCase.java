package portifolio.campeonatos_graphql.ports.in;

import portifolio.campeonatos.domain.campeonato.Campeonato;
import java.util.List;

/**
 * Caso de uso responsável por listar todos os campeonatos cadastrados.
 */
public interface ListarCampeonatosUseCase {
    List<Campeonato> listar();
}

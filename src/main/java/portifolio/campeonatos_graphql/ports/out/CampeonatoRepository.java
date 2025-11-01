package portifolio.campeonatos_graphql.ports.out;

import portifolio.campeonatos.domain.campeonato.Campeonato;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída responsável pela persistência dos dados de Campeonato.
 * Implementada por um adaptador específico (ex.: MongoDB).
 */
public interface CampeonatoRepository {
    Campeonato save(Campeonato campeonato);
    Optional<Campeonato> findById(String id);
    List<Campeonato> findAll();
    boolean existsByNome(String nome);
}

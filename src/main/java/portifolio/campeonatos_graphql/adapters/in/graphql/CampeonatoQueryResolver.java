package portifolio.campeonatos_graphql.adapters.in.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import portifolio.campeonatos.domain.campeonato.Campeonato;
import portifolio.campeonatos_graphql.adapters.in.graphql.dto.CampeonatoDTO;
import portifolio.campeonatos_graphql.ports.in.BuscarCampeonatoPorIdUseCase;
import portifolio.campeonatos_graphql.ports.in.ListarCampeonatosUseCase;

import java.util.List;

/**
 * Resolver GraphQL responsável pelas queries relacionadas a Campeonatos.
 */
@Controller
public class CampeonatoQueryResolver {

    private final BuscarCampeonatoPorIdUseCase buscarUseCase;
    private final ListarCampeonatosUseCase listarUseCase;

    public CampeonatoQueryResolver(BuscarCampeonatoPorIdUseCase buscarUseCase,
                                   ListarCampeonatosUseCase listarUseCase) {
        this.buscarUseCase = buscarUseCase;
        this.listarUseCase = listarUseCase;
    }

    @QueryMapping
    public CampeonatoDTO campeonato(@Argument String id) {
        Campeonato c = buscarUseCase.buscarPorId(id);
        return new CampeonatoDTO(String.valueOf(c.id()), c.nome());
    }

    @QueryMapping
    public List<CampeonatoDTO> campeonatos() {
        return listarUseCase.listar().stream()
                .map(c -> new CampeonatoDTO(String.valueOf(c.id()), c.nome()))
                .toList();
    }
}

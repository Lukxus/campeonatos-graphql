package portifolio.campeonatos_graphql.adapters.in.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import portifolio.campeonatos.domain.campeonato.Campeonato;
import portifolio.campeonatos_graphql.adapters.in.graphql.dto.CampeonatoDTO;
import portifolio.campeonatos_graphql.adapters.in.graphql.dto.CampeonatoInput;
import portifolio.campeonatos_graphql.ports.in.CriarCampeonatoUseCase;


/**
 * Resolver GraphQL responsável pelas mutations de Campeonato.
 */
@Controller
public class CampeonatoMutationResolver {

    private final CriarCampeonatoUseCase criarUseCase;

    public CampeonatoMutationResolver(CriarCampeonatoUseCase criarUseCase) {
        this.criarUseCase = criarUseCase;
    }

    @MutationMapping
    public CampeonatoDTO criarCampeonato(@Argument CampeonatoInput input) {
        Campeonato c = criarUseCase.criar(input.nome());
        return new CampeonatoDTO(String.valueOf(c.id()), c.nome());
    }
}

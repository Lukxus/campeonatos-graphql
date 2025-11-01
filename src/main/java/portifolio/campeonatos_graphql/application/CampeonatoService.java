package portifolio.campeonatos_graphql.application;

import portifolio.campeonatos.domain.campeonato.Campeonato;
import portifolio.campeonatos_graphql.ports.in.BuscarCampeonatoPorIdUseCase;
import portifolio.campeonatos_graphql.ports.in.CriarCampeonatoUseCase;
import portifolio.campeonatos_graphql.ports.in.ListarCampeonatosUseCase;
import portifolio.campeonatos_graphql.ports.out.CampeonatoRepository;

import java.util.List;

public class CampeonatoService implements
        CriarCampeonatoUseCase,
        BuscarCampeonatoPorIdUseCase,
        ListarCampeonatosUseCase {

    private final CampeonatoRepository repository;

    public CampeonatoService(CampeonatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Campeonato criar(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do campeonato é obrigatório.");
        }
        if (repository.existsByNome(nome)) {
            throw new IllegalArgumentException("Já existe campeonato com esse nome.");
        }
        // ID será gerado pelo adapter (Mongo); no domínio usamos 0L por enquanto.
        return repository.save(Campeonato.novo(nome));
    }

    @Override
    public Campeonato buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campeonato não encontrado: " + id));
    }

    @Override
    public List<Campeonato> listar() {
        return repository.findAll();
    }
}

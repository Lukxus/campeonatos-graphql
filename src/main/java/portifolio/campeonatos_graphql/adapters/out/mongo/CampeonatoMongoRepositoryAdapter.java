package portifolio.campeonatos_graphql.adapters.out.mongo;

import org.springframework.stereotype.Component;
import portifolio.campeonatos.domain.campeonato.Campeonato;
import portifolio.campeonatos_graphql.adapters.out.mongo.doc.CampeonatoDoc;
import portifolio.campeonatos_graphql.ports.out.CampeonatoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador que conecta o domínio (porta de saída) ao MongoDB.
 */
@Component
public class CampeonatoMongoRepositoryAdapter implements CampeonatoRepository {

    private final SpringCampeonatoMongoRepository repo;

    public CampeonatoMongoRepositoryAdapter(SpringCampeonatoMongoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Campeonato save(Campeonato campeonato) {
        CampeonatoDoc doc = new CampeonatoDoc(
                campeonato.id() == 0 ? null : String.valueOf(campeonato.id()),
                campeonato.nome()
        );
        CampeonatoDoc saved = repo.save(doc);
        return new Campeonato(saved.getId() == null ? 0L : 0L, saved.getNome());
    }

    @Override
    public Optional<Campeonato> findById(String id) {
        return repo.findById(id).map(doc -> new Campeonato(0L, doc.getNome()));
    }

    @Override
    public List<Campeonato> findAll() {
        return repo.findAll().stream()
                .map(doc -> new Campeonato(0L, doc.getNome()))
                .toList();
    }

    @Override
    public boolean existsByNome(String nome) {
        return repo.existsByNome(nome);
    }
}

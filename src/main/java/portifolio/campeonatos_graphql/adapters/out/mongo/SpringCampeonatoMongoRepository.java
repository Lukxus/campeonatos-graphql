package portifolio.campeonatos_graphql.adapters.out.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import portifolio.campeonatos_graphql.adapters.out.mongo.doc.CampeonatoDoc;


public interface SpringCampeonatoMongoRepository extends MongoRepository<CampeonatoDoc, String> {
    boolean existsByNome(String nome);
}

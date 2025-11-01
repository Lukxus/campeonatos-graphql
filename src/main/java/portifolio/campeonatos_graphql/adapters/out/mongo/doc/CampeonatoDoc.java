package portifolio.campeonatos_graphql.adapters.out.mongo.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Documento MongoDB correspondente à entidade Campeonato.
 */
@Document(collection = "campeonatos")
public class CampeonatoDoc {

    @Id
    private String id;

    @Indexed(unique = true)
    private String nome;

    public CampeonatoDoc() {
    }

    public CampeonatoDoc(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package portifolio.campeonatos_graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portifolio.campeonatos_graphql.application.CampeonatoService;
import portifolio.campeonatos_graphql.ports.out.CampeonatoRepository;


@Configuration
public class BeanConfig {

    @Bean
    public CampeonatoService campeonatoService(CampeonatoRepository repository) {
        return new CampeonatoService(repository);
    }

    // REMOVA estes três:
    // @Bean CriarCampeonatoUseCase criarCampeonatoUseCase(CampeonatoService s){ return s; }
    // @Bean BuscarCampeonatoPorIdUseCase buscarCampeonatoPorIdUseCase(CampeonatoService s){ return s; }
    // @Bean ListarCampeonatosUseCase listarCampeonatosUseCase(CampeonatoService s){ return s; }
}

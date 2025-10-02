package dev.movieflix.movieflix.Controller;

import dev.movieflix.movieflix.Mapper.CategoriaMapper;
import dev.movieflix.movieflix.Model.CategoriaModel;
import dev.movieflix.movieflix.Request.CategoriaRequest;
import dev.movieflix.movieflix.Response.CategoriaResponse;
import dev.movieflix.movieflix.Service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//  Sugestão de melhoria Implementar versionamento de API
@RequestMapping("/movieflix/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    //  Método bem estruturado, gostei da separação clara das responsabilidades
    // Considerar paginação para listas grandes

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>>  listarCategorias(){
        List<CategoriaModel> categorias = categoriaService.listarCategorias();

        List<CategoriaResponse> categoriaResponses =
                categorias.stream()
                .map(categoria -> CategoriaMapper.toCategoriaResponse(categoria))
                .toList();

        return ResponseEntity.ok(categoriaResponses);
    }

    // Problema de design: Uso de ResponseEntity<?> prejudica type safety
    // O tipo genérico <?> remove as garantias de tipo em tempo de compilação, dificultando
    // manutenção e documentação da API.
    // • Perda de type safety
    // • Clientes da API não sabem o tipo de retorno esperado
    // Sugestão: Criar um ErrorResponse record e usar ResponseEntity<CategoriaResponse> ou ResponseEntity<ErrorResponse>

    @GetMapping("/{id}")
    public ResponseEntity<?>  buscarCategoriaPorId(@PathVariable Long id){

        CategoriaModel categoriaModel = categoriaService.buscarCategoriaPorId(id);
        CategoriaResponse categoriaResponse = CategoriaMapper.toCategoriaResponse(categoriaModel);
        
        // 📌 Sugestão: Mover validação para o service e usar @ControllerAdvice para tratamento de exceções

        if(categoriaResponse != null){
            return ResponseEntity.ok(categoriaResponse);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria com id: " +id+ " não encontrado");
        }
    }

    //  Sugestão de melhoria: Endpoint não segue convenções REST
    // O sufixo "/add" é redundante pois o método HTTP POST já indica operação de criação.
    // Benefícios de seguir padrões REST:
    // • Maior previsibilidade para desenvolvedores
    // • Compatibilidade com ferramentas automáticas
    // • Facilita integração com frameworks frontend
    //  Sugestão: Alterar para apenas @PostMapping sem o "/add"

    @PostMapping("/add")
    public ResponseEntity<CategoriaResponse> addCategoria(@RequestBody CategoriaRequest categoria){

        CategoriaModel categoriaModel = CategoriaMapper.toCategoria(categoria);

        CategoriaModel categoriaModelSalvo = categoriaService.addCategoria(categoriaModel);

        CategoriaResponse categoriaResponse = CategoriaMapper.toCategoriaResponse(categoriaModelSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteCategoria(@PathVariable Long id){
        if (categoriaService.buscarCategoriaPorId(id) != null){
            categoriaService.deleteCategoria(id);
            return ResponseEntity.ok("Categoria excluida com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria com id: " +id+ "não encontrada");
    }
}

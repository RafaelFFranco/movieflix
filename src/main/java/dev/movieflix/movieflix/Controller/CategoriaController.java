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
@RequestMapping("/movieflix/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>>  listarCategorias(){
        List<CategoriaModel> categorias = categoriaService.listarCategorias();

        List<CategoriaResponse> categoriaResponses =
                categorias.stream()
                .map(categoria -> CategoriaMapper.toCategoriaResponse(categoria))
                .toList();

        return ResponseEntity.ok(categoriaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  buscarCategoriaPorId(@PathVariable Long id){

        CategoriaModel categoriaModel = categoriaService.buscarCategoriaPorId(id);
        CategoriaResponse categoriaResponse = CategoriaMapper.toCategoriaResponse(categoriaModel);

        if(categoriaResponse != null){
            return ResponseEntity.ok(categoriaResponse);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria com id: " +id+ " não encontrado");
        }
    }

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

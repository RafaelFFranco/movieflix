package dev.movieflix.movieflix.Controller;

import dev.movieflix.movieflix.Model.CategoriaModel;
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
    public ResponseEntity<List<CategoriaModel>>  listarCategorias(){
        List<CategoriaModel> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  buscarCategoriaPorId(@PathVariable Long id){
        CategoriaModel categoriaPorId = categoriaService.buscarCategoriaPorId(id);
        if(categoriaPorId != null){
            return ResponseEntity.ok(categoriaPorId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria com id: " +id+ " não encontrado");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CategoriaModel> addCategoria(@RequestBody CategoriaModel categoria){
        CategoriaModel categoriaModel = categoriaService.addCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModel);
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

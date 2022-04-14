package crud.livro.resource.livro;

import crud.livro.dto.livro.LivroDTO;
import crud.livro.dto.livro.LivroFormDTO;
import crud.livro.service.livro.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/livro")
@RequiredArgsConstructor
public class LivroResource {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarFuncoes() {
        return ResponseEntity.ok(livroService.listarFuncoes());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<LivroDTO> buscarLivro(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(livroService.buscarLivroPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> adicionaLivro(@RequestBody LivroFormDTO livroFormDTO){
        LivroDTO livro = livroService.adicionaLivro(livroFormDTO);
        return ResponseEntity.ok(livro);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<LivroDTO> editarLivro(@PathVariable("codigo") Integer codigo,@RequestBody LivroFormDTO livroFormDTO) throws Exception{
        LivroDTO livro = livroService.editaLivro(codigo,livroFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<LivroDTO> deletaLivro(@PathVariable("codigo") Integer codigo) throws Exception{
        livroService.deletaLivro(codigo);
        return ResponseEntity.ok().build();
    }
}

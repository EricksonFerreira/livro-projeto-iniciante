package crud.livro.service.livro;

import crud.livro.dto.livro.LivroDTO;
import crud.livro.dto.livro.LivroFormDTO;

import java.util.List;

public interface LivroService {
    public List<LivroDTO> listarFuncoes();
    public LivroDTO buscarLivroPorCodigo(Integer codigo) throws Exception;

    public LivroDTO adicionaLivro(LivroFormDTO livroFormDTO);
    public LivroDTO editaLivro(Integer codigo, LivroFormDTO livroFormDTO) throws Exception;

    public void deletaLivro(Integer codigo) throws Exception;
}

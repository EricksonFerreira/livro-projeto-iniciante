package crud.livro.service.livro;

import crud.livro.convert.livro.LivroConvert;
import crud.livro.domain.livro.Livro;
import crud.livro.dto.livro.LivroDTO;
import crud.livro.dto.livro.LivroFormDTO;
import crud.livro.repository.livro.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LivroServiceImpl implements LivroService{

    private final LivroRepository livroRepository;

    @Override
    public List<LivroDTO> listarFuncoes() {
        List<Livro> funcoes = livroRepository.findAll();
        return LivroConvert.livroDomainListToDTOlist(funcoes);
    }

    @Override
    public LivroDTO buscarLivroPorCodigo(Integer codigo) throws Exception{
        Optional<Livro> livroOpt = livroRepository.findById(codigo);
        if(!livroOpt.isPresent()){
        }
        return LivroConvert.livroDomainToDTO(livroOpt.get());
    }

    @Override
    public LivroDTO adicionaLivro(LivroFormDTO livroFormDTO){
        Livro entity = LivroConvert.livroFormToLivroEntity(livroFormDTO);
        livroRepository.save(entity);
        return LivroConvert.livroDomainToDTO(entity);
    }

    @Override
    public LivroDTO editaLivro(Integer codigo, LivroFormDTO livroForm) throws Exception {
        Optional<Livro> livroOpt = livroRepository.findById(codigo);
        if(!livroOpt.isPresent()){
            throw new Exception("Livro não encotrado");
        }

        Livro entity = livroOpt.get();
        if(!livroForm.getNome().isEmpty()){
            entity.setNome(livroForm.getNome());
        }
        if(!livroForm.getDescricao().isEmpty()){
        entity.setDescricao(livroForm.getDescricao());
        }
        livroRepository.save(entity);

        return LivroConvert.livroDomainToDTO(entity);
    }

    @Override
    public void deletaLivro(Integer codigo) throws Exception {

        Optional<Livro> livroOpt = livroRepository.findById(codigo);
        if(!livroOpt.isPresent()){
            throw new Exception("Livro não encontrado");
        }


        livroRepository.delete(livroOpt.get());
    }
}

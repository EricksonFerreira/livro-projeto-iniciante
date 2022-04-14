package crud.livro.convert.livro;

import crud.livro.domain.livro.Livro;
import crud.livro.dto.livro.LivroDTO;
import crud.livro.dto.livro.LivroFormDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LivroConvert {
    private LivroConvert() {
    }

    public static List<LivroDTO> livroDomainListToDTOlist(List<Livro> domainList) {
        return domainList.stream().map(LivroConvert::livroDomainToDTO).collect(Collectors.toList());
    }

    public static LivroDTO livroDomainToDTO(Livro domain) {
        return LivroDTO.builder().codigo(domain.getCodigo()).nome(domain.getNome()).descricao(domain.getDescricao()).build();
    }

    public static Livro livroFormToLivroEntity(LivroFormDTO funcaoForm) {
        return Livro.builder().nome(funcaoForm.getNome()).descricao(funcaoForm.getDescricao()).build();
    }
}

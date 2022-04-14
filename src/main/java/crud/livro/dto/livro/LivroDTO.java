package crud.livro.dto.livro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nome;
    private String descricao;

}

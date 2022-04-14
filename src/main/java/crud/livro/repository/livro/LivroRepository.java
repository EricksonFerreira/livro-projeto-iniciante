package crud.livro.repository.livro;

import crud.livro.domain.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}

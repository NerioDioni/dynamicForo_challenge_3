package dynamic.foro.api.curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    Curso findByNombreContains(String nombreCurso);
}

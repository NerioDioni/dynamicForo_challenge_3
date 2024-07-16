package dynamic.foro.api.domain.curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    Curso findByNombreContains(String nombreCurso);
}

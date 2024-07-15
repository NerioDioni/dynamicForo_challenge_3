package dynamic.foro.api.topico;

import dynamic.foro.api.curso.CursoDto;
import dynamic.foro.api.usuario.UsuarioDto;
import jakarta.validation.constraints.NotBlank;

public record ListadoTopicoDto(
        Long id,
        String titulo,
        String mensaje,
        String estado,
        String fechaCreacion,
        String curso,
        String autor

) {

    public ListadoTopicoDto (Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado().toString(),
                topico.getFechaCreacion().toString(),
                topico.getCurso().getNombre(),
                topico.getAutor().getNombre()
                );
    }

}

package dynamic.foro.api.domain.topico;

import dynamic.foro.api.domain.curso.CursoDto;
import dynamic.foro.api.domain.usuario.UsuarioDto;

public record TopicoDto(
        Long id,
        String titulo,
        String mensaje,
        String estado,
        String fechaCreacion,
        CursoDto curso,
        UsuarioDto autor
) {
}

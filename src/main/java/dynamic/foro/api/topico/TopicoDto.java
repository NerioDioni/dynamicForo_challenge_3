package dynamic.foro.api.topico;

import dynamic.foro.api.curso.Curso;
import dynamic.foro.api.curso.CursoDto;
import dynamic.foro.api.usuario.Usuario;
import dynamic.foro.api.usuario.UsuarioDto;

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

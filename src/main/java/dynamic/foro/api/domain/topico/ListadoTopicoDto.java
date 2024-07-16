package dynamic.foro.api.domain.topico;

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

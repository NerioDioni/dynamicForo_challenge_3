package dynamic.foro.api.topico;

import dynamic.foro.api.curso.Curso;
import dynamic.foro.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private Boolean estado;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;


    public Topico(RegistroTopicoDto registro,Curso curso,Usuario usuario) {
        this.titulo= registro.titulo();
        this.mensaje= registro.mensaje();
        this.fechaCreacion=LocalDate.now();
        this.estado =true;
        this.autor=usuario;
        this.curso=curso;


    }
    @Override
    public String toString() {
        return  "topico: \n"+
                "--titulo= " + titulo + "\n" +
                "--Mensaje = " + mensaje +"\n" +
                "--Activo = " + estado +"\n" +
                "--fechaCreacion = " + fechaCreacion +"\n"+
                 autor+""+
                curso+"\n"
                ;

    }
    public void cerrarTopico() {
        this.estado = false;
    }

}

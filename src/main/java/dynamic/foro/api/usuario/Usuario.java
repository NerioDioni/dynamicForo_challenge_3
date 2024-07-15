package dynamic.foro.api.usuario;

import dynamic.foro.api.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;
    private String clave;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicos;

    @Override
    public String toString() {
        return  "usuario/autor: \n"+
                "--ID = " + id +"\n" +
                "--Nombre= " + nombre + "\n" +
                "--Email = " + email +"\n";

    }
}

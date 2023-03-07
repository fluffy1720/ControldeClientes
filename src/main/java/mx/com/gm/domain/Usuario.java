package mx.com.gm.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
}


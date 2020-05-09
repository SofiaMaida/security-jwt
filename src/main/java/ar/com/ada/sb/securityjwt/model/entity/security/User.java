package ar.com.ada.sb.securityjwt.model.entity.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private Boolean enabled;

    @ManyToMany
    //Relacion muchos a muchos
    //Uno las tablas mediante el JoinTable => crea la tabla puente
    @JoinTable(name = "User_Has_Authority",
            //"User_Has_Authority" es el nombre de la tabla puente
            joinColumns = {@JoinColumn(name =
                    //Uno las tablas mediante los id = "User_id" con la referencia de la columna "id"
                    "User_id", referencedColumnName = "id")},
            //Se hace los mismo de la forma inversa
            inverseJoinColumns = {@JoinColumn(name = "Authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities;

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public User addAuthority(Authority authority) {
        if (this.authorities == null)
            this.authorities = new HashSet<>();

        this.authorities.add(authority);
        return this;
    }

}

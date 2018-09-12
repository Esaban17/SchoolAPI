package com.saban.school.core.eis.bo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long rolId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "name")
    private String name;
    @Override
    public String getAuthority() {
        return this.name;
    }
}

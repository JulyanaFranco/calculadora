
package br.edu.ifro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
     @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String Senha;
    private String Senha2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getSenha2() {
        return Senha2;
    }

    public void setSenha2(String Senha2) {
        this.Senha2 = Senha2;
    }
   

}
package com.usersystem.project.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
    private static final long serialVersionUID = 1l;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String nome;

    @Column()
    private String email;

    @Column()
    private String telefone;

    @Column()
    private String password;

    public User() {}

    public User(long id, String nome, String email, String telefone, String passowrd) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.password = passowrd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return id == user.id && 
            Objects.equals(nome, user.nome) && 
            Objects.equals(email, user.email) && 
            Objects.equals(telefone, user.telefone) && 
            Objects.equals(password, user.password);
    }

    public long getId() {
        return id;        
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

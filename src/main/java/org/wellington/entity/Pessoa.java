package org.wellington.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Pessoa extends PanacheEntity {

    public String nome;
    public int nascimento;


    public static List<Pessoa> findByIdPessoas(int nascimento){
        return find("nascimento", nascimento).list();
    }
}

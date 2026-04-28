package org.wellington.service;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.wellington.entity.Pessoa;

import java.util.List;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResourse {

    @GET
    public List<Pessoa> getPessoa(){
        return Pessoa.listAll();
    }

    @GET
    @Path("nascimentos")
    public List<Pessoa> findByPessoaAno(@QueryParam("anoNascimento") int AnoNascimento){
        return Pessoa.findByIdPessoas(AnoNascimento);
    }


    @POST
    @Transactional
    public Pessoa addPessoa(Pessoa pessoa){
        pessoa.id= null;
        pessoa.persist();

        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa){
        Pessoa p = Pessoa.findById(pessoa.id);
        p.persist();
        p.nome = pessoa.nome;
        p.nascimento = pessoa.nascimento;
        return p;
    }

    @DELETE
    @Transactional
    public void deletePessoa(int id){
        Pessoa.deleteById(id);

    }
}

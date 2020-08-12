package com.matheusamiranda.cursomc.services;

import com.matheusamiranda.cursomc.domain.Categoria;
import com.matheusamiranda.cursomc.repositories.CategoriaRepository;
import com.matheusamiranda.cursomc.services.exceptions.DataIntegrityException;
import com.matheusamiranda.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: "
                + Categoria.class.getName()));
    }
    public Categoria insert(Categoria obj){
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        } catch (DataIntegrityException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }}

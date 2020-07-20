package com.matheusamiranda.cursomc.services;

import com.matheusamiranda.cursomc.domain.Categoria;
import com.matheusamiranda.cursomc.repositories.CategoriaRepository;
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
}

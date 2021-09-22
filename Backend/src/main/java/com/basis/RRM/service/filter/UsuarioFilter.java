package com.basis.RRM.service.filter;

import com.basis.RRM.dominio.Usuario;
import com.basis.RRM.dominio.Usuario_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class UsuarioFilter implements EntityFilter<Usuario> {

    private String nome;
    private String cargo;
    private String cpf;

    @Override
    public Specification<Usuario> filtrar(){
        return (root, cq, cb) -> cb.and(getPredicates(root, cq, cb).toArray(new Predicate[0]));
    }

    private List<Predicate> getPredicates(Root<Usuario> root, CriteriaQuery<?> cq, CriteriaBuilder cb){
        List<Predicate> predicates = new ArrayList<>();
        cq.orderBy(cb.desc(root.get("id")));

        if(nome!=null){
            predicates.add(cb.like(root.get(Usuario_.nome), "%" + nome + "%"));
        }

        if(cargo!=null){
            predicates.add(cb.like(root.join("cargo").get("cargo"), "%" + cargo + "%"));
        }

        if(cpf!=null){
            predicates.add(cb.equal(root.get(Usuario_.cpf), cpf));
        }

        return predicates;
    }
}
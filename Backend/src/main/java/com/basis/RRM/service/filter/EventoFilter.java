package com.basis.RRM.service.filter;

import com.basis.RRM.dominio.Evento;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class EventoFilter implements EntityFilter<Evento> {
    private String nome;
    private LocalDate data;
    private String motivo;
    private String situacao;
    private String usuario;


    @Override
    public Specification<Evento> filtrar() {
        return (root,cq,cb) -> cb.and(getPredicate(root,cq,cb).toArray(new Predicate[0]));
    }
    private List<Predicate> getPredicate (Root<Evento>root,CriteriaQuery<?>cq, CriteriaBuilder cb){
        cq.orderBy(cb.desc(root.get("id")));
        return null;
    }

}

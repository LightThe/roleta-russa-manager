package com.basis.RRM.builder;

import com.basis.RRM.dominio.Evento;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

public class EventoBuilder extends ConstrutorDeEntidade<Evento> {
    @Override
    protected Evento construirEntidade() throws ParseException {
        Evento evento = new Evento();
        evento.setNome("Lanche dos brocados");
        evento.setDataEvento(LocalDate.now().plusMonths(2L));


        return null;
    }

    @Override
    protected Evento persistir(Evento entidade) {
        return null;
    }

    @Override
    protected Collection<Evento> obterTodos() {
        return null;
    }

    @Override
    protected Evento obterPorId(Long id) {
        return null;
    }
}

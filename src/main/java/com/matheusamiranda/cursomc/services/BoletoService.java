package com.matheusamiranda.cursomc.services;

import com.matheusamiranda.cursomc.domain.PagamentoComBoleto;
import com.matheusamiranda.cursomc.domain.Pedido;
import com.matheusamiranda.cursomc.domain.enums.EstadoPagamento;
import com.matheusamiranda.cursomc.repositories.PedidoRepository;
import com.matheusamiranda.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPedido);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataVencimento(cal.getTime());
    }
}

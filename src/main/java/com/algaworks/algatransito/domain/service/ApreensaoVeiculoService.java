package com.algaworks.algatransito.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.algaworks.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class ApreensaoVeiculoService {
    

    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public void apreender(Long veiculoId){
       Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
       
       veiculo.apreender();
    }

    @Transactional
    public void removerApreensao(Long veiculoId){
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);

        veiculo.removerApreensao();
    }
}

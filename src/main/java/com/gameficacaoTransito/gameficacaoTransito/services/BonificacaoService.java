package com.gameficacaoTransito.gameficacaoTransito.services;

import com.gameficacaoTransito.gameficacaoTransito.models.Bonificacao;
import com.gameficacaoTransito.gameficacaoTransito.repositories.BonificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BonificacaoService {

    @Autowired
    private InfracaoUsuarioService service;

    @Autowired
    private BonificacaoRepository repo;

    private void calcBonificao(Integer user) {
        Bonificacao bonificacao = new Bonificacao();
        Date teste = service.lastInfracao(user);
        Date atual = new Date();
        Integer diffInDays = (int)( (atual.getTime() - teste.getTime())/ (1000 * 60 * 60 * 24) );
        Integer parameterDays = 3;
        Integer parameterPoints = 3;
        Integer parameterLimit = 50;

        if(diffInDays > parameterDays){
            Integer cacl = diffInDays / parameterDays;
            if(cacl*parameterPoints <= parameterLimit){
                bonificacao.setDpvat(cacl*parameterPoints);
                bonificacao.setIpva(cacl*parameterPoints);
                bonificacao.setUsuario(user);
            }
            else{
                bonificacao.setDpvat(parameterLimit);
                bonificacao.setIpva(parameterLimit);
                bonificacao.setUsuario(user);
            }
            repo.save(bonificacao);
        }
    }

    public Optional<Bonificacao> findBonificacaoByUser(Integer user){
        this.calcBonificao(user);
        return repo.findByUsuario(user);
    }
}

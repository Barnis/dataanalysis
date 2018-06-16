package br.com.barnis.dataanalysis;

import org.springframework.stereotype.Service;

@Service
public class TestMessage {

    private String nome = "Barnis Marinho";

    public String getNome() {
        return nome;
    }
}

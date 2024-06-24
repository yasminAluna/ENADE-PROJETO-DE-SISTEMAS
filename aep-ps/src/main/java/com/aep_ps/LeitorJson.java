package com.aep_ps;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LeitorJson {
    public static List<Veiculo> lerVeiculos(String caminhoArquivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = LeitorJson.class.getClassLoader().getResourceAsStream(caminhoArquivo);
        VeiculoWrapper veiculoWrapper = mapper.readValue(inputStream, VeiculoWrapper.class);
        return veiculoWrapper.getTodosVeiculos();
    }
}

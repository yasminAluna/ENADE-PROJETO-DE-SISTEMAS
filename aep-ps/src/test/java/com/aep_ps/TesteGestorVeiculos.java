package com.aep_ps;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteGestorVeiculos {
    @Test
    public void testeSomarValorPorMarca() throws IOException {
        List<Veiculo> veiculos = LeitorJson.lerVeiculos("veiculos.json");
        GestorVeiculos gestor = new GestorVeiculos(veiculos);

        double totalChevrolet = gestor.somarValorPorMarca("Chevrolet");
        assertEquals(177000.00, totalChevrolet);
    }

    @Test
    public void testeFiltrarPorAno() throws IOException {
        List<Veiculo> veiculos = LeitorJson.lerVeiculos("veiculos.json");
        GestorVeiculos gestor = new GestorVeiculos(veiculos);

        List<Veiculo> veiculosNovos = gestor.filtrarPorAno(2019);
        assertTrue(veiculosNovos.size() > 0);
        assertTrue(veiculosNovos.stream().allMatch(v -> v.getAno() > 2019));
    }
}

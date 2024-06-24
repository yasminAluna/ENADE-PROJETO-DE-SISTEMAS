package com.aep_ps;

import java.util.List;
import java.util.stream.Collectors;

public class GestorVeiculos {
    private List<Veiculo> veiculos;

    public GestorVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Veiculo> filtrarPorTipoEMarca(String tipo, String marca) {
        return veiculos.stream()
                .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(tipo) && v.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    public double somarValorPorMarca(String marca) {
        return veiculos.stream()
                .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                .mapToDouble(Veiculo::getValor)
                .sum();
    }

    public List<Veiculo> filtrarPorAno(int ano) {
        return veiculos.stream()
                .filter(v -> v.getAno() > ano)
                .collect(Collectors.toList());
    }
}

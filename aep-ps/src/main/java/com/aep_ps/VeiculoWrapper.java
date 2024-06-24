package com.aep_ps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class VeiculoWrapper {
    @JsonProperty("carros")
    private List<TipoCarro> carros;
    @JsonProperty("motos")
    private List<TipoMoto> motos;

    public List<Veiculo> getTodosVeiculos() {
        List<Veiculo> todosVeiculos = new ArrayList<>();
        for (TipoCarro tipoCarro : carros) {
            todosVeiculos.addAll(tipoCarro.getNovos());
            todosVeiculos.addAll(tipoCarro.getUsados());
        }
        for (TipoMoto tipoMoto : motos) {
            todosVeiculos.addAll(tipoMoto.getNovos());
            todosVeiculos.addAll(tipoMoto.getUsados());
        }
        return todosVeiculos;
    }

    // Getters e setters

    public static class TipoCarro {
        @JsonProperty("novos")
        private List<Carro> novos;
        @JsonProperty("usados")
        private List<Carro> usados;

        public List<Carro> getNovos() {
            return novos;
        }

        public void setNovos(List<Carro> novos) {
            this.novos = novos;
        }

        public List<Carro> getUsados() {
            return usados;
        }

        public void setUsados(List<Carro> usados) {
            this.usados = usados;
        }
    }

    public static class TipoMoto {
        @JsonProperty("novos")
        private List<Moto> novos;
        @JsonProperty("usados")
        private List<Moto> usados;

        public List<Moto> getNovos() {
            return novos;
        }

        public void setNovos(List<Moto> novos) {
            this.novos = novos;
        }

        public List<Moto> getUsados() {
            return usados;
        }

        public void setUsados(List<Moto> usados) {
            this.usados = usados;
        }
    }
}

package br.com.fiap.domain.resource;

import br.com.fiap.domain.entity.Equipamento;
import jakarta.ws.rs.core.Response;

public class EquipamentoResource implements Resource<Resource, Long>{


    @Override
    public Response persist(Resource resource) {
        return null;
    }

    @Override
    public Response findAll() {
        return null;
    }

    @Override
    public Response findById(Long aLong) {
        return null;
    }

    @Override
    public Response update(Long id, Resource resource) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}

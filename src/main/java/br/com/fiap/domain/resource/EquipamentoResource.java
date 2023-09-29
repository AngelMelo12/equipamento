package br.com.fiap.domain.resource;

import br.com.fiap.domain.entity.Equipamento;
import br.com.fiap.domain.repository.EquipamentoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/equipamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EquipamentoResource implements Resource<Equipamento, Long>{

    @Context
    UriInfo uriInfo;

    private EquipamentoRepository repo = EquipamentoRepository.build();

    @POST
    @Override
    public Response persist(Equipamento equipamento) {
        Equipamento persist = repo.persist(equipamento);
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI uri = ub.path(String.valueOf(persist.getId())).build();
        return Response.created(uri).entity(equipamento).build();
    }

    @GET
    @Override
    public Response findAll() {
        List<Equipamento> equipamentos = new ArrayList<>();
        equipamentos = repo.findAll();
        return Response.ok(equipamentos).build();
    }

    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {
        Equipamento equipamento = repo.findById(id);
        if (Objects.isNull(equipamento)) return Response.status(404).build();
        return Response.ok(equipamento).build();
    }

    @PUT
    @Path("/{id}")
    @Override
    public Response update(@PathParam("id") Long id, Equipamento equipamento) {
        equipamento.setId(id);
        Equipamento eq = repo.update(equipamento);
        if (Objects.isNull(eq)) return Response.status(404).build();
        return Response.ok(equipamento).build();
    }

    @PUT
    @Path("/{id}")
    @Override
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = repo.delete(id);
        if (deleted) return Response.ok().build();
        return Response.status(404).build();
    }


}

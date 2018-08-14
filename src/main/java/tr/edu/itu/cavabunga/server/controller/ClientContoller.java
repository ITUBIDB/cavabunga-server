package tr.edu.itu.cavabunga.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.edu.itu.cavabunga.lib.http.Response;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.http.ClientResponse;
import tr.edu.itu.cavabunga.server.service.ClientService;

@RestController
@RequestMapping(path = "/client")
public class ClientContoller {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response createClient(@RequestBody Client client){
        clientService.saveClinet(client);
        return new Response(0, "created");
    }

    @GetMapping(value = "/{client_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getClient(@PathVariable(value = "client_id") Long id){
        return new ClientResponse(0, null, clientService.getClientById(id));
    }

    @PutMapping(value = "/{client_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse updateClient(@PathVariable(value = "client_id")Long id, @RequestBody Client client){
        clientService.updateClient(id, client);
        return new ClientResponse(0, "updated", null);
    }

    @DeleteMapping(value = "/{client_id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse deleteClient(@PathVariable(value = "client_id")Long id){
        clientService.deleteClientById(id);
        return new ClientResponse(0,"deleted", null);
    }
}

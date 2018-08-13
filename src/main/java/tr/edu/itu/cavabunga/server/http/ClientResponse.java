package tr.edu.itu.cavabunga.server.http;

import lombok.Data;
import tr.edu.itu.cavabunga.lib.http.Response;
import tr.edu.itu.cavabunga.server.entity.Client;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientResponse extends Response {
    private List<Client> data = new ArrayList<>();

    public ClientResponse(Integer code, String message, Client data){
        super(code,message);
        this.data.add(data);
    }

    public ClientResponse(){

    }
}

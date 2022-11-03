package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;
import com.sun.jmx.snmp.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//SOAP API
//JAX-WS

@Component
@WebService(serviceName="BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod(operationName = "ListComptes")
    public List<Compte> compteList(){
     return  compteRepository.findAll();
    }

    @WebMethod(operationName = "getCompte")
    public Compte compte(@WebParam(name = "id") Long id){
        return  compteRepository.findById(id).get();
    }

}

package com.sid.msbanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@XmlRootElement
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeCompte type;
    @ManyToOne
    private Client client;
}


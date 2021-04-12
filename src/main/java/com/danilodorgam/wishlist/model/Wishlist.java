package com.danilodorgam.wishlist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 10/04/2021 on 18:00
 */

@Document(collection = "wishlist")
public class Wishlist {

    public Wishlist(Integer clientID, Integer produtoID) {
        this.clientID = clientID;
        this.produtoID = produtoID;
    }

    public Wishlist() {
    }

    @Id
    private String id;

    private Integer clientID;

    private Integer produtoID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Integer produtoID) {
        this.produtoID = produtoID;
    }
}

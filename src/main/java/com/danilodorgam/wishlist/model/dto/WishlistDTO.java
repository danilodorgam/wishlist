package com.danilodorgam.wishlist.model.dto;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 11/04/2021 on 18:01
 */
public class WishlistDTO {
    private Integer clientID;

    private Integer produtoID;

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

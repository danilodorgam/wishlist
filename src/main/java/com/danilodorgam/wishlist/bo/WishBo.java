package com.danilodorgam.wishlist.bo;

import com.danilodorgam.wishlist.exception.DuplicateKeyException;
import com.danilodorgam.wishlist.exception.MaximumItemsWishListException;
import com.danilodorgam.wishlist.exception.NotFoundException;
import com.danilodorgam.wishlist.model.Wishlist;
import com.danilodorgam.wishlist.model.dto.WishlistDTO;
import com.danilodorgam.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 11/04/2021 on 17:56
 */
@Component
public class WishBo {
    @Autowired
    WishlistRepository repository;

    private static final Integer MAXIMUM_ITEMS_WISH_LIST = 20;




    public List<Wishlist> showWishList(Integer clientID){

        return repository.findAllByClientID(clientID);
    }

    /**
     * Verifica se é um Item valido para adição
     * @param wishlist
     * @throws DuplicateKeyException
     * @throws MaximumItemsWishListException
     */
    private void validateAdd(WishlistDTO wishlist) throws DuplicateKeyException, MaximumItemsWishListException{
        if(repository.findByClientIDAndProdutoID(wishlist.getClientID(), wishlist.getProdutoID()).isPresent()){
            throw new DuplicateKeyException();
        }
        if(repository.countAllByClientID(wishlist.getClientID()) > MAXIMUM_ITEMS_WISH_LIST){
            throw new MaximumItemsWishListException();
        }
    }

    public void addToWithList(WishlistDTO wishlist) {
        this.validateAdd(wishlist);
        /**
         * em um ambiente mais complexo Seria criado uma camada de parse onde ele seria responsavel
         * por converter DTO em entidade e entidade em DTO
         */
        Wishlist base = new Wishlist(wishlist.getClientID(), wishlist.getProdutoID());
        repository.save(base);
    }


    public void removeFromWishlist(String productOnWishListId) {
        Wishlist base = repository.findById(productOnWishListId).orElseThrow(NotFoundException::new);
        repository.delete(base);
    }

    public Wishlist checkContainsWishList(Integer produtoID, Integer clientID) {
        return repository.findByClientIDAndProdutoID(clientID,produtoID).orElseThrow(NotFoundException::new);
    }


}

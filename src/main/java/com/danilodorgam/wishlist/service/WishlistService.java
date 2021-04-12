package com.danilodorgam.wishlist.service;

import com.danilodorgam.wishlist.bo.WishBo;
import com.danilodorgam.wishlist.exception.MaximumItemsWishListException;
import com.danilodorgam.wishlist.exception.NotFoundException;
import com.danilodorgam.wishlist.exception.DuplicateKeyException;
import com.danilodorgam.wishlist.model.Wishlist;
import com.danilodorgam.wishlist.model.dto.WishlistDTO;
import com.danilodorgam.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 10/04/2021 on 18:00
 */
@Service
public class WishlistService {

    @Autowired
    WishBo bo;

    public List<Wishlist> showWishList(Integer clientID){
        return bo.showWishList(clientID);
    }

    public void addToWithList(WishlistDTO wishlist) {
        bo.addToWithList(wishlist);
    }


    public void removeFromWishlist(String productOnWishListId) {
        bo.removeFromWishlist(productOnWishListId);
    }

    public Wishlist checkContainsWishList(Integer produtoID, Integer clientID) {
        return bo.checkContainsWishList(clientID,produtoID);
    }
}

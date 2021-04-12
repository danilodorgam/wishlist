package com.danilodorgam.wishlist.controller;

import com.danilodorgam.wishlist.model.Wishlist;
import com.danilodorgam.wishlist.model.dto.WishlistDTO;
import com.danilodorgam.wishlist.service.WishlistService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 10/04/2021 on 17:59
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    WishlistService service;

    @PostMapping
    public ResponseEntity<String> addToWithList(@RequestBody WishlistDTO wishlist){
        service.addToWithList(wishlist);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productOnWishListId}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable("productOnWishListId") String productOnWishListId){
        service.removeFromWishlist(productOnWishListId);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{clientID}")
    public  ResponseEntity<List<Wishlist>> showWishList(@PathVariable("clientID") Integer clientID){
        return new ResponseEntity<>(service.showWishList(clientID), HttpStatus.OK);

    }
    @GetMapping("/{produtoID}/{clientID}")
    public ResponseEntity<Wishlist> checkContainsWishList(@PathVariable("produtoID") Integer produtoID, @PathVariable("clientID") Integer clientID){
        return new ResponseEntity<>(service.checkContainsWishList(produtoID,clientID), HttpStatus.OK);

    }
}

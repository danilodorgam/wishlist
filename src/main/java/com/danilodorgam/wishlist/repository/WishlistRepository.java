package com.danilodorgam.wishlist.repository;

import com.danilodorgam.wishlist.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 10/04/2021 on 18:31
 */
public interface WishlistRepository extends MongoRepository<Wishlist, String> {
     List<Wishlist> findAllByClientID(Integer clientID);
     Optional<Wishlist> findByClientIDAndProdutoID(Integer clienteID, Integer produtoID);
     Integer  countAllByClientID(Integer clientID);
}

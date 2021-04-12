package com.danilodorgam.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 11/04/2021 on 15:50
 */
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Número maximo atingido na wishlist, remova um antes de adionar novamente")
public class MaximumItemsWishListException  extends RuntimeException{
}

package com.danilodorgam.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 11/04/2021 on 15:08
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item não encontrado na lista de desejos")
public class NotFoundException extends RuntimeException{
}

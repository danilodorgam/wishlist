package com.danilodorgam.wishlist;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;

import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


/**
 * @author danilodorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 * @created 11/04/2021 on 15:56
 */
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WishlistIntegrationTest {
    private final String BARRA = "/";
    private final String URL_BASE = "wishlist";
    private final String ID_CLIENT = "20";
    private final String ID_PRODUTO = "20";
    @Autowired
    private MockMvc mockMvc;



    @Test
    /**
     * Adiciona um item na lista do cliete
     */
    public void test1() throws Exception {

        this.mockMvc
                .perform(post(
                        buildUrl(URL_BASE))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                        "  \"clientID\": "+ID_CLIENT+"," +
                        "  \"produtoID\": "+ID_PRODUTO+"" +
                        "}"))
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(content().string(is("")));

    }
    @Test
    /**
     * Verifica se o item foi adicionando na lista do cliente
     */
    public void test2() throws Exception {

       this.mockMvc
                .perform(get(buildUrl(URL_BASE,ID_PRODUTO,ID_CLIENT)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(matchesJsonSchemaInClasspath("schemas/JsonSchema.json")));


    }

    @Test
    /**
     * lista todos os produtos na lista do cliente
     */
    public void test3() throws Exception {

        this.mockMvc
                .perform(get(buildUrl(URL_BASE,ID_CLIENT)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(matchesJsonSchemaInClasspath("schemas/JsonSchemaList.json")));

    }






    private String buildUrl(String ... parametros) {
        StringBuilder urlMontada = new StringBuilder();
        for (String parametro : parametros) {
            urlMontada.append(BARRA);
            urlMontada.append(parametro);
        }
        return urlMontada.toString();
    }

}

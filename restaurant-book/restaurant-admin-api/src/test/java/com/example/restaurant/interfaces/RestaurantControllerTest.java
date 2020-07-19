package com.example.restaurant.interfaces;

import com.example.restaurant.application.RestaurantService;
import com.example.restaurant.domain.*;
import com.example.restaurant.domain.RestaurantNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//웹에 대한 요청 test 만들기
@ExtendWith(SpringExtension.class) //스프링을 통해 이 테스트를 실행할거다
@WebMvcTest(RestaurantController.class) //RestaurantController를 테스트 할거다
class RestaurantControllerTest {

    @Autowired //스프링을 통해 주입해주자
    private MockMvc mvc;

    @MockBean // 실제로 이 서비스가 어떻게 되어 있는지와 상관없이 컨트롤러가 만들어준 가짜를 가지고 처리함
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder()
                        .id(1004L)
                        .categoryId(1L)
                        .name("Bab zip")
                        .address("Seoul")
                        .build());
        given(restaurantService.getRestaurants()).willReturn(restaurants); //restaurantService가 가짜로 리스트를 불러옴

        mvc.perform(get("/restaurant"))
            .andExpect(status().isOk()) //통신 상태가 200인가
            .andExpect(content().string(
                    containsString("\"id\":1004")
            ))
            .andExpect(content().string(
                    containsString("\"name\":\"Bab zip\"")
            ));
    }

    @Test
    public void detailWithExisted() throws Exception {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .categoryId(1L)
                .name("Bab zip")
                .address("Seoul")
                .build();

        given(restaurantService.getRestaurantById(1004L)).willReturn(restaurant);

        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bab zip\"")
                ));

    }

   /* @Test
    public void detailWithNotExisted() throws Exception {
        given(restaurantService.getRestaurantById(404L))
                .willThrow(new RestaurantNotFoundException(404L));

        mvc.perform(get("/restaurant/404"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{}"));
    }*/

    @Test
    public void createVaildData() throws Exception { //유효한 데이터 입력
        given(restaurantService.addRestaurant(any())).will(invocation -> {
           Restaurant restaurant = invocation.getArgument(0);
           return Restaurant.builder()
                   .id(1234L)
                   .categoryId(1L)
                   .name(restaurant.getName())
                   .address(restaurant.getAddress())
                   .build();
        });

        mvc.perform(post("/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"categoryId\":1, \"name\":\"BeBe\", \"address\":\"Seoul\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurant/1234"))
                .andExpect(content().string("{}"));

        verify(restaurantService).addRestaurant(any());
    }

    /*@Test
    public void createWithInvaildData() throws Exception { //유효하지 않은 데이터 입력
        mvc.perform(post("/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\", \"address\":\"\"}"))
                .andExpect(status().isBadRequest());
    }*/

    @Test
    public void updateWithValidData() throws Exception {
        mvc.perform(patch("/restaurant/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"categoryId\":1, \"name\":\"Bab zip\", \"address\":\"Seoul\"}"))
                .andExpect(status().isOk());

        verify(restaurantService).updateRestaurant(1004L, "Bab zip", "Seoul");
    }

    /*@Test
    public void updateWithInvalidData() throws Exception {
        mvc.perform(patch("/restaurant/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\", \"address\":\"\"}"))
                .andExpect(status().isBadRequest());
    }*/
}

/*
* any() : 어떤 객체가 들어오던지 실행만 되면 Ok.
* */

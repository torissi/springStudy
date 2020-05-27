package com.example.restaurant.interfaces;

import com.example.restaurant.application.RestaurantService;
import com.example.restaurant.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
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
        restaurants.add(new Restaurant(1004L, "Bab zip", "Seoul"));
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
    public void detail() throws Exception {
        Restaurant restaurant1 = new Restaurant(1004L, "Bab zip", "Seoul");
        restaurant1.addMenuItem(new MenuItem("Kimchi"));
        Restaurant restaurant2 = new Restaurant(2020L, "Cyber food", "Seoul");
        restaurant2.addMenuItem(new MenuItem("Kimchi"));

        given(restaurantService.getRestaurantById(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurantById(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bab zip\"")
                ))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));
        mvc.perform(get("/restaurant/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber food\"")
                ));
    }

    @Test
    public void create() throws Exception {
        mvc.perform(post("/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"BeBe\", \"address\":\"Seoul\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurant/1234"))
                .andExpect(content().string("{}"));

        verify(restaurantService).addRestaurant(any());
    }

    @Test
    public void update() throws Exception {
        mvc.perform(patch("/restaurant/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Bab zip\", \"address\":\"Seoul\"}"))
                .andExpect(status().isOk());

        verify(restaurantService).updateRestaurant(1004L, "Bab zip", "Seoul");
    }
}

/*
* any() : 어떤 객체가 들어오던지 실행만 되면 Ok.
* */

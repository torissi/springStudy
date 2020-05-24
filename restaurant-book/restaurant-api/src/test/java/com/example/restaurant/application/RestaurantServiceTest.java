package com.example.restaurant.application;

import com.example.restaurant.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp() {
        mockRestaurantRepository();
        mockMenuItemRepository();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    private void mockRestaurantRepository() {
        MockitoAnnotations.initMocks(this); //@Mock이 붙은 객체를 초기화. Mockito 어노테이션이 선언된 변수들은 객체를 만듦
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bab zip", "Seoul");
        restaurants.add(restaurant);

        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItem = new ArrayList<>();
        menuItem.add(new MenuItem("Kimchi"));

        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItem);
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }

    @Test
    public void getRestaurantById() {
        Restaurant restaurant = restaurantService.getRestaurantById(1004L);

        assertThat(restaurant.getId()).isEqualTo(1004L);

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName()).isEqualTo("Kimchi");
    }
}

/* @Autowire를 쓰면 스프링이 객체를 자동 주입
*그러나 우리는 지금 일반적인 test를 진행중이기 떄문에 의존관계를 주입할 수 없음
* 그래서 직접 repository를 service에 연결해줘야함
* 그 작업이 @BeforeAll 붙은 곳임
* */
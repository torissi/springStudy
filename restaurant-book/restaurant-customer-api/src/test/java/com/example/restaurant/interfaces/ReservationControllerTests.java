package com.example.restaurant.interfaces;

import com.example.restaurant.application.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
class ReservationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void create() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJqb29oZWUifQ.Lx34QEtZtn2EBdLgNO5QLUGe17sr_fVjX5c0w59i2aQ";
        Long userId = 1004L;
        String name = "joohee";
        String date = "2020-10-20";
        String time = "20:00";
        Integer partySize = 20;

        mvc.perform(post("/restaurants/369/reservation")
            .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"date\":\"2020-10-20\", \"time\":\"20:00\", \"partySize\":20}")
        ).andExpect(status().isCreated());


        verify(reservationService).addReservation(eq(369L), eq(userId), eq(name),
                eq(date), eq(time), eq(partySize));
    }
}
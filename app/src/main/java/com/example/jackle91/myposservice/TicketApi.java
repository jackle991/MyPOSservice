package com.example.jackle91.myposservice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TicketApi {
    @POST("/ticket")
    Call<Ticket> postTicket(@Body Ticket ticket);
}

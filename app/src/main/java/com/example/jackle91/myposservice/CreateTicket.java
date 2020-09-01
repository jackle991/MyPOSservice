package com.example.jackle91.myposservice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jackle91.myposservice.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateTicket extends AppCompatActivity {

    TextView responseText;
    EditText ticketNumberText;
    EditText storeIdText;
    EditText businessDateText;
    EditText totalPriceText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_ticket);

        responseText = findViewById(R.id.responseText);

        ticketNumberText = (EditText)findViewById(R.id.ticketNumber);
        storeIdText = (EditText)findViewById(R.id.storeId);
        businessDateText = (EditText)findViewById(R.id.businessDate);
        totalPriceText = (EditText)findViewById(R.id.totalPrice);

        submitButton = (Button)findViewById(R.id.submitButton);

//        Log.i("****ticketNumber**** ", ticketNumberText.getText().toString());
//        Log.i("****StoreID**** ", storeIdText.getText().toString());

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String ticketNumber = ticketNumberText.getText().toString();
                String storeId = storeIdText.getText().toString();
                String businessDate = businessDateText.getText().toString();
                String totalPrice = totalPriceText.getText().toString();

//                System.out.println("****ticketNumber**** " + ticketNumber);
//                System.out.println("****StoreId**** " + storeId);
//                System.out.println("****BusinessDate**** " + businessDate);
//                System.out.println("****TotalPrice**** " + totalPrice);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.28:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                TicketApi ticketApi = retrofit.create(TicketApi.class);

                Ticket ticket = new Ticket(ticketNumber, storeId, businessDate, totalPrice);

                Call<Ticket> call = ticketApi.postTicket(ticket);

                call.enqueue(new Callback<Ticket>() {
                    @Override
                    public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                        if (!response.isSuccessful()) {
                            responseText.setText("Code: " + response.code());
//                            responseText.setText("Code: " + ticketNumberText.getText().toString());
                            return;
                        }
//                        Ticket t = response.body();
                        responseText.setText("Ticket Created Successful");
                    }

                    @Override
                    public void onFailure(Call<Ticket> call, Throwable t) {
                        responseText.setText(t.getMessage());
                    }
                });
            }
        });

    }
}
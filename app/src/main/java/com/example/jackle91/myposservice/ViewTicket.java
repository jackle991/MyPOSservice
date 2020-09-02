package com.example.jackle91.myposservice;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jackle91.myposservice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class ViewTicket extends AppCompatActivity {
    TextView tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ticket);

        tickets = findViewById(R.id.viewTickets);

        // Get a reference to our posts
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/Tickets/");

        ref.addChildEventListener(childEventListener);
        // Attach a listener to read the data at our posts reference
//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                Ticket ticket = dataSnapshot.getValue(Ticket.class);
//                System.out.println("TicketNumber: " + ticket.ticketNumber);
//                System.out.println("Store: " + ticket.storeId);
//                System.out.println("Previous Post ID: " + prevChildKey);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
    }

    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
            Log.i("onChildAdded: ", dataSnapshot.getKey());

            for (DataSnapshot d : dataSnapshot.getChildren()) {}

            // A new comment has been added, add it to the displayed list
            Ticket ticket = dataSnapshot.getValue(Ticket.class);
            if (ticket != null) {
                tickets.setText(ticket.toString());
            }
        }
        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
        }
        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    };
}
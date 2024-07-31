package com.example.climaact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private Button checkoutButton;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        checkoutButton = findViewById(R.id.checkoutButton);

        cartAdapter = new CartAdapter(Cart.getInstance().getItems(), new CartAdapter.OnCartItemChangeListener() {
            @Override
            public void onQuantityChanged() {
                updateTotalPrice();
            }
        });

        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerView.setAdapter(cartAdapter);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cart.getInstance().getItemCount() > 0) {
                    // In a real app, you'd process the payment here
                    Toast.makeText(CartActivity.this, "Processing payment...", Toast.LENGTH_SHORT).show();

                    // Clear the cart after successful checkout
                    Cart.getInstance().clearCart();

                    // Update the UI
                    cartAdapter.notifyDataSetChanged();
                    updateTotalPrice();

                    // Optionally, return to the main screen
                    finish();
                } else {
                    Toast.makeText(CartActivity.this, "Your cart is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = Cart.getInstance().getTotalPrice();
        checkoutButton.setText(String.format("Checkout $%.2f", total));
    }
}

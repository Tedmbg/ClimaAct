package com.example.climaact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PlantsGridActivity extends AppCompatActivity {
    private RecyclerView plantsRecyclerView;
    private Button goToCartButton;
    private PlantAdapter plantAdapter;
    private List<Plant> plantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_grid);

        plantsRecyclerView = findViewById(R.id.plantsRecyclerView);
        goToCartButton = findViewById(R.id.goToCartButton);

        plantList = new ArrayList<>();
        // Add sample plants
        plantList.add(new Plant("Beethoven", "Succulent", 15.99, R.drawable.beethoven));
        plantList.add(new Plant("Lottie", "Ficus Audrey", 25.99, R.drawable.lottie));
        plantList.add(new Plant("Marty", "Yucca", 30.99, R.drawable.marty));
        plantList.add(new Plant("Cookie", "Cactus", 10.99, R.drawable.cookie));

        plantAdapter = new PlantAdapter(plantList, new PlantAdapter.OnPlantClickListener() {
            @Override
            public void onPlantClick(Plant plant) {
//                Cart.getInstance().addItem(plant);
                updateCartButton();
            }
        });

        plantsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        plantsRecyclerView.setAdapter(plantAdapter);

        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlantsGridActivity.this, CartActivity.class));
            }
        });

        updateCartButton();
    }

    private void updateCartButton() {
        if (Cart.getInstance().getItemCount() > 0) {
            goToCartButton.setVisibility(View.VISIBLE);
        } else {
            goToCartButton.setVisibility(View.GONE);
        }
    }
}
package fr.isep.ii3510.pokemonstarters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    // Each of the following method is a listener attached to one of the RadioButton
    // declared on the user interface
    // In this case, we simple change the image resource to display the corresponding image
    public void bulbasaurClicked(View view) {
        imageView.setImageResource(R.drawable.bulbasaur);
    }

    public void charmanderClicked(View view) {
        imageView.setImageResource(R.drawable.charmander);
    }

    public void squirtleClicked(View view) {
        imageView.setImageResource(R.drawable.squirtle);
    }
}
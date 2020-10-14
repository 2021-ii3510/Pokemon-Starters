package fr.isep.ii3510.pokemonstarters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String BULBASAUR = "bulbasaur";
    public static final String CHARMANDER = "charmander";
    public static final String SQUIRTLE = "squirtle";
    private ImageView imageView;
    private String selectedPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // If we change the orientation without having interacted with the RadioButtons
        if (selectedPokemon == null) {
            selectedPokemon = BULBASAUR;
        }
        outState.putString("Pokemon", selectedPokemon);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedPokemon = savedInstanceState.getString("Pokemon");
        updateDisplayAfterConfigurationChange();
    }

    private void updateDisplayAfterConfigurationChange() {
        // The image needs to be updated no matter which screen orientation we have, because both UIs have an ImageView
        imageView.setImageResource(getResources().getIdentifier(selectedPokemon, "drawable", getPackageName()));

        // If screen orientation is in portrait, we have to check the appropriate RadioButton
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            String radioButtonIdName = selectedPokemon + "_button";
            RadioButton checkedButton = findViewById(getResources().getIdentifier(radioButtonIdName, "id", getPackageName()));
            checkedButton.setChecked(true);
        } else {
            // Else, we have to display the appropriate Pokémon description
            String descriptionId = selectedPokemon + "_description";
            TextView textView = findViewById(R.id.description_textView);
            textView.setText(getString(getResources().getIdentifier(descriptionId, "string", getPackageName())));
        }
    }


    // Each of the following method is a listener attached to one of the RadioButton
    // declared on the user interface
    // In this case, we simple change the image resource to display the corresponding image
    public void bulbasaurClicked(View view) {
        imageView.setImageResource(R.drawable.bulbasaur);
        selectedPokemon = BULBASAUR;
    }

    public void charmanderClicked(View view) {
        imageView.setImageResource(R.drawable.charmander);
        selectedPokemon = CHARMANDER;
    }

    public void squirtleClicked(View view) {
        imageView.setImageResource(R.drawable.squirtle);
        selectedPokemon = SQUIRTLE;
    }
}
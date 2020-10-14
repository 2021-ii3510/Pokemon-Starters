# Pokemon-Starters

## Idea behind this app

This application is just a toy application to showcase how we can dynamically change the user 
interface by interacting with selection widgets (and in this case, `RadioButton`).

It is also a nice way to introduce images and `ImageView`.


## Version 2 (with orientation)

In this second version of Pokemon Starters, we have worked with orientation to show a small description of
the Pokémon that is currently selected.

### How to know which Pokémon is selected?

To answer this question, we have created a class variable `String selectedPokemon` which will simply take
the name of the selected pokémon. It is this variable (and its value) that will be saved on the `savedInstanceState` bundle.

This variable is set in different places:

- Either when a `RadioButton` is clicked;
- Or directly in the `onSaveInstanceState()` method, if we rotate the screen without having interacted with the `RadioButtons`.

### How do we update the UI?

I have implemented a new method called `updateDisplayAfterConfigurationChange()` which is called by the `onRestoreInstanceState()` method.
The logic of this new method is as follows:

1. Whether we are in portrait or landscape mode, we can set the image resource of our `imageView` with the contents of `selectedPokemon`;
2. If we are in portrait mode:

    1. We can benefit from the fact that the `ids` of our `RadioButtons` are all of the following format: `pokemonName_button`
    to retrieve the `RadioButton` that corresponds to the `selectedPokemon`.
    2. We can then dynamically set its `isChecked` attribute to `true`.
    
3. If we are in landscape mode:

    1. We can also benefit from the fact that the `ids` of our descriptions are all of the following format: `pokemonName_description`
    to retrieve the description that corresponds to the `selectedPokemon`.
    2. We can then dynamically set the text of the `descriptionTextView` to the description retrieved.

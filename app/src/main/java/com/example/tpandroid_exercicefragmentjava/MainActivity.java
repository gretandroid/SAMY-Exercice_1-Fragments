package com.example.tpandroid_exercicefragmentjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    // BONUS
    public static int selectedCategory = 0;
    private Fragment1 fragment1;

    private Fragment2 fragment2;
    public static boolean isPortrait;
    final static String CATEGORY_INDEX = "CATEGORY_INDEX";
    public static String[] categories = {"Entrées", "Plats", "Desserts", "Boissons"};
    public static String[][] articles = {
            {
                    "Les 3 Foies Gras en Chaud et Froid, Saveurs  Chocolatées, Sauce aigre douce Rhubarbe",
                    "Le Carpaccio de Saint Jacques sur Lit d’Aubergine, Huile D'olive Citronnée Glace au Piment d’espelette",
                    "Les Ravioli de Cèpes et Truffes aux Foie Gras et Jus de Cèpes",
                    "Ma version de la Carotte au Homard, Légumes Croquants, Vinaigrette Rouge",
                    "La Boite Nippone de Crevettes comme une Salade au Germes de Légumes Saveurs d’Agrumes"
            },
            {
                    "Le Pressé de Veau au Foie Gras Snacké Jus de Réduction",
                    "Le Poulet Fermier Label Rouge",
                    "Les Lasagne de Fruits de Mer",
                    "La Parillada à la Plancha",
                    "Le Filet de Poisson Noble cuit sur Pierre au Jus d’Herbes",
                    " Filet de Lottes Comme un Wok Façon Thaï"
            },
            {
                    "Les Profiteroles au Chocolat Chaud Maison",
                    "Le Fondant au Chocolat l’Original, Sorbet Passion",
                    "Le Miel en Gaufre au Chèvre Frais Battu , Sorbet Fleur d’Oranger",
                    "Crémeux Caramel, sorbet Baie d’Açaï, Biscuit Pralines",
                    "La Coupe Colonel Au sorbet Citron ou Baie d’Açaï"
            },
            {
                    "Sangria Maison",
                    "La Flûte de Champagne Nicolas Feuillatte",
                    "Haut de Sénaux Viognier L’Ormarine (Vin Blanc)",
                    "Cinsault Domaine l’Ile St Martin Gruissan (Rosé)",
                    "Sodas Canette 33 cl (Coca Cola, Ice-Tea pêche, Limonade, Oasis, Perrier, Orangina, Limonade)"
            }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.mainActivityFragment1);
        isPortrait = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) ? true : false;
        if(!isPortrait) fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.mainActivityFragment2);
    }

    public void openSecondActivityWithId(int id) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(CATEGORY_INDEX, id);

        // BONUS : on sauvegarde l'ID pour pouvoir l'enregistrer dans le Bundle
        selectedCategory = id;

        startActivity(intent);
    }

    public void displayDatasInFragment2WithId(int id) {
        // Mise à jour de la liste du fragment 2
        fragment2.listView.setAdapter(
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        articles[id])
        );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedCatagory", selectedCategory);
    }
}
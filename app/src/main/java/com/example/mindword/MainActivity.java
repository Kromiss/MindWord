package com.example.mindword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button start;
    Button show;
    Button restart;
    Random rand = new Random();
    NumberPicker np;
    TextView joueur;
    TextView mot;

    List<String> mots = new ArrayList<String>();
    List<String> perso = new ArrayList<String>();


    int index = 0;
    int nbJoueurs = 0;
    int currentJoueur = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        np = (NumberPicker) findViewById(R.id.np);
        start = (Button) findViewById(R.id.start);
        show = (Button) findViewById(R.id.show);
        restart = (Button) findViewById(R.id.restart);
        restart.setVisibility(View.INVISIBLE);
        show.setText("Show");
        show.setVisibility(View.INVISIBLE);
        mot = (TextView) findViewById(R.id.mot);
        joueur = (TextView) findViewById(R.id.Joueur);
        mot.setVisibility(View.VISIBLE);

        np.setMaxValue(10);
        np.setMinValue(4);

        restart.setOnClickListener(MainActivity.this);
        start.setOnClickListener(MainActivity.this);
        show.setOnClickListener(MainActivity.this);
        initList();

    }

    @Override
    public void onClick(View v) {
        if(start.getId() == v.getId())
        {
            nbJoueurs = np.getValue();
            int size = mots.size();
            index = rand.nextInt(size);
            int espion1 = rand.nextInt(nbJoueurs);
            int espion2 = rand.nextInt(nbJoueurs);
            while(espion1==espion2)
                espion2 = rand.nextInt(nbJoueurs);
            for(int i = 0; i<nbJoueurs; i++)
            {
                if(i == espion1 || i == espion2)
                    perso.add(mots.get(index));
                else
                    perso.add("Trouvez les espions");

            }
            show.setVisibility(View.VISIBLE);
            start.setVisibility(View.INVISIBLE);
            joueur.setText("Joueur " + String.valueOf(currentJoueur+1));
        }
        else if(show.getId() == v.getId())
        {
            if(show.getText() == "Show")
            {
                mot.setText(perso.get(currentJoueur));
                show.setText("Hide");
            }
            else if(show.getText() == "Hide")
            {
                currentJoueur++;
                if(currentJoueur == nbJoueurs)
                {
                    play();
                    return;
                }
                mot.setText("");
                joueur.setText("Joueur " + String.valueOf(currentJoueur+1));
                show.setText("Show");
            }
        }
        else if(restart.getId() == v.getId())
        {
            show.setText("Show");
            currentJoueur = 0;
            perso.clear();
            start.setVisibility(View.VISIBLE);
            restart.setVisibility(View.INVISIBLE);
        }

    }

    public void initList()
    {
        mots.add("Œufs");
        mots.add("Transport");
        mots.add("Jupe");
        mots.add("Train");
        mots.add("Rapide");
        mots.add("Lumière");
        mots.add("Coffre");
        mots.add("Serpent");
        mots.add("Souris");
        mots.add("Mer");
        mots.add("Épaule");
        mots.add("Films");
        mots.add("Bus");
        mots.add("Vieux");
        mots.add("Six");
        mots.add("Rose");
        mots.add("Château");
        mots.add("Trompette");
        mots.add("Cuisinier");
        mots.add("Tournesol");
        mots.add("Chèvre");
        mots.add("Grand");
        mots.add("Tarte");
        mots.add("Nuage");
        mots.add("Parasol");
        mots.add("Étoile");
        mots.add("Peintre");
        mots.add("Tomate");
        mots.add("Chaussettes");
        mots.add("Abeille");
        mots.add("Neuf");
        mots.add("Camion");
        mots.add("Père");
        mots.add("Vache");
        mots.add("Lanterne");
        mots.add("Tête");
        mots.add("Ours");
        mots.add("Bocal");
        mots.add("Chaud");
        mots.add("Froid");
        mots.add("Fer");
        mots.add("Évier");
        mots.add("Poisson");
        mots.add("Papier");
        mots.add("Étain");
        mots.add("Balle");
        mots.add("Oignon");
        mots.add("Rouge");
        mots.add("Fleur");
        mots.add("Spaghetti");
        mots.add("Politique");
        mots.add("Sécurité");
        mots.add("Perpendiculaire");
        mots.add("Astrologie");
        mots.add("Herbe");
        mots.add("Plomb");
        mots.add("Cafard");
        mots.add("Plumes");
        mots.add("Corse");
        mots.add("Egypte");
        mots.add("Cyclope");
        mots.add("Boîte ");
        mots.add("Indiens");
        mots.add("Pointe");
        mots.add("Fruit");
        mots.add("Miroir");
        mots.add("Radio");
        mots.add("Trésor");
        mots.add("Voleur");
        mots.add("Neige");
        mots.add("Chaussette");



    }

    public void play(){
        show.setVisibility(View.INVISIBLE);
        joueur.setText("");
        mot.setText("");
        restart.setVisibility(View.VISIBLE);
    }
}

package com.example.ddl.ui.galerie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ddl.Globals;
import com.example.ddl.R;

public class GalerieFragment extends Fragment {

    private ImageView bild1;
    private ImageView bild2;
    private ImageView bild3;
    private ImageView bild4;
    private ImageView bild5;
    private ImageView bild6;
    private ImageView bild7;
    private ImageView bild8;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_galerie, container, false);

        bild1 =root.findViewById(R.id.bild1);
        bild2 =root.findViewById(R.id.bild2);
        bild3 =root.findViewById(R.id.bild3);
        bild4 =root.findViewById(R.id.bild4);
        bild5 =root.findViewById(R.id.bild5);
        bild6 =root.findViewById(R.id.bild6);
        bild7 =root.findViewById(R.id.bild7);
        bild8 =root.findViewById(R.id.bild8);

        bild1.setImageBitmap(Globals.galerie[0]);
        bild2.setImageBitmap(Globals.galerie[1]);
        bild3.setImageBitmap(Globals.galerie[2]);
        bild4.setImageBitmap(Globals.galerie[3]);
        bild5.setImageBitmap(Globals.galerie[4]);
        bild6.setImageBitmap(Globals.galerie[5]);
        bild7.setImageBitmap(Globals.galerie[6]);
        bild8.setImageBitmap(Globals.galerie[7]);



        return root;
    }
}

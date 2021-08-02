package com.example.ddl.ui.galerie;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ddl.Globals;
import com.example.ddl.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GalerieFragment extends Fragment {

    private ImageView bild1; private Button bb1;
    private ImageView bild2; private Button bb2;
    private ImageView bild3; private Button bb3;
    private ImageView bild4; private Button bb4;
    private ImageView bild5; private Button bb5;
    private ImageView bild6; private Button bb6;
    private ImageView bild7; private Button bb7;
    private ImageView bild8; private Button bb8;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_galerie, container, false);

        bild1 =root.findViewById(R.id.bild1); bb1 =root.findViewById(R.id.bb1);
        bild2 =root.findViewById(R.id.bild2); bb2 =root.findViewById(R.id.bb2);
        bild3 =root.findViewById(R.id.bild3); bb3 =root.findViewById(R.id.bb3);
        bild4 =root.findViewById(R.id.bild4); bb4 =root.findViewById(R.id.bb4);
        bild5 =root.findViewById(R.id.bild5); bb5 =root.findViewById(R.id.bb5);
        bild6 =root.findViewById(R.id.bild6); bb6 =root.findViewById(R.id.bb6);
        bild7 =root.findViewById(R.id.bild7); bb7 =root.findViewById(R.id.bb7);
        bild8 =root.findViewById(R.id.bild8); bb8 =root.findViewById(R.id.bb8);

        if (Globals.firstVisit2){
            for(int i = 0; i<=7; i++){
                loadImageFromStorage( "/data/data/com.example.ddl/app_imageDir", i);
                Globals.firstVisit2=false;
            }
        }

        bild1.setImageBitmap(Globals.galerie[0]);
        bild2.setImageBitmap(Globals.galerie[1]);
        bild3.setImageBitmap(Globals.galerie[2]);
        bild4.setImageBitmap(Globals.galerie[3]);
        bild5.setImageBitmap(Globals.galerie[4]);
        bild6.setImageBitmap(Globals.galerie[5]);
        bild7.setImageBitmap(Globals.galerie[6]);
        bild8.setImageBitmap(Globals.galerie[7]);

        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[0]!=null) {
                    Globals.vorschau = Globals.galerie[0];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[1]!=null) {
                    Globals.vorschau = Globals.galerie[1];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[2]!=null) {
                    Globals.vorschau = Globals.galerie[2];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[3]!=null) {
                    Globals.vorschau = Globals.galerie[3];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[4]!=null) {
                    Globals.vorschau = Globals.galerie[4];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[5]!=null) {
                    Globals.vorschau = Globals.galerie[5];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[6]!=null) {
                    Globals.vorschau = Globals.galerie[6];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        bb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.galerie[7]!=null) {
                    Globals.vorschau = Globals.galerie[7];
                    Globals.reset=false;
                    NavController navController = Navigation.findNavController(root);
                    navController.navigate(R.id.action_navigation_galerie_to_navigation_hochladen);
                }
            }
        });

        return root;
    }

    private void loadImageFromStorage(String path, int i)
    {
        try {
            File f= new File(path, "bild"+i+".jpg");
            Globals.galerie[i]= BitmapFactory.decodeStream(new FileInputStream(f));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}

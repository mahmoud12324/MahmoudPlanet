package com.example.mahmoudplanet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


public class AddPlanetFragment extends Fragment {

    private FirebaseServices fbs;
    private EditText etName, etSize, etOrbit, etNumberOfPeople;
    private Button btnAdd;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String name;
    private String size;
    private String orbit;
    private String number;

    public AddPlanetFragment() {

    }

    public static AddPlanetFragment newInstance(String param1, String param2) {
        AddPlanetFragment fragment = new AddPlanetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           name = getArguments().getString(name);
            size = getArguments().getString(size);
            orbit = getArguments().getString(orbit);
            number = getArguments().getString(number);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.addplanet, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectComponents();

    }

    private void connectComponents() {
        fbs = FirebaseServices.getInstance();
        etName = getView().findViewById(R.id.etNameAddPlanet);
        etSize = getView().findViewById(R.id.etSizeAddPlanet);
       etOrbit = getView().findViewById(R.id.etOrbitAddPlanet);
        etNumberOfPeople = getView().findViewById(R.id.etNumberOfPoepleAddPlanet);
        btnAdd = getView().findViewById(R.id.btnAddAddRestaurantFragment);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                String name = etName.getText().toString();
                String Size = etSize.getText().toString();
                String Orbit = etOrbit.getText().toString();
                String Number = etNumberOfPeople.getText().toString();

                // data validation
                if (name.trim().isEmpty() || Size.trim().isEmpty() ||
                        Orbit.trim().isEmpty() || Number.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }

                // add data to firestore
               planet rest = new planet();

                fbs.getFire().collection("restaurants").add(rest).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your restaurant!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddRestaurant: ", e.getMessage());
                    }
                });


            }
        });
    }
}

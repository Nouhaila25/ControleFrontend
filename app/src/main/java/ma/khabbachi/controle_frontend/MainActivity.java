package ma.khabbachi.controle_frontend;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import ma.khabbachi.controle_frontend.Adapter.EmployeeAdapter;


public class MainActivity extends AppCompatActivity {

    private List<Employe> employesList = new ArrayList<>();
    private EmployeeAdapter employeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ajoutez le code pour le bouton "Go Back"
//        Button buttonBack = findViewById(R.id.buttonBack);
//        buttonBack.setOnClickListener(v -> {
//            // Code pour revenir en arrière ici
//            finish();
//        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewEmployes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeAdapter = new EmployeeAdapter(employesList);
        recyclerView.setAdapter(employeAdapter);

        // Appelle la méthode pour récupérer tous les étudiants
        fetchAllEmployes();


    }

    private void fetchAllEmployes() {
        String apiUrl = "http://10.0.2.2:8089/api/v1/employes";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                apiUrl,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseEmployes(response);
                        employeAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Erreur de récupération des étudiants", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }

    private void parseEmployes(JSONArray jsonArray) {
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject studentObject = jsonArray.getJSONObject(i);

                String nom = studentObject.getString("nom");
                String prenom = studentObject.getString("prenom");
                String dateNaissance = studentObject.getString("dateNaissance");

                Employe employe = new Employe(nom, prenom, dateNaissance);
                employesList.add(employe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
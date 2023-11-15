package ma.khabbachi.controle_frontend.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import ma.khabbachi.controle_frontend.Employe;
import ma.khabbachi.controle_frontend.R;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employe> employes;

    public EmployeeAdapter(List<Employe> employes) {
        this.employes = employes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employe employe = employes.get(position);
        holder.textViewNom.setText("Nom: " + employe.getNom());
        holder.textViewPrenom.setText("Prenom: " + employe.getPrenom());
        holder.textViewDateNaissance.setText("date: " + employe.getDateNaissance());

        // Ajoute d'autres liaisons de données si nécessaire
    }

    @Override
    public int getItemCount() {
        return employes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNom;
        public TextView textViewPrenom;

        public TextView textViewDateNaissance;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewPrenom = itemView.findViewById(R.id.textViewPrenom);
            textViewDateNaissance = itemView.findViewById(R.id.textViewDateNaissance);
        }
    }
}
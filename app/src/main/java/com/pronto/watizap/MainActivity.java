package com.pronto.watizap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.pronto.watizap.adapters.ConversasAdapters;
import com.pronto.watizap.data.Conversa;
import com.pronto.watizap.databinding.ActivityMainBinding;
import com.pronto.watizap.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    ActivityMainBinding binding;

    List<Conversa> conversas;
    ConversasAdapters conversaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_superior, menu);
        setTitle("Whatszapp");
        return super.onCreateOptionsMenu(menu);
    }

    private void init() {
        setSupportActionBar(binding.toolbarTop);
        conversas = new ArrayList<>();
        conversas.add(new Conversa(1,R.drawable.person3, "Arthur Damous", "Estou a caminho", "04/11/2021"));
        conversas.add(new Conversa(2,R.drawable.person4, "Vicente Castro", "Olá, estou chegando no destinho", "04/12/2021"));
        conversas.add(new Conversa(3,R.drawable.person5, "Giovanni Martinez", "Hi, i'm from another planet", "04/11/2020"));
        conversas.add(new Conversa(4,R.drawable.person6, "Antero Mendes", "Pode deixar, já estou chegando", "15/11/2020"));
        setupRecyclerConversas(conversas);
    }

    private void setupRecyclerConversas(List<Conversa> conversas) {
        this.conversas = conversas;
        conversaAdapter = new ConversasAdapters();
        conversaAdapter.submitList(conversas);
        conversaAdapter.setOnItemClickListener(this);
        binding.rvConversas.setAdapter(conversaAdapter);
        binding.rvConversas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void entrarConversa(int idConversa, String nomeUsuario){
        startActivity(ChatActivity.newIntentInstance(this, idConversa, nomeUsuario));
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        Conversa conversa = (Conversa) item;
        entrarConversa(conversa.getId(), conversa.getNomeUsuario());
    }
}
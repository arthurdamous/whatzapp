package com.pronto.watizap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.pronto.watizap.adapters.ChatAdapter;
import com.pronto.watizap.data.Mensagem;
import com.pronto.watizap.databinding.ActivityChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;

    private List<Mensagem> mensagensEnviadas;
    private List<Mensagem> mensagensRecebidas;

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init(){
        mensagensEnviadas = new ArrayList<>();
        mensagensRecebidas = new ArrayList<>();
        mensagensEnviadas.add(new Mensagem(1,"Olá bom dia, como estás ?","04/03/2020"));
        mensagensEnviadas.add(new Mensagem(1,"Olá bom dia, como estás ?","04/03/2020"));
        mensagensEnviadas.add(new Mensagem(1,"Olá bom dia, como estás ?","04/03/2020"));
        mensagensEnviadas.add(new Mensagem(1,"Olá bom dia, como estás ?","04/03/2020"));
        mensagensEnviadas.add(new Mensagem(1,"Olá bom dia, como estás ?","04/03/2020"));
        mensagensRecebidas.add(new Mensagem(1,"Estou bem ","04/03/2020"));
        setupRecyclerEnviadas(mensagensEnviadas);
    }

    private void setupRecyclerEnviadas(List<Mensagem> mensagensEnviadas) {
        this.mensagensEnviadas = mensagensEnviadas;
        adapter = new ChatAdapter();
        adapter.submitList(mensagensEnviadas);
        binding.rvConversa.setAdapter(adapter);
        binding.rvConversa.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


    }
}
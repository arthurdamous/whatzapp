package com.pronto.watizap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;

import com.pronto.watizap.adapters.ChatAdapter;
import com.pronto.watizap.data.Mensagem;
import com.pronto.watizap.databinding.ActivityChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private static String ID_CONVERSA;
    private static String NOME_USUARIO;

    private ActivityChatBinding binding;

    private List<Mensagem> mensagens;

    private ChatAdapter adapter;

    private int idConversa;
    private String nomeUsuario;

    public static Intent newIntentInstance(Context context, int idConversa, String nomeUsuario) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(ID_CONVERSA, idConversa);
        intent.putExtra(NOME_USUARIO, nomeUsuario);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        idConversa = getIntent().getIntExtra(ID_CONVERSA, 0);
        nomeUsuario = getIntent().getStringExtra(NOME_USUARIO);
        setSupportActionBar(binding.toolbarSup);
        initConversa();
        initTextEvent();
        binding.btnAudio.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_superior_chat, menu);
        setTitle(nomeUsuario);
        return super.onCreateOptionsMenu(menu);
    }

    private void initConversa() {
        mensagens = new ArrayList<>();
        mensagens.add(new Mensagem(1, "Olá bom dia, como estás ?", "10:31", false));
        mensagens.add(new Mensagem(2, "Estou bem", "10:31", true));
        mensagens.add(new Mensagem(3, "Que bom", "10:31", false));
        mensagens.add(new Mensagem(4, "Legal", "10:31", false));
        mensagens.add(new Mensagem(5, "e voce ?", "10:31", true));
        mensagens.add(new Mensagem(6, "Barack, queria falar uma coisa", "10:31", true));
        mensagens.add(new Mensagem(7, "tem como tu me dar 200 conto ?", "10:31", true));
        mensagens.add(new Mensagem(8, "te pago quando o brasil ficar top", "10:31", true));
        mensagens.add(new Mensagem(9, "Na hora meu querido", "10:32", false));
        mensagens.add(new Mensagem(10, "Pode pedir pro vicente, depois eu pago ele", "10:32", false));
        setupRecyclerEnviadas(mensagens);
    }

    private void setupRecyclerEnviadas(List<Mensagem> mensagens) {
        LinearLayoutManager manager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        manager.setStackFromEnd(true);
        this.mensagens = mensagens;
        adapter = new ChatAdapter();
        adapter.submitList(mensagens);
        binding.rvConversa.setAdapter(adapter);
        binding.rvConversa.setLayoutManager(manager);
    }

    private void sendMessage() {
        mensagens = new ArrayList<>(mensagens);
        Mensagem mensagem = new Mensagem(11, binding.etChat.getText().toString(), "10:45", true);
        mensagens.add(mensagem);
        binding.etChat.setText("");
        adapter.submitList(mensagens);
    }

    private void initTextEvent() {
        binding.etChat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    binding.btnMidia.setVisibility(View.GONE);
                    binding.btnCamera.setVisibility(View.GONE);
                    binding.btnAudio.setImageResource(R.drawable.ic_baseline_send_24);
                } else {
                    binding.btnMidia.setVisibility(View.VISIBLE);
                    binding.btnCamera.setVisibility(View.VISIBLE);
                    binding.btnAudio.setImageResource(R.drawable.ic_baseline_mic_24);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        sendMessage();
    }
}
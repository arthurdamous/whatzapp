package com.pronto.watizap.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.watizap.data.Mensagem;
import com.pronto.watizap.databinding.ItemChatMensagemUsuarioBinding;

public class ChatEnviadoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemChatMensagemUsuarioBinding binding;

    private Mensagem mensagem;

    public ChatEnviadoHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemChatMensagemUsuarioBinding.bind(itemView);
    }

    public void bind(Mensagem mensagem){
        this.mensagem = mensagem;
        binding.tvwMensagemEnviada.setText(mensagem.getTextoMensagem());
        binding.tvwHoraMensagemEnviada.setText(mensagem.getDataMensagem());
    }

    @Override
    public void onClick(View v) {

    }
}

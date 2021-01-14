package com.pronto.watizap.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.watizap.data.Mensagem;
import com.pronto.watizap.databinding.ItemChatMensagemBinding;

public class ChatRecebidoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

     private ItemChatMensagemBinding binding;
     private Mensagem mensagem;

     public ChatRecebidoHolder(@NonNull View itemView) {
         super(itemView);
         binding = ItemChatMensagemBinding.bind(itemView);
     }

     public void bind(Mensagem mensagem){
         this.mensagem = mensagem;
         binding.tvwMensagemRecebida.setText(mensagem.getTextoMensagem());
         binding.tvwHoraMensagem.setText(mensagem.getDataMensagem());
     }

     @Override
     public void onClick(View v) {

     }
 }

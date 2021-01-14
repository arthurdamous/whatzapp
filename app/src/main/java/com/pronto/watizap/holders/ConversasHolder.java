package com.pronto.watizap.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.watizap.data.Conversa;
import com.pronto.watizap.databinding.ItemMainConversaBinding;

public class ConversasHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemMainConversaBinding binding;
    private Conversa conversa;

    public ConversasHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemMainConversaBinding.bind(itemView);
    }

    public void bind(Conversa conversa) {
        this.conversa = conversa;
        binding.divider.setVisibility(getAdapterPosition() == 0 ? View.GONE:View.VISIBLE);
        binding.imgUser.setImageResource(conversa.getCaminhoImagem());
        binding.tvwNomeUsuario.setText(conversa.getNomeUsuario());
        binding.tvwUltimaMensagem.setText(conversa.getUltimaMensagem());
        binding.tvwDataUltimaMensagem.setText(conversa.getDataUltimaMensagem());
    }

    @Override
    public void onClick(View v) {

    }
}

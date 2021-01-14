package com.pronto.watizap.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.watizap.data.Mensagem;
import com.pronto.watizap.databinding.ItemChatMensagemBinding;
import com.pronto.watizap.databinding.ItemChatMensagemUsuarioBinding;
import com.pronto.watizap.holders.ChatEnviadoHolder;
import com.pronto.watizap.holders.ChatRecebidoHolder;


public class ChatAdapter extends ListAdapter<Mensagem, RecyclerView.ViewHolder> {

    public ChatAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatEnviadoHolder(ItemChatMensagemUsuarioBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false).getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ChatEnviadoHolder) holder).bind(getItem(position));
        ((ChatRecebidoHolder) holder).bind(getItem(position));
    }

    public static DiffUtil.ItemCallback<Mensagem> DIFF_CALLBACK = new DiffUtil.ItemCallback<Mensagem>() {
        @Override
        public boolean areItemsTheSame(@NonNull Mensagem oldItem, @NonNull Mensagem newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Mensagem oldItem, @NonNull Mensagem newItem) {
            return false;
        }
    };
}

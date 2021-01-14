package com.pronto.watizap.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.pronto.watizap.data.Conversa;
import com.pronto.watizap.holders.ConversasHolder;
import com.pronto.watizap.databinding.ItemMainConversaBinding;

public class ConversasAdapters extends ListAdapter<Conversa, ConversasHolder> {

    public ConversasAdapters() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ConversasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversasHolder(ItemMainConversaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ConversasHolder holder, int position) {
        holder.bind(getCurrentList().get(position));
    }

    public static DiffUtil.ItemCallback<Conversa> DIFF_CALLBACK = new DiffUtil.ItemCallback<Conversa>() {
        @Override
        public boolean areItemsTheSame(@NonNull Conversa oldItem, @NonNull Conversa newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Conversa oldItem, @NonNull Conversa newItem) {
            return false;
        }
    };
}

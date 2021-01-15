package com.pronto.watizap.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.pronto.watizap.data.Conversa;
import com.pronto.watizap.holders.ConversaHolder;
import com.pronto.watizap.databinding.ItemMainConversaBinding;
import com.pronto.watizap.interfaces.OnItemClickListener;

public class ConversasAdapters extends ListAdapter<Conversa, ConversaHolder> {

    private OnItemClickListener onItemClickListener;

    public ConversasAdapters() {
        super(DIFF_CALLBACK);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ConversaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversaHolder(ItemMainConversaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot(), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversaHolder holder, int position) {
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

package ru.example.numbers.num_work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.example.numbers.R;
import ru.example.numbers.click_listener.ClickListener;

public class NumAdapter extends RecyclerView.Adapter<NumViewHolder> {
    private ClickListener listener;
    private int maxNumber;


    public NumAdapter(int maxNumber, ClickListener listener) {
        this.listener = listener;
        this.maxNumber = maxNumber;
    }


    @NonNull
    @Override
    public NumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.number_button,
                viewGroup, false);
        return new NumViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumViewHolder numViewHolder, int i) {
        numViewHolder.bind(i + 1);
    }


    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return maxNumber;
    }
}

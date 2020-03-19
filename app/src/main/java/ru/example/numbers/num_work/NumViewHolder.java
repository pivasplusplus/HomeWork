package ru.example.numbers.num_work;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.example.numbers.R;
import ru.example.numbers.click_listener.ClickListener;

public class NumViewHolder extends RecyclerView.ViewHolder {
    private Button numberButton;
    private int number;

    NumViewHolder(@NonNull View itemView, final ClickListener onNumberClickListener) {
        super(itemView);
        numberButton = itemView.findViewById(R.id.numberButton);
        numberButton.setOnClickListener(v -> {
            onNumberClickListener.onClick(number, getColor(number));
        });
    }

    void bind(int num) {
        this.number = num;
        numberButton.setText(String.valueOf(number));
        numberButton.setTextColor(getColor(number));
    }

    @ColorInt
    private static int getColor(int num) {
        if (num % 2 == 0) {
            return Color.RED;
        }

        return Color.BLUE;
    }
}

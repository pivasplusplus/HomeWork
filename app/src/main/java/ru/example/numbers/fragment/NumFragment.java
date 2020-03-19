package ru.example.numbers.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.example.numbers.R;
import ru.example.numbers.click_listener.ClickListener;
import ru.example.numbers.num_work.NumAdapter;

public class NumFragment extends Fragment implements ClickListener {
    public static final String TAG = "NumFragment";
    public static final int DEFAULT_VALUE = 100;

    private NumAdapter mAdapter;
    private int maxNumber = DEFAULT_VALUE;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_of_numbers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            maxNumber = savedInstanceState.getInt("max_number", DEFAULT_VALUE);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        int horizontal = getResources().getInteger(R.integer.orientation);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), horizontal));


        mAdapter = new NumAdapter(maxNumber, this);
        recyclerView.setAdapter(mAdapter);

        Button addNumberButton = view.findViewById(R.id.addNumber);
        addNumberButton.setOnClickListener(v -> {
            maxNumber += 1;
            mAdapter.setMaxNumber(maxNumber);
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("max_number", maxNumber);
    }

    @Override
    public void onClick(int num, @ColorInt int color) {
        if (getActivity() == null || !(getActivity() instanceof ClickListener)) {
            return;
        }

        ((ClickListener) getActivity()).onClick(num, color);
    }
}

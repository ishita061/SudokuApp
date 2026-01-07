package com.example.sudoku;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridLayout sudokuGrid, numberPad;
    TextView selectedCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ❗ MUST
    }


    private void buildGrid() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                TextView cell = new TextView(this);
                cell.setGravity(Gravity.CENTER);
                cell.setTextSize(18);
                cell.setBackgroundResource(R.drawable.normal_cell);

                GridLayout.LayoutParams p = new GridLayout.LayoutParams();
                p.width = 0;
                p.height = 0;
                p.rowSpec = GridLayout.spec(r, 1f);
                p.columnSpec = GridLayout.spec(c, 1f);

                cell.setLayoutParams(p);

                cell.setOnClickListener(v -> select(cell));

                sudokuGrid.addView(cell);
            }
        }
    }

    private void buildPad() {
        for (int i = 1; i <= 9; i++) {
            Button b = new Button(this);
            b.setText(String.valueOf(i));

            b.setOnClickListener(v -> {
                if (selectedCell != null) {
                    selectedCell.setText(b.getText());
                }
            });

            numberPad.addView(b);
        }
    }

    private void select(TextView cell) {
        if (selectedCell != null) {
            selectedCell.setBackgroundResource(R.drawable.normal_cell);
        }
        selectedCell = cell;
        selectedCell.setBackgroundResource(R.drawable.selected_cell);
    }
}

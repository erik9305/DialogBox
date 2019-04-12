package com.example.dialogbox;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextFrom;
    private EditText editTextTo;
    private EditText editTextDate;
    private EditText editTextSeats;
    private DatePicker datePicker;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog1, null);

        builder.setView(view)
                .setTitle("Ny Resa")
                .setNegativeButton("Avbryt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Lägg till", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String from = editTextFrom.getText().toString();
                        String to = editTextTo.getText().toString();
                        String date = editTextDate.getText().toString();
                        String seats = editTextSeats.getText().toString();
                        String date2 = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        listener.applyTexts(from, to, date, seats, date2);
                    }
                });

        editTextFrom = view.findViewById(R.id.edit_From);
        editTextTo = view.findViewById(R.id.edit_To);
        editTextDate = view.findViewById(R.id.edit_Date);
        editTextSeats = view.findViewById(R.id.edit_Seats);
        datePicker = view.findViewById(R.id.datePicker1);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String from, String to, String date, String seats, String date2);
    }
}

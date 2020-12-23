package com.example.lb7;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class OneA extends Activity implements DialogInterface.OnClickListener {
    final int DIALOG_EXIT =1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_EXIT);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_EXIT){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            // заголовок
            adb.setTitle(R.string.exit);
            // сообщение
            adb.setMessage(R.string.save_data);
            // иконка
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, this);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, this);
            // кнопка нейтрального ответа
            adb.setNeutralButton(R.string.cancel, this);
            // создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case Dialog.BUTTON_POSITIVE:
                saveData();
                finish();
                break;
            case Dialog.BUTTON_NEGATIVE:
                finish();
                break;
            case Dialog.BUTTON_NEUTRAL:
                break;
        }
    }

    void saveData(){
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}

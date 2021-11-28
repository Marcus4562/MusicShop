package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    Spinner spinner; // Переменная класса спиннер
    ArrayList spinnerArraylist; //Массив (переменная класса арэй лист)
    ArrayAdapter spinnerAdapter; // Это структура(класс) позволяющая связать данные со спиннером
    HashMap goodsMap;
    String goodsName; //Наименование товара
    double price; //Цена

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner); //findViewById(связывваем переменную со спиннером) в хмл разметке
        spinner.setOnItemSelectedListener(this); //Прослушивает события выбора
        spinnerArraylist = new ArrayList(); //Присваиваем значение нового обьекта класса(арэй лист) Создали арэй лист

        spinnerArraylist.add("guitar");//add(Помещаем значения в обьект арэй лист)
        spinnerArraylist.add("drums");//add(Помещаем значения в обьект арэй лист)
        spinnerArraylist.add("keyboards");//add(Помещаем значения в обьект арэй лист)

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArraylist);//создаем обьект этого класса. В качестве параметров передаем контекст наш класс MainActivity(this), simple_spinner_item(Предопределеный элемент спиннера), передаем наш Арэй лист с элементами
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Тут мы устанавливаем выпадающий список для спинера
        spinner.setAdapter(spinnerAdapter); //Устанавливаем адаптер для спиннера

        goodsMap = new HashMap();
        goodsMap.put("gutar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard",1000.0);

    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityPlusMinusTitleTextView = findViewById(R.id.quantityPlusMinusTitleTextView);
        quantityPlusMinusTitleTextView.setText(" " + quantity);
    }

    public void decreaseQuantity(View view) {
        quantity = quantity - 1;
        if (quantity < 0) quantity = 0;
        TextView quantityPlusMinusTitleTextView = findViewById(R.id.quantityPlusMinusTitleTextView);
        quantityPlusMinusTitleTextView.setText(" " + quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
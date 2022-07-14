package com.example.responsimc2022;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * aplikasi ini bertujuan untuk memudahkan peminjaman ruangan di ITDA.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haswhippedcream);

        CheckBox chocolateChekBox= (CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean haschocolate=chocolateChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haschocolate);

        int price=calculateprice(haswhippedcream,haschocolate);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,haswhippedcream,haschocolate);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addruangankelas,boolean addruanganlab){//jumlah pesanan * harga
        int jam=24;

        if(addruangankelas){
            jam=jam+12-24;//berpa jam penggunaan
        }

        if (addruanganlab){
            jam=jam+12-24;
        }

        return quantity * jam;
    }
    private String createOrderSummary(int jam, String name, boolean addChocolate, boolean addWhippedCream) {//hasil pemesanan
        String pricemessage=" Nama = "+name;
        String addruangankelas = null;
        pricemessage+="\n Tambahkan RUANGAN KELAS=" +addruangankelas;
        String addruanganlab = null;
        pricemessage+="\n Tambahkan RUANGAN LAB=" +addruanganlab;
        pricemessage+="\n Jumlah Pemesanan =" +quantity;
        pricemessage+="\n Total = RUANGAN" +jam;
        pricemessage+="\n Terimakasih";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
package com.example.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private final Integer coffePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CharSequence cs = quantityTextView.getText();
        int currentVal = Integer.parseInt(cs.toString());
        display(currentVal);
        displayMessage("Total  "  + NumberFormat.getCurrencyInstance().format(currentVal * coffePrice) +
                "\nThanks you!!!");
    }

    public void increment(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CharSequence cs = quantityTextView.getText();
        int currentVal = Integer.parseInt(cs.toString());
        display(currentVal+1);
    }

    public void decrement(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CharSequence cs = quantityTextView.getText();
        int currentVal = Integer.parseInt(cs.toString());
        if (currentVal > 0) {
            display(currentVal - 1);
        }
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayAll(int number) {
        display(number);
        displayPrice(number * coffePrice);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

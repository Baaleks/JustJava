/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this,"You can't have more than 100 Coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        if (quantity ==1){
            Toast.makeText(this,"You can't have more than 100 Coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }



    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedcream =  (whippedCreamCheckbox.isChecked());

        CheckBox chocolateTextbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
                boolean hasChocolate = (chocolateTextbox.isChecked());

        EditText editTextName = (EditText) findViewById(R.id.name);
                String nameCustomer = editTextName.getText().toString();

        int price = calculatePrice(hasChocolate, haswhippedcream);
        String priceMessage = createOrderSummary(price, haswhippedcream, hasChocolate, nameCustomer);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mail to:");
        intent.putExtra(intent.EXTRA_SUBJECT,);
        if (intent.resolveActivity(getPackageManager()) !=null) {

        }



        displayMessage(priceMessage);



    }



     public int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {
        int basePrice = 5;

        if (hasChocolate)  {
            basePrice = basePrice + 2;
         }
        if (hasWhippedCream){
             basePrice = basePrice + 1;
         }

        return quantity * basePrice;



    }

    private String createOrderSummary(int price, boolean addwhippedcream, boolean hasChocolate, String nameCustomer) {
        String priceMessage = "name: Kaptain Kunal";
        priceMessage = "name: " + nameCustomer;
        priceMessage += "\nadd whipped cream? " + addwhippedcream;
        priceMessage += "\nadd chocolate? " + hasChocolate;
        priceMessage += "\nquantity : " + quantity;
        priceMessage +=  "\nthat will be " + price;
        priceMessage +=  "\nthanks";
        return priceMessage;
    }




    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }
}

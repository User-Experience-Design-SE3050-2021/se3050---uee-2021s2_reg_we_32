package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.androiddev.peopleswave.model.CreditCardPayment;

import java.util.Date;

public class CreditcardService extends AppCompatActivity {

    Spinner fromAccSpinner, toAccSpinner;
    EditText amount_et;
    TextView date;
    Button nextBtn;
    CreditCardPayment creditCardPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcard_service);

        fromAccSpinner = (Spinner) findViewById(R.id.css_fromacc_dropdown);
        toAccSpinner = (Spinner) findViewById(R.id.ccs_toacc_dropdown);
        amount_et = (EditText) findViewById(R.id.ccs_amount_et);
        date = (TextView) findViewById(R.id.ccs_date_tv);
        nextBtn = (Button) findViewById(R.id.ccs_next_btn);

        //set items to spinner
        ArrayAdapter<CharSequence> fromAccadapter = ArrayAdapter.createFromResource(this, R.array.accounts, android.R.layout.simple_spinner_item);
        fromAccadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromAccSpinner.setAdapter(fromAccadapter);

        //set items to spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.credit_card_to, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toAccSpinner.setAdapter(adapter);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fromAcc = fromAccSpinner.getSelectedItem().toString();
                String toAcc = toAccSpinner.getSelectedItem().toString();
                String amount = amount_et.getText().toString();
                //date.setText();

                creditCardPayment = new CreditCardPayment();

                creditCardPayment.setFromAcc(fromAcc);
                creditCardPayment.setToAcc(toAcc);
                creditCardPayment.setAmount(amount);
                creditCardPayment.setPaymentDate(date.toString());

                Intent creditcard_confirm = new Intent(CreditcardService.this, CreditCardServiceConfirm.class);
                creditcard_confirm.putExtra("creditcardpayment", creditCardPayment);
                startActivity(creditcard_confirm);
            }
        });

    }
}
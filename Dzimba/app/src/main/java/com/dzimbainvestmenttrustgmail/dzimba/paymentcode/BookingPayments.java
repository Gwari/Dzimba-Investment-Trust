package com.dzimbainvestmenttrustgmail.dzimba.paymentcode;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dzimbainvestmenttrustgmail.dzimba.R;

public class BookingPayments extends Activity {
    /**
     * variable of customer inputs
     */
    private EditText mNameEditText, mIdEditText, mCellEditText, mEcocashID, mHouseEditText, mDurationEdtitText;
    private String mStringCustomerName, mStringId, mStringCell, mStringEcocash, mStringHouse, mStringDuration;
    private Spinner mHouseSpinner, mDurationSpinner;
    private Button mMakePayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_payments);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            Toast.makeText(this, "There is not internet connection", Toast.LENGTH_LONG).show();
        }

        mNameEditText = (EditText) findViewById(R.id.customer_name);
        mCellEditText = (EditText) findViewById(R.id.cellphoneNumber);
        mEcocashID = (EditText) findViewById(R.id.ecocashID);
        mIdEditText = (EditText) findViewById(R.id.customer_id);
        mMakePayment = (Button) findViewById(R.id.ecocashPaymentButton);
        mHouseSpinner = (Spinner) findViewById(R.id.houseSpinner);
        mDurationSpinner = (Spinner) findViewById(R.id.spinnerDuration);


        mMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(Uri.parse("tel:" + "*151*1*1*0775751175") +Uri.encode("#")));

                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                startActivity(intent);
            }
        });


    }



    //public void ecocashPayment(View view){
        //Intent intent = new Intent(Intent.ACTION_CALL);
        //intent.setData(Uri.parse("tel:%2A 171 %2A1 %23"));

        //if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                //Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //return;
        //}

        //startActivity(intent);
    //}



    public void makePayment(View view) {
        // Click action collecting customer info
        mStringCustomerName = mNameEditText.getText().toString();
        mStringId = mIdEditText.getText().toString();
        mStringCell = mCellEditText.getText().toString();
        mStringEcocash = mEcocashID.getText().toString();
        mStringHouse = mHouseSpinner.getSelectedItem().toString();
        mStringDuration = mDurationSpinner.getSelectedItem().toString();
        String method = "booking";
        //pass this info into PaymentPHPLink create an object
        PaymentPHPLink paymentPHPLink = new PaymentPHPLink(this);
        paymentPHPLink.execute(method, mStringCustomerName, mStringCell, mStringId, mStringEcocash, mStringHouse, mStringDuration);
        finish();
    }
}

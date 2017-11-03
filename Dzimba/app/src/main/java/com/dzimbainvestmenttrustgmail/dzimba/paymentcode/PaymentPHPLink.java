package com.dzimbainvestmenttrustgmail.dzimba.paymentcode;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by gwari on 10/26/2017.
 */

/**
 * This class will be used to link with php files and store customer data
 */
public class PaymentPHPLink extends AsyncTask<String, Void, String> {
    Context mContext;
    /**
     * pass customer info into the paymentPHPLink using a constructor
     */
    PaymentPHPLink(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        //declare the urls to connect
        String book_url = "http://10.0.2.2/dzimbainvestmenttrustcustomerlist/bookings.php";
        /**
         * From this method we have to pass the customer information into mySQL database in the server
         * First we need to identify the operation being booking
         */
        String method = params[0];
        if(method.equals("bookings")){
            String name = params[1];
            String identification = params[2];
            String cellnumber = params[3];
            String payment = params[4];
            String house = params[5];
            String duration = params[6];

            try {
                URL bookHomeUrl = new URL(book_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) bookHomeUrl.openConnection();
                //set parameter for the connection
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //Create object of OutPutStream, need to get the OutputStream from the httpURLConnection
                OutputStream OS = httpURLConnection.getOutputStream();
                //to write the information need a BufferWriter
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                //encode the data before sending it
                String data = URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("identification", "UTF-8")+"="+URLEncoder.encode(identification, "UTF-8")+"&"+
                        URLEncoder.encode("cellnumber", "UTF-8")+"="+URLEncoder.encode(cellnumber, "UTF-8")+"&"+
                        URLEncoder.encode("payment", "UTF-8")+"="+URLEncoder.encode(payment, "UTF-8")+"&"+
                        URLEncoder.encode("house", "UTF-8")+"="+URLEncoder.encode(house, "UTF-8")+"&"+
                        URLEncoder.encode("duration", "UTF-8")+"="+URLEncoder.encode(duration, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                httpURLConnection.disconnect();

                return "Booking Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(mContext, result,Toast.LENGTH_LONG).show();
    }
}

package thatteidlipudina.com.vheal;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
//import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backgroundworker extends AsyncTask<String,Void,String> {

    Context context;

    Backgroundworker(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {

        String login_url = "https://vheal.000webhostapp.com/login.php";
        String register_url = "https://vheal.000webhostapp.com/register.php";
        String disease_URL = "https://vheal.000webhostapp.com/disease.php";
        String type = voids[0];
        if (type.equals("login")) {
            try {
                String username = voids[1];
                String pass = voids[2];

                URL url = new URL(login_url);
                HttpURLConnection htc = (HttpURLConnection) url.openConnection();
                if (htc == null) {
                    Toast.makeText(context, "connection failed", Toast.LENGTH_SHORT).show();
                }
                htc.setRequestMethod("POST");
                htc.setDoOutput(true);
                htc.setDoInput(true);
                OutputStream os = htc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bw.write(post_data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = htc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    result += line;
                }
                br.close();
                is.close();
                htc.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        //else if()
        else if (type.equals("register")) {
            try {
                String username = voids[1];
                String pass = voids[2];
                String name = voids[3];
                String phone = voids[4];

                URL url = new URL(register_url);
                HttpURLConnection htc = (HttpURLConnection) url.openConnection();
                if (htc == null) {
                    Toast.makeText(context, "connection failed", Toast.LENGTH_SHORT).show();
                }
                htc.setRequestMethod("POST");
                htc.setDoOutput(true);
                htc.setDoInput(true);
                OutputStream os = htc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&"
                        + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                        + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
                bw.write(post_data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = htc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    result += line;
                }
                br.close();
                is.close();
                htc.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (type.equals("disease")) {
            try {
                String disease = voids[1];
                String pincode = voids[2];
                String email = voids[3];
                URL url = new URL(disease_URL);
                HttpURLConnection htc = (HttpURLConnection) url.openConnection();
                if (htc == null) {
                    Toast.makeText(context, "connection failed", Toast.LENGTH_SHORT).show();
                }
                htc.setRequestMethod("POST");
                htc.setDoOutput(true);
                htc.setDoInput(true);
                OutputStream os = htc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String post_data = URLEncoder.encode("disease", "UTF-8") + "=" + URLEncoder.encode(disease, "UTF-8") + "&"
                        + URLEncoder.encode("pincode", "UTF-8") + "=" + URLEncoder.encode(pincode, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                bw.write(post_data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = htc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    result += line;
                }
                br.close();
                is.close();
                htc.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        if (s.equals("Login Successful")) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
        else if(s.equals("Registration Successful")){
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }
        else if(s.equals("Update Successful")){
            Intent intent = new Intent(context, Credit.class);
            context.startActivity(intent);
        }

    }
}


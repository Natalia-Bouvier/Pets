package com.bdl.mypets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    Session session = null;
    ProgressDialog progressDialog = null;
    Context context = null;
    EditText editText, editText3, editText4;
    String edit,edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.tvNombre);
        editText3 = (EditText) findViewById(R.id.tvEmail);
        editText4 = (EditText) findViewById(R.id.tvDescripcion);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 edit = editText.getText().toString();
                 edit1 =editText3.getText().toString();
                 edit2 = editText4.getText().toString();


                Properties properties =System.getProperties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                session = Session.getDefaultInstance(properties, new Authenticator()  {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("mis.mascotas.en.pandemia@gmail.com","Hola12345678");
                    }
                });

                progressDialog = ProgressDialog.show(context,"","Enviando Correo...",true);
                RetreiveFeedTask retreiveFeedTask  =new RetreiveFeedTask();
                retreiveFeedTask.execute();

            }

            class RetreiveFeedTask extends AsyncTask<String, Void, String>{

                @Override
                protected String doInBackground(String... params) {

                   try {
                        Message message =new MimeMessage(session);
                        message.setFrom(new InternetAddress("mis.mascotas.en.pandemia@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mis.mascotas.en.pandemia@gmail.com"));
                        message.setSubject("Contactanos!");
                        message.setText("Nombre : " + edit + "\nCorreo : "+ edit1   + "\nMensaje : "  + edit2);
                        Transport.send(message);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String s) {
                    progressDialog.dismiss();
                    editText3.setText("");
                    editText.setText("");
                    editText4.setText("");
                    Toast.makeText(getApplicationContext(),"Enviado!", Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}
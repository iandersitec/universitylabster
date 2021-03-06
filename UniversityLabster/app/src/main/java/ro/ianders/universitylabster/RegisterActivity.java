package ro.ianders.universitylabster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import ro.ianders.universitylabster.dataformat.User;

public class RegisterActivity extends AppCompatActivity {


    private Button btnRegister;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvSignin;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //iau instanta de pe firebase
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("useri");

        progressDialog = new ProgressDialog(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvSignin = (TextView) findViewById(R.id.tvSignin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void registerUser(){
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Te rog introdu email-ul", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Te rog introdu parola", Toast.LENGTH_SHORT).show();
            return;
        }

        // daca a introdus emailul si parola atunci il inregistram
        progressDialog.setMessage("Inregistrare ....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Inregistrare realizata!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                            //salvare account in firebase
                            String id = databaseReference.push().getKey();
                            User user = new User(id, email, password);
                            databaseReference.child(id).setValue(user);
                            Toast.makeText(RegisterActivity.this, "Account saved!", Toast.LENGTH_SHORT).show();

                            finish();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Eroare la inregistrare!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


    @Override
    protected void onResume() {
        super.onResume();
        progressDialog.dismiss();
    }
}

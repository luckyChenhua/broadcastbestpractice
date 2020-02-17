package activitytest.example.com.broadcastbestpractice;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  Main2Activity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private EditText sexEdit;
    private EditText ageEdit;
    private EditText mailEdit;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        accountEdit=(EditText)findViewById(R.id.r_account);
        passwordEdit=(EditText)findViewById(R.id.r_password);
        sexEdit=(EditText)findViewById(R.id.r_sex);
        ageEdit=(EditText)findViewById(R.id.r_age);
        mailEdit=(EditText)findViewById(R.id.r_mail);
        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button button=(Button)findViewById(R.id.r_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                String sex=sexEdit.getText().toString();
                String age=ageEdit.getText().toString();
                String mail=mailEdit.getText().toString();
                dbHelper.getWritableDatabase();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("account",account);
                values.put("password",password);
                values.put("sex",sex);
                values.put("age",age);
                values.put("mail",mail);
                db.insert("register",null,values);
            }
        });

    }
}

package edu.upc.eetac.dsa.repositorisinfo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import edu.upc.eetac.dsa.repositorisinfo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClicRepoUser(View view) {
        EditText etUsuari = (EditText) findViewById(R.id.et_usuari);
        Intent in1 = new Intent(this, RepoListActivity.class);
        in1.putExtra("nomUser", etUsuari.getText().toString());
        startActivity(in1);
    }

    public  void onClicInfoUser(View view) {
        EditText etSearchString = (EditText) findViewById(R.id.et_topicsdecerca);
        Intent in1 = new Intent(this, CercaListActivity.class);
        in1.putExtra("searchString", etSearchString.getText().toString());
        startActivity(in1);
    }
}

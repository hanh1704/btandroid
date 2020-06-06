package com.example.checkbox;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CheckBox cbPhp, cbJava, cbCsharp, cbVb, cbPython;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }

private void setControl()
{
    cbPhp=(CheckBox)findViewById(R.id.php);
    cbJava=(CheckBox)findViewById(R.id.java);
    cbCsharp=(CheckBox)findViewById(R.id.Csharp);
    cbVb=(CheckBox)findViewById(R.id.VB);
    cbPython=(CheckBox)findViewById(R.id.python);
}
private void setEvent()
{
cbPhp.setOnClickListener(this);
}
@Override
public void onClick (View v)
{
    switch (v.getId())
    {
        case R.id.java:
        if(cbJava.isChecked())
        {
            Toast.makeText(getApplicationContext(),"java",Toast.LENGTH_LONG).show();

        }
        break;
        case R.id.php:
            if(cbPhp.isChecked())
            {
                Toast.makeText(getApplicationContext(),"php",Toast.LENGTH_LONG).show();

            }
            break;
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

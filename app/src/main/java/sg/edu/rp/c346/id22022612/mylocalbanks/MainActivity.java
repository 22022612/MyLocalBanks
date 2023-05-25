package sg.edu.rp.c346.id22022612.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView UOB;
TextView ocbc;
TextView DBS;
String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ocbc = findViewById(R.id.OCBC);
        registerForContextMenu(ocbc);

        DBS = findViewById(R.id.DBS);
        registerForContextMenu(DBS);

        UOB = findViewById(R.id.UOB);
        registerForContextMenu(UOB);

        String visitWebsite = getString(R.string.website);
        String contactBank = getString(R.string.contact_the_bank);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        //item id is 0 (Second parameter)
        menu.add(0, 0, 0, "Website");

        //item id is 1 (Second parameter)
        menu.add(0, 1, 1, "Contact Bank");

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == ocbc) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            ocbc.setText("OCBC");
            UOB.setText("UOB");

            return true;


        } else if (id == R.id.ChineseSelection) {
            DBS.setText("星展银行");
            ocbc.setText("华侨银行");
            UOB.setText("大华银行");

            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800111111));
                startActivity(intentcall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800363333));
                startActivity(intentcall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800222212));
                startActivity(intentcall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}

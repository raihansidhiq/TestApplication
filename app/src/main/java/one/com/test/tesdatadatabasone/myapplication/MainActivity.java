package one.com.test.tesdatadatabasone.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mcarTextview;
    Button mButtonVW;
    Button mButtonskoda;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mcarRef = mRootRef.child("car");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mcarTextview = (TextView)findViewById(R.id.textViewcar);
        mButtonVW = (Button)findViewById(R.id.buttonVW);
        mButtonskoda = (Button)findViewById(R.id.buttonskoda);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mcarRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text =dataSnapshot.getValue(String.class);
                mcarTextview.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}


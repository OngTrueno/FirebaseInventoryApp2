package sg.edu.rp.webservices.firebaseinventoryapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InventoryDetails extends AppCompatActivity {

    private static final String TAG = "InventoryDetailsActivity";

    private EditText etName, etCost;
    private Button btnUpdate, btnDelete;

    private Inventory student;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference inventoryListRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_details);

        etName = (EditText)findViewById(R.id.etName);
        etCost = (EditText)findViewById(R.id.etCost);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        firebaseDatabase = FirebaseDatabase.getInstance();
        inventoryListRef = firebaseDatabase.getReference("/inventoryList");

        Intent intent = getIntent();
        student = (Inventory) intent.getSerializableExtra("Inventory");

        //Display Student details as retrieved from the intent
        etName.setText(student.getName());
        etCost.setText(String.valueOf(student.getCost()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = student.getId();
                String name = etName.getText().toString();
                int age = Integer.parseInt(etCost.getText().toString());

                Inventory student = new Inventory(name, age);
                inventoryListRef.child(id).setValue(student);

                setResult(RESULT_OK);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = student.getId();
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("/inventoryList");
                mDatabase.child(id).removeValue();

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}

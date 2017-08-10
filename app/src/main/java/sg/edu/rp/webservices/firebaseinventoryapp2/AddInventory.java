package sg.edu.rp.webservices.firebaseinventoryapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddInventory extends AppCompatActivity {

    private static final String TAG = "AddInventoryActivity";

    private EditText etName, etCost;
    private Button btnAdd;

    // TODO: Task 1 - Declare Firebase variables
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference inventoryListRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);

        etName = (EditText)findViewById(R.id.etName);
        etCost = (EditText)findViewById(R.id.etCost);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        // TODO: Task 2: Get Firebase database instance and reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        inventoryListRef = firebaseDatabase.getReference("/inventoryList");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int cost = Integer.parseInt(etCost.getText().toString());
                Inventory student = new Inventory(name, cost);

                inventoryListRef.push().setValue(student);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

package core.mt.vendingmachine;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class NewProductActivity extends AppCompatActivity {
    private static final String BASE_URL = "TODO";
    private JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_product);

        Toolbar toolbar = findViewById(R.id.product_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add New Product");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        createProduct();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    private void createProduct() {

        Button button = findViewById(R.id.saveBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameEdit = findViewById(R.id.nameEdit);
                final EditText priceEdit = findViewById(R.id.priceEdit);
                final EditText itemsEdit = findViewById(R.id.countEdit);
                final EditText weightEdit = findViewById(R.id.weightEdit);

                final String name = nameEdit.getText().toString();
                final float price = Float.valueOf(priceEdit.getText().toString());
                final int items = Integer.valueOf(itemsEdit.getText().toString());
                final float weight = Float.valueOf(weightEdit.getText().toString());

                try {
                    json = new JSONObject();

                    json.put("name", name);
                    json.put("price", price);
                    json.put("items", items);
                    json.put("weight", weight);
                    json.put("pictureURL", ""); //TODO

                    save();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    void save() throws IOException {
        ProgressDialog progressDialog = ProgressDialog.show(NewProductActivity.this,
                "Please wait...", "Saving New Product ...", true);

        String location = BASE_URL + "/api/products";
        URL url = new URL(location);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            os.flush();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line.trim());
            }

            Log.i("Product Save = ", response.toString());

            progressDialog.dismiss();

            int code = connection.getResponseCode();
            if (code == 200) {
                Snackbar.make(findViewById(R.id.product_parent), "New Product Saved Successfully", Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }
}

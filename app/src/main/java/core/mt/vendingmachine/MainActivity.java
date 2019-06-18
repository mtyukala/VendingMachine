package core.mt.vendingmachine;

import android.app.ProgressDialog;
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
=======
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Selection;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.vending.machine.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog = null;
    private ArrayList<Product> productsList = null;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(MainActivity.this, NewProductActivity.class);
                startActivity(intent);
=======
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
            }
        });

        RecyclerView recyclerView = findViewById(R.id.productList);
        TextView emptyView = findViewById(R.id.empty_view);

        productsList = new ArrayList<>();
        productAdapter = new ProductAdapter();
<<<<<<< HEAD
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);

        if (productsList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(productAdapter);
            emptyView.setVisibility(View.GONE);
        }
=======
        LinearLayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(productAdapter);
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036


        Runnable viewProducts = new Runnable() {
            @Override
            public void run() {
                getProducts();
            }
        };
<<<<<<< HEAD

        Thread thread = new Thread(null, viewProducts, "MagentoBackground");
        thread.start();
        progressDialog = ProgressDialog.show(MainActivity.this,
                "Please wait...", "Retrieving data ...", true);
=======
        Thread thread = new Thread(null, viewProducts, "MagentoBackground");
        thread.start();

        progressDialog = ProgressDialog.show(MainActivity.this,
                "Please wait...", "Retrieving data ...", true);

        if (productsList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(productAdapter);
            recyclerView.setHasFixedSize(true);

//            SelectionTraker tracker = new SelectionTracker()

            emptyView.setVisibility(View.GONE);
        }

>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
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


    public void getProducts() {
        try {
            productsList = new ArrayList<>();
<<<<<<< HEAD
            //Order o1 = new Order();
            Product product = new Product();
            product.setName("SF services");
            product.setPrice(9.99f);
            Product o2 = new Product();
            o2.setName("SF Advertisement");
            o2.setPrice(8.99f);
            productsList.add(product);
            productsList.add(o2);
=======

            Product product = new Product();
            product.setName("Coke");
            product.setPrice(9.99f);
            productsList.add(product);

            product = new Product();
            product.setName("Simba Chips");
            product.setPrice(8.99f);

            productsList.add(product);

>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
            Thread.sleep(5000);
            Log.i("Product Size = ", "" + productsList.size());
        } catch (Exception e) {
            Log.e("Background Process", e.getMessage());
        }
<<<<<<< HEAD
        runOnUiThread(returnRes);
    }

    private Runnable returnRes = new Runnable() {

        @Override
        public void run() {
=======
        runOnUiThread(prepareProducts);
    }

    private Runnable prepareProducts = new Runnable() {

        @Override
        public void run() {
            Log.i("Product Size in Pp = ", "" + productsList.size());
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
            if (productsList != null && productsList.size() > 0) {
                productAdapter.notifyDataSetChanged();
                productAdapter.setData(productsList);
            }
            progressDialog.dismiss();
            productAdapter.notifyDataSetChanged();
        }
    };
}

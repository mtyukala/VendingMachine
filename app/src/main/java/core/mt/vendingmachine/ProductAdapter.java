package core.mt.vendingmachine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vending.machine.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList = Collections.emptyList();

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int VieType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent
                , false);

        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.bind(productList.get(i));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setData(List<Product> newProducts) {
        this.productList = newProducts;
        notifyDataSetChanged();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAvatar;
        private TextView productName;
        private TextView productPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            productName = itemView.findViewById(R.id.tvFirstName);
            productPrice = itemView.findViewById(R.id.tvCity);
        }

        public void bind(Product product) {
            productName.setText(product.getName());
            productPrice.setText(Float.valueOf(product.getPrice()).toString());
            //Picasso.get().load(product.getPicture().getMedium()).fit().into(ivAvatar);
        }
    }
}

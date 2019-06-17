package core.mt.vendingmachine;


import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.vending.machine.model.Product;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList = Collections.emptyList();
    private ItemClickListener clickListener;

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

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivAvatar;
        private TextView productName;
        private TextView productPrice;
        private TextView productWeight;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            productName = itemView.findViewById(R.id.nameText);
            productPrice = itemView.findViewById(R.id.priceText);
            productWeight = itemView.findViewById(R.id.weightText);
            itemView.setOnClickListener(this);
        }

        public void bind(Product product) {
            productName.setText(product.getName());
            productPrice.setText(Float.valueOf(product.getPrice()).toString());
            productWeight.setText(Float.valueOf(product.getWeight()).toString());
            if (product.getPictureURL() != null)
                ivAvatar.setImageURI(Uri.parse(product.getPictureURL()));
        }


        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onItemClickListener(view, getAdapterPosition());
        }
    }


    void setClickListener(ItemClickListener listener) {
        this.clickListener = listener;
    }


    public interface ItemClickListener {
        void onItemClickListener(View view, int position)
                ;
    }

}

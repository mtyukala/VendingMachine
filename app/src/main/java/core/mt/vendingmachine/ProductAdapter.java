package core.mt.vendingmachine;

<<<<<<< HEAD
import android.content.Context;
=======

import android.net.Uri;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======
import android.widget.AdapterView;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
import android.widget.ImageView;
import android.widget.TextView;

import com.vending.machine.model.Product;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.net.URI;
import java.net.URISyntaxException;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
import java.util.Collections;
import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList = Collections.emptyList();
<<<<<<< HEAD
=======
    private ItemClickListener clickListener;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036

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

<<<<<<< HEAD
    class ProductViewHolder extends RecyclerView.ViewHolder {
=======
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036

        private ImageView ivAvatar;
        private TextView productName;
        private TextView productPrice;
<<<<<<< HEAD
=======
        private TextView productWeight;
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036

        public ProductViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
<<<<<<< HEAD
            productName = itemView.findViewById(R.id.tvFirstName);
            productPrice = itemView.findViewById(R.id.tvCity);
=======
            productName = itemView.findViewById(R.id.nameText);
            productPrice = itemView.findViewById(R.id.priceText);
            productWeight = itemView.findViewById(R.id.weightText);
            itemView.setOnClickListener(this);
>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
        }

        public void bind(Product product) {
            productName.setText(product.getName());
            productPrice.setText(Float.valueOf(product.getPrice()).toString());
<<<<<<< HEAD
            //Picasso.get().load(product.getPicture().getMedium()).fit().into(ivAvatar);
        }
    }
=======
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

>>>>>>> 58aee1e6d3a43d231862b5a2e9ce6635b78cf036
}

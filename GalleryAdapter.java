package ua.kpi.comsys.iv8228;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>  {
    private static final ArrayList<Uri[]> pictures = new ArrayList<>();
    private static int counter = -1;
    private final int IMAGE_SIZE;

    public GalleryAdapter(int w){
        setHasStableIds(true);
        IMAGE_SIZE = w / 5;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView[] imageViews;
        public ViewHolder(View itemView) {
            super(itemView);
            imageViews = new ImageView[6];
            imageViews[0] = itemView.findViewById(R.id.gal_picture0);
            imageViews[1] = itemView.findViewById(R.id.gal_picture1);
            imageViews[2] = itemView.findViewById(R.id.gal_picture2);
            imageViews[3] = itemView.findViewById(R.id.gal_picture3);
            imageViews[4] = itemView.findViewById(R.id.gal_picture4);
            imageViews[5] = itemView.findViewById(R.id.gal_picture5);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        for (int i = 0; i < pictures.get(position).length &&
                pictures.get(position)[i] != null; i++) {
            ImageView currIV = holder.imageViews[i];

            currIV.setCropToPadding(true);
            currIV.setImageURI(pictures.get(position)[i]);
            currIV.setAdjustViewBounds(true);
            currIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if(i == 0){
                currIV.getLayoutParams().width = IMAGE_SIZE * 3;
                currIV.getLayoutParams().height = IMAGE_SIZE * 3;

            }
            else if(i == 1) {
                currIV.getLayoutParams().width = IMAGE_SIZE * 2 ;
                currIV.getLayoutParams().height = IMAGE_SIZE * 2;
            }
            else if(i == 2){
                currIV.getLayoutParams().width = IMAGE_SIZE * 2;
                currIV.getLayoutParams().height = IMAGE_SIZE * 2;
            }else{
                currIV.getLayoutParams().width = IMAGE_SIZE;
                currIV.getLayoutParams().height = IMAGE_SIZE;
            }
        }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public void addElement(Uri uri) {
        counter ++;
        if(counter % 6 == 0)
            pictures.add(new Uri[6]);
        pictures.get(counter / 6)[counter % 6] = uri;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View prevView = inflater.inflate(R.layout.item_picture, parent, false);
        return new ViewHolder(prevView);
    }
}
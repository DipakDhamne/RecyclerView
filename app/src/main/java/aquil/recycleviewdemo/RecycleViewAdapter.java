package aquil.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by aquil on 10/6/2017.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHoder>{

    private Context context;
    private List<String> mData;
    private LayoutInflater inflater;

    public RecycleViewAdapter(Context context,List<String> mData){
        this.inflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_view_layout,parent,false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
            holder.tvImgName.setText(mData.get(position));
            holder.ivImg.setImageResource(context.getResources().getIdentifier(mData.get(position).toString().toLowerCase(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHoder extends RecyclerView.ViewHolder{

        public ImageView ivImg;
        public TextView tvImgName;
        public Button btnClick;

        public ViewHoder(View itemView) {
            super(itemView);

            ivImg = (ImageView)itemView.findViewById(R.id.ivImg);
            tvImgName = (TextView)itemView.findViewById(R.id.tvImgName);
            btnClick = (Button)itemView.findViewById(R.id.bntClick);

            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Thanks to Click on Me",Toast.LENGTH_SHORT).show();
                }
            });

            ivImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"My Name is : "+tvImgName.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}

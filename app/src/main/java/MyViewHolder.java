import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwitharraylist.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView counteryName;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        counteryName = (TextView) itemView.findViewById(R.id.counteryName);
    }
}

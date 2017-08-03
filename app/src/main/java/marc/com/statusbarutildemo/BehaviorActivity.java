package marc.com.statusbarutildemo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BehaviorActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_behavior);

		Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
		setSupportActionBar(toolbar);

		/*CollapsingToolbarLayout collapsingToolbar =
				(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		collapsingToolbar.setTitle("哆啦A梦");*/

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new RecyclerView.Adapter() {
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View v = LayoutInflater.from(BehaviorActivity.this).inflate(R.layout.item,parent,false);
				ViewHolder holder = new ViewHolder(v);
				return holder;
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

			}

			@Override
			public int getItemCount() {
				return 100;
			}
		});
	}
	class ViewHolder extends RecyclerView.ViewHolder{
		public ViewHolder(View itemView) {
			super(itemView);
		}
	}
}

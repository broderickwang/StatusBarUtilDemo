package marc.com.statusbarutildemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 王成达
 * Date: 2017/8/8
 * Time: 09:42
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class TranslationBehavior extends FloatingActionButton.Behavior {

	private boolean mIsOut = false;
	private View mBottomView;

	public TranslationBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onLayoutChild(CoordinatorLayout parent, FloatingActionButton child, int layoutDirection) {
		mBottomView = parent.findViewById(R.id.bottom_tab_layout);
		return super.onLayoutChild(parent, child, layoutDirection);
	}

	/**
	 * 关注垂直滚动，向上出来，向下消失隐藏
	 * @param coordinatorLayout
	 * @param child
	 * @param target
	 * @param dxConsumed
	 * @param dyConsumed
	 * @param dxUnconsumed
	 * @param dyUnconsumed
	 */
	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
		Log.d("TAG", "onNestedScroll: dyConsumed->"+dyConsumed);
		if(dyConsumed > 0){
			//向下
			if(!mIsOut ) {
				int translationY = ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).bottomMargin + child.getMeasuredHeight();
				child.animate().translationY(translationY).setDuration(500).start();
				mBottomView.animate().translationY(mBottomView.getMeasuredHeight()).setDuration(500).start();
				mIsOut = true;
			}
		}else{
//			向上
			if(mIsOut) {
				child.animate().translationY(0).setDuration(500).start();
				mBottomView.animate().translationY(0).setDuration(500).start();
				mIsOut = false;
			}
		}
	}


	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
		return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
	}
}

package marc.com.statusbarutil;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by 王成达
 * Date: 2017/8/2
 * Time: 12:56
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class StatusBarUtil {

	/**
	 * 设置activity的状态栏颜色
	 * @param activity
	 * @param color
	 */
	public static void setStatusBarColor(Activity activity, int color){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
			//hightter than 5.0
			activity.getWindow().setStatusBarColor(color);
		}else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT
				&&Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
			//4.4 - 5.0
			//设置布局全屏
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}

	public static void setStatusBarTranslate(Activity activity){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
			//hightter than 5.0
			View decorView = activity.getWindow().getDecorView();
			decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
		}else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT
				&&Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
			//4.4 - 5.0
			//设置布局全屏
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
		ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
		viewGroup.getChildAt(0).setFitsSystemWindows(true);
	}
}

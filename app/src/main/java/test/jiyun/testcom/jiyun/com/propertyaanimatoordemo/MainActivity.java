package test.jiyun.testcom.jiyun.com.propertyaanimatoordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static test.jiyun.testcom.jiyun.com.propertyaanimatoordemo.R.id.iv;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBut1;
    private Button mBut2;
    private Button mBut3;
    private Button mBut4;
    private Button mBut5;
    private Button mBut6;
    private Button mBut7;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        mIv = (ImageView) findViewById(iv);
        mBut1 = (Button) findViewById(R.id.but1);
        mBut2 = (Button) findViewById(R.id.but2);
        mBut3 = (Button) findViewById(R.id.but3);
        mBut4 = (Button) findViewById(R.id.but4);
        mBut5 = (Button) findViewById(R.id.but5);
        mBut6 = (Button) findViewById(R.id.but6);
        mBut7 = (Button) findViewById(R.id.but7);

        mBut1.setOnClickListener(this);
        mBut2.setOnClickListener(this);
        mBut3.setOnClickListener(this);
        mBut4.setOnClickListener(this);
        mBut5.setOnClickListener(this);
        mBut6.setOnClickListener(this);
        mBut7.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                //平移
                //x坐标
                float translationX = mIv.getTranslationX();
                ObjectAnimator anim = ObjectAnimator.ofFloat(mIv, "translationX", translationX, 500f, translationX);
                anim.setDuration(3000);
                anim.start();

                break;
            case R.id.but2:
                //旋转
                // 第二个参数"rotation"表明要执行旋转
                // 0f -> 360f，从旋转360度，也可以是负值，负值即为逆时针旋转，正值是顺时针旋转。
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(mIv, "rotation", 0f, 360f);
                anim1.setDuration(3000);
                anim1.start();
                break;
            case R.id.but3:
                //缩放
                // 沿垂直方向先从原大小（1f）放大到5倍大小（5f），然后再变回原大小。
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(mIv, "scaleX", 1f, 0f, 1f, 0.5f);
                anim2.setDuration(3000);
                anim2.start();
                break;
            case R.id.but4:
                //透明
//                / 将直接把TextView这个view对象的透明度渐变。
                // 注意第二个参数："alpha"，指明了是透明度渐变属性动画
                // 透明度变化从1—>0.1—>1—>0.5—>1，TextView对象经历4次透明度渐变
                ObjectAnimator anim3 = ObjectAnimator.ofFloat(mIv, "alpha", 1f, 0.1f, 1f, 0.5f, 1f);
                anim3.setDuration(3000);// 动画持续时间
                anim3.start();
                break;
            case R.id.but5:
                //改变背景颜色
                ObjectAnimator objectAnimatorBg = ObjectAnimator.ofInt(mBut5, "backgroundColor", Color.YELLOW, Color.RED);
                objectAnimatorBg.setDuration(3000);
                objectAnimatorBg.start();
                break;
            case R.id.but6:
                //综合1
                /**动画组合**/
                AnimatorSet animatorSetGroup1 = new AnimatorSet();
                ObjectAnimator objectAnimatorScaleX1 = ObjectAnimator.ofFloat(mIv, "scaleX", 0f, 1f);
                ObjectAnimator objectAnimatorScaleY1 = ObjectAnimator.ofFloat(mIv, "scaleY", 0f, 1f);
                ObjectAnimator objectAnimatorRotateX1 = ObjectAnimator.ofFloat(mIv, "rotationX", 0f, 360f);
                ObjectAnimator objectAnimatorRotateY1 = ObjectAnimator.ofFloat(mIv, "rotationY", 0f, 360f);
                animatorSetGroup1.setDuration(1000);
                animatorSetGroup1.play(objectAnimatorScaleX1).with(objectAnimatorScaleY1)
                        .before(objectAnimatorRotateX1).before(objectAnimatorRotateY1);
                animatorSetGroup1.start();


                break;
            case R.id.but7:
                //综合2

                /**动画组合**/
                PropertyValuesHolder objectAnimatorScaleX = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f);
                PropertyValuesHolder objectAnimatorScaleY = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f);
                PropertyValuesHolder objectAnimatorTranslationX = PropertyValuesHolder.ofFloat("translationX", 0F, 500f, 0f);
//                PropertyValuesHolder objectAnimatorTranslationY = PropertyValuesHolder.ofFloat("translationY", 0f, 1f);
                /**同时播放两个动画**/
                ObjectAnimator.ofPropertyValuesHolder(mIv, objectAnimatorScaleX, objectAnimatorScaleY, objectAnimatorTranslationX).setDuration(1000).start();
                break;


        }
    }
}

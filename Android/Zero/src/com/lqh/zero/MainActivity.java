package com.lqh.zero;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import android.os.Bundle;
import android.widget.Toast;



public class MainActivity extends UnityPlayerActivity {
	
	//单例模式
	private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
     
        instance = this;
    }

    

    
    /**
     * 供Unity调用的求和函数
     * @param x
     * @param y
     * @return
     */
    public int Sum(int x, int y) {
        return x + y;
    }

    /**供Unity调用的比较最大值函数
     * @param x
     * @param y
     * @return
     */
    public int Max(int x, int y) {
        return Math.max(x, y);
    }

    
    /**供Unity调用的显示吐司的函数
     * @param str
     */
    public void MakeToast(String str) {
    	//实现在unity中调起一个安卓的提示框
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    
    /**供Unity调用的自加一函数
     * @param x
     * @return
     */
    public int AddOne(int x) {
        return x + 1;
    }

    
    /**供Unity调用的静态方法，单例类，返回当前的Activity对象
     * @return
     */
    public static MainActivity GetInstance() {
        return instance;
    }
    
    
    
    /**供Unity调用的函数，此函数会回调指定的一个Unity中的方法，完成数据的双向交互
     * @param str
     */
    public void CallUnityFunc(String str){
        str=str+"Android  Call  Unity. 我是安卓的参数";    //方法的参数
        String ReceiveObject="Main Camera";    //这个是脚本挂载对象
        String ReceiverMethod="Receive";		//脚本中的方法名
        UnityPlayer.UnitySendMessage(ReceiveObject, ReceiverMethod, str);  //调用unity的方法  实现回调unity
    }
}

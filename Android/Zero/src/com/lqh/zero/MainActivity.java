package com.lqh.zero;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import android.os.Bundle;
import android.widget.Toast;



public class MainActivity extends UnityPlayerActivity {
	
	//����ģʽ
	private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
     
        instance = this;
    }

    

    
    /**
     * ��Unity���õ���ͺ���
     * @param x
     * @param y
     * @return
     */
    public int Sum(int x, int y) {
        return x + y;
    }

    /**��Unity���õıȽ����ֵ����
     * @param x
     * @param y
     * @return
     */
    public int Max(int x, int y) {
        return Math.max(x, y);
    }

    
    /**��Unity���õ���ʾ��˾�ĺ���
     * @param str
     */
    public void MakeToast(String str) {
    	//ʵ����unity�е���һ����׿����ʾ��
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    
    /**��Unity���õ��Լ�һ����
     * @param x
     * @return
     */
    public int AddOne(int x) {
        return x + 1;
    }

    
    /**��Unity���õľ�̬�����������࣬���ص�ǰ��Activity����
     * @return
     */
    public static MainActivity GetInstance() {
        return instance;
    }
    
    
    
    /**��Unity���õĺ������˺�����ص�ָ����һ��Unity�еķ�����������ݵ�˫�򽻻�
     * @param str
     */
    public void CallUnityFunc(String str){
        str=str+"Android  Call  Unity. ���ǰ�׿�Ĳ���";    //�����Ĳ���
        String ReceiveObject="Main Camera";    //����ǽű����ض���
        String ReceiverMethod="Receive";		//�ű��еķ�����
        UnityPlayer.UnitySendMessage(ReceiveObject, ReceiverMethod, str);  //����unity�ķ���  ʵ�ֻص�unity
    }
}

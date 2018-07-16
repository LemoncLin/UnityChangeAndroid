using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System;

public class Test : MonoBehaviour {

	private AndroidJavaClass _jc;
	private AndroidJavaObject _jo;

	public InputField inputFieldA;
	public InputField inputFiledB;
	public Text resultLabel;

	
	void Start()
	{
		//初始化
		//"com.unity3d.player.UnityPlayer"和"currentActivity"这两个参数都是固定的
		//UnityPlayerActivity里面对其进行了处理
		_jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		_jo = _jc.GetStatic<AndroidJavaObject>("currentActivity");
	}

	public void AddOne()
	{
		int a = Convert.ToInt32(inputFieldA.text);
		//这里的话就是指向自己需要的类对象
		//注意，这里使用的就不是之前默认的com.unity3d.player.UnityPlayer，而是需要传入自己的类（实现了需要调用相应方法的类）
		//因为默认的UnityPlayer中是没有我们所需要的方法的，所以需要加载自己的类
		
		AndroidJavaClass jc = new AndroidJavaClass("com.lqh.zero.MainActivity");
		
		//调用Java中的静态方法，单例模式，返回当前Activity实例
		
		AndroidJavaObject jo = jc.CallStatic<AndroidJavaObject>("GetInstance");
		resultLabel.text = "AddOne : " + jo.Call<int>("AddOne",a);
	}

	public void Sum()
	{
		int a =  Convert.ToInt32(inputFieldA.text);
		int b =  Convert.ToInt32(inputFiledB.text);

		//调用Java类中的普通方法，返回值为int型
		resultLabel.text = "Sum : " + _jo.Call<int>("Sum", a, b);
	}

	public void Max()
	{
		int a = Convert.ToInt32(inputFieldA.text);
		int b = Convert.ToInt32(inputFiledB.text);
		
		resultLabel.text = "Max : " + _jo.Call<int>("Max", a, b);
	}

	
	public void CallUnityFunc()
	{
		//调用Java中的一个方法，该方法会回调Unity中的指定的一个方法，这里会回调Receive( )
		_jo.Call("CallUnityFunc","Unity Call Android.我来自unity的参数\n");
	}

	//这是被回调的方法
	public void Receive(string str)
	{
		resultLabel.text = str;
	}


	//调用Android的 弹窗提示
	public void Toast()
	{
		_jo.Call("MakeToast","Unity 调用Android的Toast提示");
	}
}
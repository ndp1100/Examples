using UnityEngine;
using UnityEngine.UI;
using System.Collections;


public class AndroidPluginManager : MonoBehaviour {
    public static AndroidPluginManager instance;
    public Text CountLabel;


#if UNITY_ANDROID
    AndroidJavaClass jc;
#endif

    void Awake()
    {
        instance = this;

        Init();
    }

    public void Init()
    {
#if UNITY_ANDROID
        jc = new AndroidJavaClass("vn.com.phuongnd.androidplugin.MainActivity");
        Debug.Log("JavaClass -----------------> " + jc);
#endif
    }

    public void ShowToast()
    {
#if UNITY_ANDROID
        jc.CallStatic("requestToast", "Message be called from Unity");
#endif
    }

    public void OnRequestToast(string count)
    {
        CountLabel.text = "Count = " + count;
    }
}

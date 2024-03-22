#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_phuong_jniandroid_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jint JNICALL
Java_com_phuong_jniandroid_MainActivity_sumFromJNI(JNIEnv *env,jobject obj, jint a, jint b){
    return  a + b;
}
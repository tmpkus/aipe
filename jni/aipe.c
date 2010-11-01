/*
 * aipe.c
 *
 *  Created on: Oct 25, 2010
 *      Author: malonso
 */

#include <jni.h>
#include <android/bitmap.h>

#define NATIVE_FUNCTION(type, name) JNIEXPORT type JNICALL Java_crl_research_aipe_aipe_ ## name

NATIVE_FUNCTION(void, negative)(JNIEnv * env, jobject  obj, jobject bitmap) {

    AndroidBitmapInfo  info;
    void* pixels;

}

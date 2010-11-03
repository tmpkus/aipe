/*
 * aipe.c
 *
 *  Created on: Oct 25, 2010
 *      Author: malonso
 */

#include <jni.h>
#include <time.h>
#include <android/log.h>
#include <android/bitmap.h>

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define  LOG_TAG    "libaipe"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#define NATIVE_FUNCTION(type, name) JNIEXPORT type JNICALL Java_crl_research_aipe_aipe_ ## name

static void negative(AndroidBitmapInfo* info, void* pixels){
	int xx,yy, red = 0, green, blue;
	uint32_t* line;

	for(yy = 0; yy < info->height; yy++){
		line = (uint32_t*)pixels;
		for(xx =0; xx < info->width; xx++){

			red = 255 - (int) ((line[xx] & 0x00FF0000) >> 16);
			green = 255 - (int)((line[xx] & 0x0000FF00) >> 8);
			blue = 255 - (int) (line[xx] & 0x00000FF );
			line[xx]= 	((red << 16) & 0x00FF0000 ) |
						((green << 8) & 0x0000FF00) |
						( (blue ) & 0x000000FF);
		}
		pixels = (char*)pixels + info->stride;
	}
}

NATIVE_FUNCTION(void, negative)(JNIEnv * env, jobject  obj, jobject bitmap) {

    AndroidBitmapInfo  info;
    int ret;
    void* pixels;

    if ((ret = AndroidBitmap_getInfo(env, bitmap, &info)) < 0) {
            LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
            return;
        }
    if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888) {
        LOGE("Bitmap format is not RGBA_8888 !");
        return;
    }

    if ((ret = AndroidBitmap_lockPixels(env, bitmap, &pixels)) < 0) {
        LOGE("AndroidBitmap_lockPixels() failed ! error=%d", ret);
    }

    // do negative of image
    negative(&info,pixels);

    AndroidBitmap_unlockPixels(env, bitmap);

}

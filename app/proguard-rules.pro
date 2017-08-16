# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/baidu/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#-dontwarn
#-dontnote
-ignorewarnings

-keep class android.**{*;}
-keep public class * extends android.view
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.V4.**
-keep public class * extends android.vending.licensing.ILicensingService
-dontwarn android.support.v4.**
-keep class * extends android.support.v4.**{*;}
-dontwarn android.support.v7.**
-keep class * extends android.support.v7.**{*;}

-keep public class com.picturetagview.PictureTagView

#-assumenosideeffects class android.util.Log {
#public static *** d(...);
#public static *** e(...);
#public static *** i(...);
#public static *** v(...);
#public static *** println(...);
#public static *** w(...);
#public static *** wtf(...);
#}

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int d(...);
    public static int w(...);
    public static int v(...);
    public static int i(...);
}
# AndroidUI<br />
Android App for the frobomind mobile robot, using ROSjava<br />

This guide will help you make an app that connects to a roscore on the network and publish images from the camera.<br />
Before you start you must have ROS indigo and Android Studio install on Ubuntu.<br />

Set PATH of android studio and sdk: <br />
$ echo export PATH=\${PATH}:/opt/Android/Sdk/tools:/opt/Android/Sdk/platform-tools:/opt/android-studio/bin >> ~/.bashrc<br />
$ echo export ANDROID_HOME=/opt/Android/Sdk >> ~/.bashrc<br />

Make sure you have installed:<br />
Android SDK Build Tools 21.2 (21.1.2 should work fine)<br />
Android APIs: <br />
	10 (gingerbread)<br />
	13 (honeycomb)<br />
	15 (ice cream)<br />
	18 (jellybean)<br />
	21 (LOLLIPOP). <br />
Use the standalone SDK Manager, otherwise you wont be able to find all API's (can be launced from within Android Stuido)<br />

Complete step 2 and 3.1 in this guide (http://wiki.ros.org/rosjava/Tutorials/indigo/Source%20Installation).<br />
Follow this guide (http://wiki.ros.org/android/Tutorials/indigo/Installation%20-%20ROS%20Development%20Environment) (from step 4.1).<br />
When you have completed step 5.1 you got an app that, connects to the roscore and published images from the mobile camera.<br />


#To create a new workspace with the git repo <br />
(Not tested!)<br />
Prerequisites: Android studio with API 15 installed(use the stand alone sdk manager).<br />
//open bashrc<br />
$ sudo gedit ~/.bachrc<br />
add the following at the button<br />
export PATH=${PATH}:/YourPath/Android/Sdk/tools:/YourPath/Android/Sdk/platform-tools:/YourPath/android-studio/bin<br />
export ANDROID_HOME=/YourPath/Android/Sdk<br />

//clone the repo<br />
$ git clone "repo url"<br />
$ cd AndroidUI<br />
$ catkin_make<br />
$ source devel/setup.bash<br />
//start android studio from the same terminal<br />
$ /YourPath/android-studio/bin/studio.sh<br />
<br />
Now Import (not open!) project at the path AndroidUI/src/android_ui in android studio<br />

you should now be good to go.<br />






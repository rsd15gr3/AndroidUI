# AndroidUI<br />
Android App for the frobomind mobile robot, using ROSjava<br />

#Creating a workspace with the git repo<br />
(Tested on windows)<br />
Prerequisites: Android studio with API 15 installed, but android studio normaly finds missing API by itself, and ask you to install.<br />
//open bashrc (skip on windows)<br />
$ sudo gedit ~/.bachrc (skip on windows)<br />
//add the following at the button (skip on windows)<br />
export PATH=${PATH}:/YourPath/Android/Sdk/tools:/YourPath/Android/Sdk/platform-tools:/YourPath/android-studio/bin<br />
export ANDROID_HOME=/YourPath/Android/Sdk<br />

//clone the repo (start from here on windows, The example uses "git bash")<br />
$ git clone "repo url"<br />
$ source devel/setup.bash (skip on windows)<br />
//start android studio from the same terminal (skip on windows)<br />
$ /YourPath/android-studio/bin/studio.sh (skip on windows, just start android studio)<br />
<br />
Now Import (not open!) project at the path AndroidUI/src/android_ui in android studio<br />

you should now be good to go.<br />

#Getting stated with ROSjava and Android Core
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









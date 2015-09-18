# AndroidUI
Android App for the frobomind mobile robot, using ROSjava

This guide will help you make an app that connects to a roscore on the network and publish images from the camera.
Before you start you must have ROS indigo and Android Studio install on Ubuntu.

Set PATH of android studio and sdk: 
$ echo export PATH=\${PATH}:/opt/Android/Sdk/tools:/opt/Android/Sdk/platform-tools:/opt/android-studio/bin >> ~/.bashrc
$ echo export ANDROID_HOME=/opt/Android/Sdk >> ~/.bashrc

Make sure you have installed:
Android SDK Build Tools 21.2 (21.1.2 should work fine)
Android APIs: 
	10 (gingerbread)
	13 (honeycomb)
	15 (ice cream)
	18 (jellybean)
	21 (LOLLIPOP). 
Use the standalone SDK Manager, otherwise you wont be able to find all API's (can be launced from within Android Stuido)

Complete step 2 and 3.1 in this guide (http://wiki.ros.org/rosjava/Tutorials/indigo/Source%20Installation).
Follow this guide (http://wiki.ros.org/android/Tutorials/indigo/Installation%20-%20ROS%20Development%20Environment) (from step 4.1). When you have completed step 5.1 you got an app that, connects to the roscore and published images from the mobile camera.


#To create a new workspace with the git repo 
(Nottested!)
Prerequisites: Android studio with API 15 installed(use the stand alone sdk manager).
//open bashrc
$ sudo gedit ~/.bachrc
add the following at the button
export PATH=${PATH}:/YourPath/Android/Sdk/tools:/YourPath/Android/Sdk/platform-tools:/YourPath/android-studio/bin
export ANDROID_HOME=/YourPath/Android/Sdk

//clone the repo
$ git clone "repo url"
$ cd AndroidUI
$ catkin_make
$ source devel/setup.bash
//start android studio from the same terminal
$ /YourPath/android-studio/bin/studio.sh

Now Import (not open!) project at the path AndroidUI/src/android_ui in android studio

you should now be good to go.






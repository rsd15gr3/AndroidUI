package dk.rsd_grp3.ros_java.android_ui.ui;

/**
 * Created by turner on 9/17/15.
 */
import android.widget.Toast;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import std_msgs.*;
import std_msgs.String;


public class SubscriberMessages extends AbstractNodeMain {

    _onMessageRecived messagecallback = new _onMessageRecived() {
        public void onMessageRecived(java.lang.String msg) {

        }
    };

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("android/listener");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
        final Log log = connectedNode.getLog();
        Subscriber<std_msgs.String> subscriber = connectedNode.newSubscriber("/chatter", std_msgs.String._TYPE);
        subscriber.addMessageListener(new MessageListener<std_msgs.String>() {
            @Override
            public void onNewMessage(std_msgs.String message) {
                java.lang.String str = message.getData();
                log.info("I heard: \"" + str + "\"");
                messagecallback.onMessageRecived(str);
            }
        });
    }

    public interface _onMessageRecived{
        void onMessageRecived(java.lang.String msg);
    }
}

package dk.rsd_grp3.ros_java.android_ui.ui;

//import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ros.android.RosActivity;
import org.ros.node.NodeMainExecutor;
import org.ros.node.NodeConfiguration;

public class Ui extends RosActivity implements SubscriberMessages._onMessageRecived
{
    private PublishButtons Buttontalker;
    private SubscriberMessages MessageListener;
    public Ui() {
        // The RosActivity constructor configures the notification title and ticker
        // messages.
        super("RSD Frobomind Robot UI", "RSD Frobomind Robot UI");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);

        button1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(1);
                return false;
            }
        });
        button2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(2);
                return false;
            }
        });
        button3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(3);
                return false;
            }
        });
        button4.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(4);
                return false;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
    }

    public void releasedButton(){
        Buttontalker.updateKey(0);
    }
    public void updateButton(int _Buttonnumber){
        Buttontalker.updateKey(_Buttonnumber);
    }


    public void onMessageRecived(String msg)
    {
        TextView text = (TextView) findViewById(R.id.TextBox);
        text.setText(msg);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        Buttontalker = new PublishButtons();
        MessageListener = new SubscriberMessages();
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(Buttontalker, nodeConfiguration);
        nodeMainExecutor.execute(MessageListener,nodeConfiguration);
    }
}

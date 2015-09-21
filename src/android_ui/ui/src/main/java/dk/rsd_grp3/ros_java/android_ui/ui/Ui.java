package dk.rsd_grp3.ros_java.android_ui.ui;

//import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.ros.android.RosActivity;
import org.ros.node.NodeMainExecutor;
import org.ros.node.NodeConfiguration;

public class Ui extends RosActivity
{
    private PublishButtons Buttontalker;
    private SubscriberMessages MessageListener;
    private ScrollView consoleview;
    private TextView consoleTextView;
    private String consoleText = "";
    private Vibrator myVib;
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
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        consoleTextView = (TextView) findViewById(R.id.TextBox);
        consoleview = (ScrollView) findViewById(R.id.ConsoleScrollView);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);


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
        button5.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(5);
                return false;
            }
        });
        button6.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(6);
                return false;
            }
        });
        button7.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(7);
                return false;
            }
        });
        button8.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                updateButton(8);
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
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                releasedButton();
            }
        });


        //Style, styling from code, (easyest way to keep button style)
        button4.getBackground().setColorFilter(0xFF661111, PorterDuff.Mode.MULTIPLY);
        button2.getBackground().setColorFilter(0xFF116611, PorterDuff.Mode.MULTIPLY);
        button5.getBackground().setColorFilter(0xFF116611, PorterDuff.Mode.MULTIPLY);
        button6.getBackground().setColorFilter(0xFF116611, PorterDuff.Mode.MULTIPLY);
        button7.getBackground().setColorFilter(0xFF116611, PorterDuff.Mode.MULTIPLY);
    }

    public void releasedButton(){
        Buttontalker.updateKey(0);
        myVib.vibrate(50);
    }
    public void updateButton(int _Buttonnumber){
        Buttontalker.updateKey(_Buttonnumber);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        Buttontalker = new PublishButtons();
        MessageListener = new SubscriberMessages();
        MessageListener.handler = this.handler;
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(Buttontalker, nodeConfiguration);
        nodeMainExecutor.execute(MessageListener, nodeConfiguration);
    }

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            consoleText += "\n" + "> " + (String) msg.obj;
            consoleTextView.setText(consoleText);
            consoleview.fullScroll(View.FOCUS_DOWN);
            super.handleMessage(msg);
        }
    };

    @Override //restore text in console after screen rotation
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Read values from the "savedInstanceState"-object and put them in console
        consoleText = savedInstanceState.getString("consoleText","");
        consoleTextView.setText(consoleText);
    }

    @Override //save text in console before screen rotation
    protected void onSaveInstanceState(Bundle outState) {
        // Save the values you need from console into "outState"-object
        outState.putString("consoleText", consoleText);
        super.onSaveInstanceState(outState);
    }

}

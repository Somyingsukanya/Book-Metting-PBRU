package prorassameepbru.sukanya.bookmeetingpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SingUpActivity extends AppCompatActivity {

    private EditText nameEditText,surnameEditText,idCardEditText,
            userEditText,passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton officeRadioButton,outofficeRadioButton;
    private String nameString,surnameString,idCardString,
    userString,passwordString,officeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        // Bind Widget
        bindWidget();

        // Radio Controller
        radioController();

    } // Main Method

    private void radioController() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton:
                        officeString="0";
                        break;
                    case R.id.radioButton2:
                        officeString="1";
                        break;
                    default:
                        officeString="0";
                        break;
                }

            }
        });
    }

    private void  bindWidget() {
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText)findViewById(R.id.editText2);
        idCardEditText = (EditText)findViewById(R.id.editText3);
        userEditText = (EditText)findViewById(R.id.editText4);
        passwordEditText = (EditText)findViewById(R.id.editText5);
        radioGroup = (RadioGroup) findViewById(R.id.ragoffice);
        officeRadioButton = (RadioButton) findViewById(R.id.radioButton);
        outofficeRadioButton = (RadioButton) findViewById(R.id.radioButton2);
    }

    public void clickSignUpSign(View view) {
        nameString = nameEditText.getText() .toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        idCardString = idCardEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกข้อมูลทุกช่อง");
        }else if (idCardString.length()!=13) { //Check idCard
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "รหัสบัตรประชาชนไม่ถูกต้อง",
                    "รหัสบัตรประชาชนของคุณต้องมี 13 หลักเท่านั้น");
        }else if (checkRadioChoose()) {
           //Non Check
            MyAlert myAlert=new MyAlert();
            myAlert.myDialog(this,"ยังไม่ได้เลือกสถานะ",
                    "โปรดเลือกสถานะด้วยค่ะ");
        } else{

           uploadValuetoServer();
        }




    } //ClickSign

    private void uploadValuetoServer() {

        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormEncodingBuilder()
                .add("isAdd","true")
                .add("Name",nameString)
                .add("Surname",surnameString)
                .add("IDcard",idCardString)
                .add("Office",officeString)
                .add("User",userString)
                .add("Password",passwordString)
                .build();
        Request.Builder builder=new Request.Builder();
        Request request=builder.url("http://swiftcodingthai.com/pbru/add_user_master.php")
                .post(requestBody).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                finish();
            }
        });
    }//uploadValue

    private boolean checkRadioChoose() {
        boolean result=true;

        result=officeRadioButton.isChecked()||outofficeRadioButton.isChecked();

        return !result;
    }

    private boolean checkSpace() {
        boolean result = true;
        result = nameString.equals("")||
                surnameString.equals("")||
                idCardString.equals("")||
                userString.equals("")||
                passwordString.equals("");

        return result;
    }
} // Main Class


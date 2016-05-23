package prorassameepbru.sukanya.bookmeetingpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

    } // Main Method

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
        }else if (idCardString.length()!=13){ //Check idCard
            MyAlert myAlert=new MyAlert();
            myAlert.myDialog(this,"รหัสบัตรประชาชนไม่ถูกต้อง",
                    "รหัสบัตรประชาชนของคุณต้องมี 13 หลักเท่านั้น");
        }




    } //ClickSign

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


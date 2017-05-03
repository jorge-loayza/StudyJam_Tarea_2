package com.example.koko.studyjam_tarea_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView expresion;
    private TextView resultado;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;
    private TextView tv_6;
    private TextView tv_7;
    private TextView tv_8;
    private TextView tv_9;
    private TextView tv_0;
    private TextView tv_sumar;
    private TextView tv_restar;
    private TextView tv_multiplicar;
    private TextView tv_dividir;
    private TextView tv_igual;
    private TextView tv_borrar;
    private boolean operando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    public void initUI(){
        expresion = (TextView)findViewById(R.id.tvExpresion);
        resultado = (TextView)findViewById(R.id.tvResultado);
        tv_1 = (TextView) findViewById(R.id.tvUno);
        tv_2 = (TextView) findViewById(R.id.tvDos);
        tv_3 = (TextView) findViewById(R.id.tvTres);
        tv_4 = (TextView) findViewById(R.id.tvCuatro);
        tv_5 = (TextView) findViewById(R.id.tvCinco);
        tv_6 = (TextView) findViewById(R.id.tvSeis);
        tv_7 = (TextView) findViewById(R.id.tvSiete);
        tv_8 = (TextView) findViewById(R.id.tvOcho);
        tv_9 = (TextView) findViewById(R.id.tvNueve);
        tv_0 = (TextView) findViewById(R.id.tvCero);
        tv_sumar = (TextView) findViewById(R.id.tvSuma);
        tv_restar = (TextView) findViewById(R.id.tvResta);
        tv_multiplicar = (TextView) findViewById(R.id.tvMultiplicacion);
        tv_dividir = (TextView) findViewById(R.id.tvDivision);
        tv_igual = (TextView) findViewById(R.id.tvIgual);
        tv_borrar = (TextView) findViewById(R.id.tvCE);
        operando = false;

        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);
        tv_4.setOnClickListener(this);
        tv_5.setOnClickListener(this);
        tv_6.setOnClickListener(this);
        tv_7.setOnClickListener(this);
        tv_8.setOnClickListener(this);
        tv_9.setOnClickListener(this);
        tv_0.setOnClickListener(this);
        tv_sumar.setOnClickListener(this);
        tv_restar.setOnClickListener(this);
        tv_multiplicar.setOnClickListener(this);
        tv_dividir.setOnClickListener(this);
        tv_igual.setOnClickListener(this);
        tv_borrar.setOnClickListener(this);
    }

    public float realizaoperacion(String exp){
        float res = 0;
        String op1="";
        String op2="";
        int op=0;
        boolean sw = false;
        for (int i = 0; i< exp.length();i++){
            char dig = exp.charAt(i);
            switch (dig){
                case '+':
                    sw = true;
                    op = 1;
                    break;
                case '-':
                    sw = true;
                    op = 2;
                    break;
                case '*':
                    sw = true;
                    op = 3;
                    break;
                case '/':
                    sw = true;
                    op = 4;
                    break;
                default:
                    if (!sw){
                        op1 = op1+dig;
                    }else {
                        op2 = op2+dig;
                    }
            }
        }
        int o1 = Integer.parseInt(op1);
        int o2 = Integer.parseInt(op2);
        switch (op){
            case 1:
                res = o1+o2;
                resultado.setText(res+"");
                break;
            case 2:
                res = o1+o2;
                resultado.setText(res+"");
                break;
            case 3:
                res = o1*o2;
                resultado.setText(res+"");
                break;
            case 4:
                if (o2>0){
                    res= o1/o2;
                    resultado.setText(res+"");
                }else {
                    Toast.makeText(getApplicationContext(),"No se puede dividir entre cero",Toast.LENGTH_SHORT);
                }
        }
        Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG);
        return res;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvUno:
                expresion.setText(expresion.getText()+"1");
                break;
            case R.id.tvDos:
                expresion.setText(expresion.getText()+"2");
                break;
            case R.id.tvTres:
                expresion.setText(expresion.getText()+"3");
                break;
            case R.id.tvCuatro:
                expresion.setText(expresion.getText()+"4");
                break;
            case R.id.tvCinco:
                expresion.setText(expresion.getText()+"5");
                break;
            case R.id.tvSeis:
                expresion.setText(expresion.getText()+"6");
                break;
            case R.id.tvSiete:
                expresion.setText(expresion.getText()+"7");
                break;
            case R.id.tvOcho:
                expresion.setText(expresion.getText()+"8");
                break;
            case R.id.tvNueve:
                expresion.setText(expresion.getText()+"9");
                break;
            case R.id.tvCero:
                expresion.setText(expresion.getText()+"0");
                break;
            case R.id.tvSuma:
                if (!operando){
                    operando = true;
                    expresion.setText(expresion.getText()+"+");
                }else{
                    Toast.makeText(getApplicationContext(),"Borre la operación",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvResta:
                if (!operando){
                    operando = true;
                    expresion.setText(expresion.getText()+"-");
                }else{
                    Toast.makeText(getApplicationContext(),"Borre la operación",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvMultiplicacion:
                if (!operando){
                    operando = true;
                    expresion.setText(expresion.getText()+"*");
                }else{
                    Toast.makeText(getApplicationContext(),"Borre la operación",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvDivision:
                if (!operando){
                    operando = true;
                    expresion.setText(expresion.getText()+"/");
                }else{
                    Toast.makeText(getApplicationContext(),"Borre la operación",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvIgual:
                operando = false;
                realizaoperacion(expresion.getText().toString());
                break;
            case R.id.tvCE:
                operando = false;
                expresion.setText("");
                resultado.setText("");
                break;
        }
    }
}

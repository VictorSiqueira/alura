package com.cadastrocaelum.utils.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.cadastrocaelum.R;
import com.cadastrocaelum.dao.AlunoDAO;

import java.util.Objects;

/**
 * Created by Victor on 01/05/2016.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] mensagens = (Object[]) intent.getExtras().get("pdus");
        byte[] mensagem = (byte[])mensagens[0];

        SmsMessage sms = SmsMessage.createFromPdu(mensagem);

        String telefone = sms.getOriginatingAddress();
        boolean verifyAlumnSms = new AlunoDAO(context).isPhoneAlumn(telefone);
        if(verifyAlumnSms){
            MediaPlayer beep = MediaPlayer.create(context, R.raw.beep);
            beep.start();
        }
    }
}

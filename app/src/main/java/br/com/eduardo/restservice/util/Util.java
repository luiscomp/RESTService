package br.com.eduardo.restservice.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.eduardo.restservice.R;

/**
 * Created by LuisEduardo on 04/12/2015.
 */
public class Util {

    private static ProgressDialog dialog;

    private static final SimpleDateFormat formatoDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");

    private static final SimpleDateFormat formatoDDMMYYYYSB = new SimpleDateFormat("ddMMyyyy");

    private static final SimpleDateFormat formatoMMDDYYYY = new SimpleDateFormat("MM/dd/yyyy");

    private static final SimpleDateFormat formatoYYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat formatoYYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");

    private static final SimpleDateFormat formatoYYYYMMDDSB = new SimpleDateFormat("yyyyMMdd");

    private static final SimpleDateFormat formatoDDMMYYYYHHmm = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    private static final SimpleDateFormat formatoDDMMYYYYHHmmss = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    private static final SimpleDateFormat formatoYYYY_MM_DDHHmmss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    private static final SimpleDateFormat formatoHHmmDDMMYYYY = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    private static final SimpleDateFormat formatoYYYYMMDDHHmmss = new SimpleDateFormat("yyyyMMddhhmmss");

    private static final SimpleDateFormat formatoHHmm = new SimpleDateFormat("hh:mm");

    private static final SimpleDateFormat formatoHH = new SimpleDateFormat("hh");

    private static final SimpleDateFormat formatomm = new SimpleDateFormat("mm");

    private static final SimpleDateFormat formatoDDMM = new SimpleDateFormat("dd/MM");

    private static final NumberFormat formatter = new DecimalFormat("#.##");

    public static final int horaEmMilisegundos = 1000 * 60 * 60;

    public static final int diaEmMilissegundos = 24 * horaEmMilisegundos;

    public static final int MinutoEmMilisegundos = 1000 * 60;

    private static int pinSTART = 10000;
    private static int pinEND = 99999;

    public static Timestamp obterDataDaString(String strDataHora) {
        try {
            return new Timestamp(formatoDDMMYYYY.parse(strDataHora).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp obterDataHoraDaString(String strDataHora) {
        try {
            return new Timestamp(formatoDDMMYYYYHHmmss.parse(strDataHora).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp obterTimesamptDaStringYYYYMMDDHHmmss(String strDataHora) {
        try {
            return new Timestamp(formatoYYYYMMDDHHmmss.parse(strDataHora).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp obterTimesamptDaStringYYYY_MM_DDHHmmss(String strDataHora) {
        try {
            return new Timestamp(formatoYYYY_MM_DDHHmmss.parse(strDataHora).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp obterTimesamptDaStringDDMMYYYYHHmm(String strDataHora) {
        try {
            return new Timestamp(formatoDDMMYYYYHHmm.parse(strDataHora).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static String obterDataHoraAtual() {
        return formatoDDMMYYYYHHmmss.format(new Timestamp(System.currentTimeMillis()));
    }

    public static String formatarTimestampHHmm(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoHHmm.format(timestamp);
        }
    }

    public static String formatarTimestampHH(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoHH.format(timestamp);
        }
    }

    public static String formatarTimestampMM(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatomm.format(timestamp);
        }
    }

    public static String formatarDateHHmm(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoHHmm.format(data);
        }
    }

    public static String formatarTimeHHmm(Time hora) {
        if (hora == null) {
            return null;
        } else {
            return formatoHHmm.format(hora);
        }
    }

    public static String formatarTimestampDDMM(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoDDMM.format(timestamp);
        }
    }

    public static String formatarTimestampDDMMYYYY(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoDDMMYYYY.format(timestamp);
        }
    }

    public static String formatarDateDDMMYYYY(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoDDMMYYYY.format(data);
        }
    }

    public static String formatarDateDDMM(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoDDMM.format(data);
        }
    }

    public static String formatarDateYYYY_MM_DD(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoYYYY_MM_DD.format(data);
        }
    }

    public static String formatarDateYYYYMMDD(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoYYYYMMDD.format(data);
        }
    }

    public static String formatarDateYYYYMMDDSB(Date data) {
        if (data == null) {
            return null;
        } else {
            return formatoYYYYMMDDSB.format(data);
        }
    }

    public static String formatarTimestampDDMMYYYYHHmmss(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoDDMMYYYYHHmmss.format(timestamp);
        }
    }

    public static String formatarTimestampYYYY_MM_DDHHmmss(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoYYYY_MM_DDHHmmss.format(timestamp);
        }
    }

    public static String formatarTimestampDDMMYYYYHHmm(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoDDMMYYYYHHmm.format(timestamp);
        }
    }

    public static String formatarTimestampHHmmDDMMYYYY(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoHHmmDDMMYYYY.format(timestamp);
        }
    }

    public static String formatarTimestampYYYYMMDDSB(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoYYYYMMDDSB.format(timestamp);
        }
    }

    public static String formatarTimestampYYYYMMDD(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return formatoYYYYMMDD.format(timestamp);
        }
    }

    public static boolean stringVazia(String valor) {
        return valor == null || valor.length() == 0 || valor.equals("");
    }

    public static String formatarStringVazia(String valor) {
        if (stringVazia(valor)) {
            return "";
        }
        return valor;
    }

    public static void incluirClausulaNoWhere_AND(StringBuffer select, String clausula) {

        if (select.toString().toUpperCase().lastIndexOf("WHERE") > select.toString().toUpperCase().lastIndexOf("FROM")) {
            select.append(" AND (");
            select.append(clausula);
            select.append(") ");
        } else {
            select.append(" WHERE (");
            select.append(clausula);
            select.append(") ");
        }
    }

    public static void incluirClausulaNoWhere_OR(StringBuffer select, String clausula) {

        if (select.toString().toUpperCase().lastIndexOf("WHERE") > select.toString().toUpperCase().lastIndexOf("FROM")) {
            select.append(" OR (");
            select.append(clausula);
            select.append(") ");
        } else {
            select.append(" WHERE (");
            select.append(clausula);
            select.append(") ");
        }
    }

    public static void incluirCampoNoInsert(StringBuffer insert, String campo) {
        String str = insert.toString().toUpperCase();
        int posicaoParentese = str.substring(0, str.indexOf("VALUES")).indexOf(')');
        insert.insert(posicaoParentese, ", " + campo + " ");
        str = insert.toString().toUpperCase();
        posicaoParentese = str.lastIndexOf(')');
        insert.insert(posicaoParentese, " , ? ");
    }

    public static void incluirCampoNoUpdate(StringBuffer update, String campo) {
        String str = update.toString().toUpperCase();
        update.insert(str.lastIndexOf("WHERE"), ", " + campo + " = ? ");
    }

    public static long converterMsParaMinutosInteiros(long qtdMilisegundos) {
        return Math.round(qtdMilisegundos / 1000.0 / 60.0);
    }

    /**
     * Converte uma quantidade de milisegundos para um numero de minutos ou
     * horas e minutos.
     *
     * @param qtdMilisegundosParados
     * @return
     */
    public static String formatarTempo(long qtdMilisegundosParados) {
        long qtdMinutosParados = Util.converterMsParaMinutosInteiros(qtdMilisegundosParados);
        qtdMinutosParados = (qtdMinutosParados < 0 ? 0 : qtdMinutosParados);
        if (qtdMinutosParados < 60) {
            return qtdMinutosParados + " min";
        }
        if (qtdMinutosParados < 1440) {
            long qtdHoras = qtdMinutosParados / 60;
            long qtdMinutos = qtdMinutosParados % 60;
            return qtdHoras + " h " + qtdMinutos + " min";
        } else {
            long qtdDias = qtdMinutosParados / (24 * 60);
            long qtdHoras = (qtdMinutosParados % (24 * 60)) / 60;
            long qtdMinutos = (qtdMinutosParados % (24 * 60)) % 60;
            return qtdDias + "d " + qtdHoras + "h " + qtdMinutos + "min";
        }
    }

    public static long formatarTempoEmMinutos(long qtdMilisegundosParados) {
        long qtdMinutosParados = Util.converterMsParaMinutosInteiros(qtdMilisegundosParados);
        return (qtdMinutosParados < 0 ? 0 : qtdMinutosParados);

    }

    public static String formatarNumero2Decimais(double numero) {
        return formatter.format(numero);
    }

    public static String formatarPercentual(double numero) {
        return formatter.format(numero * 100) + "%";
    }

    public static Date obterDateDaStringYYYY_MM_DD(String datastr) throws ParseException {
        return new Date(formatoYYYY_MM_DD.parse(datastr).getTime());
    }

    public static Date obterDateDaStringYYYYMMDD(String datastr) throws ParseException {
        return new Date(formatoDDMMYYYY.parse(datastr).getTime());
    }

    public static Date obterDateDaStringDDMMYYYY(String datastr) throws ParseException {
        return new Date(formatoDDMMYYYY.parse(datastr).getTime());
    }

    public static Date obterDateDaStringDDMMYYYYSB(String datastr) throws ParseException {
        return new Date(formatoDDMMYYYYSB.parse(datastr).getTime());
    }

    public static Date obterDateDaStringMMDDYYYY(String datastr) throws ParseException {
        return new Date(formatoMMDDYYYY.parse(datastr).getTime());
    }

    public static Time obterTimeDaStringHHmm(String horaStr) throws ParseException {
        if (horaStr == null || horaStr.trim().equals("")) {
            return null;
        }
        return new Time(formatoHHmm.parse(horaStr).getTime());
    }

    public static Time obterTimeDaStringHH(String horaStr) throws ParseException {
        return new Time(formatoHHmm.parse(horaStr + ":00").getTime());
    }

    public static Time obterTimeDoIntHH(int hora) throws ParseException {
        return new Time(formatoHHmm.parse(hora + ":00").getTime());
    }

    public static Time obterTimeDoTimestamp(Timestamp dataHora) throws ParseException {
        return new Time(dataHora.getTime());
    }

    public static String tratarCampoNulo(String txtValor) {
        if (txtValor == null) {
            return "";
        }
        return txtValor;
    }

    public static String converterHHMM(long qtdMilisegundosParados) {
        long qtdMinutos = Util.converterMsParaMinutosInteiros(qtdMilisegundosParados);
        qtdMinutos = (qtdMinutos < 0 ? 0 : qtdMinutos);
        if (qtdMinutos < 60) {
            if (qtdMinutos < 10) {
                return "00:0" + qtdMinutos;
            } else {
                return "00:" + qtdMinutos;
            }
        } else {
            long tHoras = qtdMinutos / 60;
            long tMinutos = qtdMinutos % 60;
            String strHoras = "";
            String strMinutos = "";
            if (tHoras < 10) {
                strHoras = "0" + tHoras;
            } else {
                strHoras = String.valueOf(tHoras);
            }
            if (tMinutos < 10) {
                strMinutos = "0" + tMinutos;
            } else {
                strMinutos = String.valueOf(tMinutos);
            }
            return strHoras + ":" + strMinutos;
        }

    }

    public static String colocaPontos(String in, int jump) {
        String out = "";
        for (int i = 1; i < in.length() + 1; i++) {
            out += in.charAt(i - 1);
            if (i != 0 && i % jump == 0)
                out += ".";
        }
        return out;
    }

    public static boolean verificaSeEhHoje(Timestamp t) {
        return t.getTime() / diaEmMilissegundos == (new java.util.Date()).getTime() / diaEmMilissegundos;
    }

    public static float arredondarNumero2Decimais(double numero) {
        return Float.parseFloat(formatter.format(numero));
    }

    public static String retiraEspeciais(String str){
        CharSequence cs = new StringBuilder(str.toUpperCase());
        return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static boolean seEmailValido(String email) {
        if((email == null) || (email.trim().length() == 0))
            return false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        final Calendar date = Calendar.getInstance();
        date.set(2014, Calendar.JANUARY, 31);
        date.add(Calendar.MONTH, 1);
        System.out.println(Util.formatarDateDDMMYYYY(new Date(date.getTime().getTime())));
    }

    public static  void exibirMessagemDialog(Context context, String titulo, String texto) {
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle(titulo);
        dialog.setMessage(texto);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static void exibirProgressDialog(Context context, String mensagem) {
        dialog = new ProgressDialog(context);
        dialog.setMessage(mensagem);
        dialog.setCancelable(Boolean.FALSE);
        dialog.show();
    }

    public static void fecharProgressDialog() {
        dialog.dismiss();
    }

    public static int getWidthScreen(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getHeightScreen(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public static String formatarMoeda(Double valor) {
        DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal(true);

        return formatoDois.format(valor);
    }

    public static void criarNotificacaoComSom(Context context, String titulo, String texto, Class<?> classe, Intent intent, int mId){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setColor(Color.argb(255, 188, 57, 52));
        mBuilder.setContentTitle(titulo);
        mBuilder.setContentText(texto);
        mBuilder.setAutoCancel(true);
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setSound(notificationSound);

        if(classe != null) {
            Intent resultIntent = new Intent(context, classe);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(classe);
            if(intent == null) {
                stackBuilder.addNextIntent(resultIntent);
            } else {
                stackBuilder.addNextIntent(intent);
            }

            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            mBuilder.setContentIntent(resultPendingIntent);
        }

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, mBuilder.build());
    }

    public static void criarNotificacaoComSomVibracao(Context context, String titulo, String texto, Class<?> classe, int mId){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setColor(Color.argb(255, 188, 57, 52));
        mBuilder.setContentTitle(titulo);
        mBuilder.setContentText(texto);
        mBuilder.setAutoCancel(true);
        long[] pattern = {0, 200, 300, 200};
        mBuilder.setVibrate(pattern);
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setSound(notificationSound);

        if(classe != null) {
            Intent resultIntent = new Intent(context, classe);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(classe);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
        }

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, mBuilder.build());
    }

    private static void vibrarCelular(Context context) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, 200, 300, 200};
        v.vibrate(pattern, -1);
    }

    private static void reproduzirSomNotificacao(Context context) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A cor apesar de ser int do resource não é válido ao colocar um parâmetro como por exemplo,
     * R.color.mColor
     *
     * @param activity -> mActivity.this
     * @param resColor -> getResource().getColor(R.color.mColor) para versões antigas
     */
    public static void trocarCorDaBarraDeNotificacao(Activity activity, int resColor) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(resColor);
        }
    }

    public static boolean seTemConexaoComInternet(Context context) {
        if(context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static String removerTodosCaracteresExcetoNumeros(String str) {
        return str = str.replaceAll("[^\\d.]", "");
    }

    public static void aplicarImgColorFilter(Context context, ImageView view, int color) {
        if(context != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.setColorFilter(context.getColor(color));
            } else {
                view.setColorFilter(context.getResources().getColor(color));
            }
        }
    }

    public static void ocultarTecladoFragment(Fragment fragment) {
        fragment.getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void ocultarTecladoActivity(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void mostrarViewComAnimacao(Activity activity, View view, int anim) {
        Animation viewAnimation = AnimationUtils.loadAnimation(activity, anim);

        view.setVisibility(View.VISIBLE);
        view.startAnimation(viewAnimation);
    }

    public static void mostrarView(final View v) {
        v.measure(v.getLayoutParams().MATCH_PARENT, v.getLayoutParams().WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();
        if (v.isShown()) {
            esconderView(v);
        } else {
            v.getLayoutParams().height = 0;
            v.setVisibility(View.VISIBLE);
            Animation a = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    v.getLayoutParams().height = interpolatedTime == 1 ? v.getLayoutParams().WRAP_CONTENT: (int) (targtetHeight * interpolatedTime);
                    v.requestLayout();
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };
            a.setDuration(targtetHeight + 500);
            v.startAnimation(a);
        }

    }

    public static void esconderView(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(v.getLayoutParams().height + 500);
        v.startAnimation(a);
    }

    public static String formatarParaDoisDigitos(int valor) {
        if(valor < 10) {
            return "0"+valor;
        }
        return String.valueOf(valor);
    }

    public static Double obterValorParaGravar(String valor) {
        return Double.parseDouble(valor.replace(".", "").replace(",", "."));
    }


    public static String downloadTextVersionCode(String URL) throws IOException {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        in = openHttpConnection(URL);
        InputStreamReader isr = new InputStreamReader(in);
        int charRead;
        String str = "";
        char[] inputBuffer = new char[BUFFER_SIZE];
        while ((charRead = isr.read(inputBuffer)) > 0){
            String readString = String.copyValueOf(inputBuffer, 0, charRead);
            str += readString;
            inputBuffer = new char[BUFFER_SIZE];
        }
        in.close();
        return str;
    }

    private static InputStream openHttpConnection(String urlString) throws IOException{
        InputStream in = null;
        int response = -1;

        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }

        } catch (Exception ex){
            ex.printStackTrace();
            throw new IOException("Error connecting\n");
        }
        return in;
    }

    public interface VerificarEstabilidadeDaConexaoListener {
        void conexaoEstavel();
        void conexaoNaoEstavel();
    }

    public static TextView pegarTextViewToolbar(Toolbar toolbar) {
        TextView toolbarTitle = null;
        for(int i = 0; i < toolbar.getChildCount(); ++i) {
            View child = toolbar.getChildAt(i);

            if(child instanceof TextView) {
                toolbarTitle = (TextView) child;
                break;
            }
        }
        return toolbarTitle;
    }
}

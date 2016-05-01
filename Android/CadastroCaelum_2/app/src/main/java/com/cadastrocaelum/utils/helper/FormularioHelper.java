package com.cadastrocaelum.utils.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.cadastrocaelum.FormularioActivity;
import com.cadastrocaelum.R;
import com.cadastrocaelum.utils.pojo.Aluno;

/**
 * Created by Victor on 23/04/2016.
 */
public class FormularioHelper {

    private final Aluno aluno;
    private EditText edtNome;
    private EditText edtSite;
    private EditText edtEndereco;
    private EditText edtTelefone;
    private Button btnSalvar;
    private RatingBar ratNota;
    private ImageView foto;

    public FormularioHelper(FormularioActivity activity) {
        getElementsOfActivity(activity);
        aluno =  new Aluno();
    }

    /**
     * metodo para pegar todos os elementos da tela e seta-los nas
     * variaveis corretamente
     */
    private void getElementsOfActivity(Activity activity) {
        edtNome = (EditText)activity.findViewById(R.id.edtNome);
        edtSite = (EditText)activity.findViewById(R.id.edtNome);
        edtEndereco = (EditText)activity.findViewById(R.id.edtNome);
        edtTelefone = (EditText)activity.findViewById(R.id.edtNome);
        btnSalvar = (Button) activity.findViewById(R.id.btnSalvar);
        ratNota = (RatingBar) activity.findViewById(R.id.nota);
        foto = (ImageView )activity.findViewById(R.id.foto);
    }

    /**
     * Metodo que recupera os dados da activity e monta um Aluno para
     * ser tratado pelo DAO
     * @return
     */
    public Aluno getAlunoFromFormularioActivity(){
        aluno.setNome(edtNome.getText().toString());
        aluno.setSite(edtSite.getText().toString());
        aluno.setEndereco(edtEndereco.getText().toString());
        aluno.setTelefone(edtTelefone.getText().toString());
        aluno.setNota(ratNota.getRating());
        return aluno;
    }


    /**
     * metodo para setar nos campos do formulario os dados de
     * um usuario passado no paramento, verficado se cada item ta nulo
     * @param aluno
     */
    public void setAluno2UpdateOnFormulario(Aluno aluno) {
        if(aluno.getNome() != null) edtNome.setText(aluno.getNome());
        if(aluno.getSite() != null)edtSite.setText(aluno.getSite());
        if(aluno.getEndereco() != null)edtEndereco.setText(aluno.getEndereco());
        if(aluno.getTelefone() != null)edtTelefone.setText(aluno.getTelefone());
        if(aluno.getNota() != null)ratNota.setRating(aluno.getNota());
        if(aluno.getFoto() != null)carregaImagem(aluno.getFoto());
    }

    public ImageView getFoto(){
        return this.foto;
    }

    public void carregaImagem(String caminhoFt) {
        Aluno aluno = getAlunoFromFormularioActivity();
        aluno.setFoto(caminhoFt);
        Bitmap btmap = BitmapFactory.decodeFile(caminhoFt);
        //Bitmap.createScaledBitmap(btmap,largura,altura,tratamento para nao pixelar);
        btmap = Bitmap.createScaledBitmap(btmap,100,100,true);
        foto.setImageBitmap(btmap);
    }
}
